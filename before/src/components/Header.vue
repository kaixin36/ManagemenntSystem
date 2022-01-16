<template>
  <div class="header">
    <div class="header_left">后台管理系统</div>
    <div class="header_middle"></div>
    <div class="header_user_head_image">
      <el-avatar
        :size="40"
        src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
      >
      </el-avatar>
    </div>
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
import { ArrowDown } from "@element-plus/icons-vue";
export default {
  name: "Header",
  components: {
    ArrowDown,
  },
};
</script>
<script lang="ts" setup>
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
  margin-right: 50px;
}

.header_user_head_image {
  display: flex;
  justify-content: center;
  justify-items: center;
}
</style>
