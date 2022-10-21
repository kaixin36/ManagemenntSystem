<template>
  <div style="width: 100%" class="main_area">
    <!-- 功能区 -->
    <div class="function_area">
      <el-button type="primary" @click="add">新增</el-button>
    </div>
    <!-- 搜索区 -->
    <div class="search_area">
      <el-input
        v-model="search"
        placeholder="请输入关键字"
        style="width: 20%"
      />
      <el-button type="primary" style="margin-left: 5px" @click="findPage"
        >查询</el-button
      >
    </div>
    <el-table :data="tableData" stripe border style="width: 100%">
      <el-table-column prop="id" label="id" />
      <el-table-column prop="username" label="角色名称" />
      <el-table-column prop="password" label="数据状态" />
      <el-table-column prop="nickname" label="备注" />
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
    </div>
    <el-dialog
      v-model="dialogVisible"
      title="新增角色"
      width="30%"
      :before-close="handleClose"
    >
      <el-form ref="formRef" :model="form" label-width="120px">
        <el-form-item label="角色名称">
          <el-input v-model="form.name" style="width: 80%"></el-input>
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
        .post("/user/findByPage1", {
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