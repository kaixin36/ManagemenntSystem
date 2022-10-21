<template>
  <div style="width: 100%" class="main_area">
    <!-- 搜索区 -->
    <div class="search_area">
      <el-form ref="formRef" :model="form" label-width="60px">
        <el-form-item label="用户名">
          <el-input v-model="form.name" style="width: 15%"></el-input>
          <el-button
            type="primary"
            icon="Search"
            style="margin-left: 5px"
            @click="findPage"
            >查询</el-button
          >
        </el-form-item>
      </el-form>
    </div>
    <!-- 功能区 -->
    <div class="function_area">
      <el-button type="primary" icon="Plus" @click="add">新增</el-button>
      <el-button type="primary" icon="">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <el-table :data="tableData" stripe border style="width: 100%">
      <el-table-column prop="id" label="id" />
      <el-table-column prop="username" label="用户名" />
      <el-table-column prop="password" label="密码" />
      <el-table-column prop="nickname" label="昵称" />
      <el-table-column prop="age" label="年龄" />
      <el-table-column prop="sex" label="性别" />
      <el-table-column prop="address" label="地址" />
      <el-table-column fixed="right" label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-popconfirm title="Are you sure to delete this?">
            <template #reference>
              <el-button type="danger" size="small" @click="handleDelete"
                >删除</el-button
              >
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div>
      <el-pagination
        v-model:currentPage="currentPage"
        :page-sizes="[5, 10, 20]"
        :page-size="currentPage"
        :page-count="pageCount"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      >
      </el-pagination>

      <el-dialog
        v-model="dialogVisible"
        title="新增用户"
        width="30%"
        :before-close="handleClose"
      >
        <el-form ref="formRef" :model="form" label-width="120px">
          <el-form-item label="用户名">
            <el-input v-model="form.username" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="form.nickname" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="form.age" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio-group v-model="form.sex">
              <el-radio label="1">男</el-radio>
              <el-radio label="2">女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="地址">
            <el-input
              type="textarea"
              v-model="form.address"
              style="width: 80%"
            ></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="save">确定</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request.js";

export default {
  name: "Home",
  data() {
    return {
      //新增
      form: {
        id: 0,
        username: 6,
        nickname: 6,
        age: 6,
        sex: 6,
        address: 5,
      },

      search: "",
      currentPage: 1,
      pageSize: 10,
      pageCount: 0,
      total: 0,
      tableData: [],
      // 新增对话框
      dialogVisible: false,
    };
  },
  created() {
    this.findPage();
  },
  methods: {
    findPage() {
      request
        .post("/user/findByPage", {
          // params: {
          //   pageNum: this.currentPage,
          //   pageSize: this.pageSize,
          //   search: this.search,
          // },
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search,
        })
        .then((res) => {
          this.tableData = res.data.data;
          this.total = res.data.total;
          this.pageCount = res.data.pages;
        });
    },
    // 新增
    add() {
      this.dialogVisible = true;
      this.form = {};
    },
    save() {
      let url;
      if (this.form.id) {
        url = "/user/update";
        request.put(url, this.form).then((res) => {
          this.findPage();
          this.dialogVisible = false;
        });
      } else {
        url = "/user/save";
        request.post(url, this.form).then((res) => {
          this.findPage();
          this.dialogVisible = false;
        });
      }
    },
    // 编辑
    handleEdit(index, row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.dialogVisible = true;
    },
    // 删除
    handleDelete() {},

    handleSizeChange() {
      this.findPage();
    },
    handleCurrentChange() {
      this.findPage();
    },
  },
};
</script>

<style scoped>
.function_area {
  margin: 10px 0;
}

.search_area {
  margin: 10px 0;
}
.main_area {
  padding: 10px;
}
</style>