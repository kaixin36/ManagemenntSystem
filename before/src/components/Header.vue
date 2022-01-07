<template>
  <div class="header">
    <div class="header_left">后台管理</div>
    <div class="header_middle"></div>
    <div class="header_right">
      <el-dropdown>
        <span class="el-dropdown-link">
          刘凡
          <el-icon class="el-icon--right">
            <arrow-down />
          </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>退出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  props: {
    msg: String,
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.header {
  height: 50px;
  line-height: 50px;
  border-bottom: 1px solid #ccc;
  display: flex;
}
.header_left {
  width: auto;
  padding-left: 30px;
  font-weight: bold;
  color: dodgerblue;
}
.header_middle {
  flex: 1;
}
.header_right {
  width: auto;
}
</style>
