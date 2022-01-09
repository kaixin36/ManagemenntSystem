<template>
  <div style="width: 100%" class="main_area">
    <!-- 功能区 -->
    <div class="function_area">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <!-- 搜索区 -->
    <div class="search_area">
      <el-input
        v-model="search"
        placeholder="请输入关键字"
        style="width: 20%"
      />
      <el-button type="primary" style="margin-left: 5px">查询</el-button>
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
        <template #default>
          <el-button size="small" @click="handleEdit">编辑</el-button>
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
        :page-size="10"
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
          <el-form-item label="年龄">
            <el-radio-group v-model="form.age">
              <el-radio label="1">男</el-radio>
              <el-radio label="2">女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="性别">
            <el-input v-model="form.sex" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input type="textarea" v-model="form.address" style="width: 80%"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="save"
              >确定</el-button
            >
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
        username: 6,
        nickname: 6,
        age: 6,
        sex: 6,
        address: 5,
      },

      search: "",
      currentPage: 1,
      total: 10,
      tableData: [],
      // 新增对话框
      dialogVisible: false,
    };
  },
  methods: {
    // 新增
    add() {
      this.dialogVisible = true;
      this.form={};
    },
    save() {
      request.post("/user/save",this.form).then(res=>{
        console.log("dd");
      });
    },
    // 编辑
    handleEdit() {},
    // 删除
    handleDelete() {},

    handleSizeChange() {},
    handleCurrentChange() {},
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