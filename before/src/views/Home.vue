<template>
  <div style="width: 100%" class="main_area">
    <!-- 功能区 -->
    <div class="function_area">
      <el-button type="primary">新增</el-button>
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
      <el-table-column prop="date" label="日期" />
      <el-table-column prop="name" label="姓名" />
      <el-table-column prop="address" label="地址" />
      <el-table-column fixed="right" label="" width="120">
        <template #default>
          <el-button type="text" size="small" @click="handleEdit"
            >编辑</el-button
          >
          <el-button type="text" size="small" @click="handleDelete"
            >删除</el-button
          >
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
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "Home",
  data() {
    return {
      search: "",
      currentPage: 1,
      total: 10,
      tableData: [
        {
          date: "2016-05-03",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
        {
          date: "2016-05-02",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
        {
          date: "2016-05-04",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
        {
          date: "2016-05-01",
          name: "Tom",
          address: "No. 189, Grove St, Los Angeles",
        },
      ],
    };
  },
  methods: {
    handleEdit() {},
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