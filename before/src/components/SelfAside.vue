<template>
  <el-menu
    default-active="2"
    class="el-menu-vertical-demo"
    style="width: 200px;height: calc(100vh - 50px);"
  >
    <el-sub-menu index="1">
      <template #title>
        <el-icon><location /></el-icon>
        <span>系统设置</span>
      </template>
      <el-menu-item-group title="">
        <el-menu-item index="1-1">用户管理</el-menu-item>
        <el-menu-item index="1-2">用户角色</el-menu-item>
      </el-menu-item-group>
    </el-sub-menu>
    <el-menu-item index="2">
      <el-icon><icon-menu /></el-icon>
      <span>菜单选项</span>
    </el-menu-item>
  </el-menu>
</template>

<script  >
import {
  Location,
  Document,
  Menu as IconMenu,
  Setting,
} from "@element-plus/icons-vue";




export default {
  name: "SelfAside",
  components: {
    Location,
    Document,
    IconMenu,
    Setting,
  },
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
/* .tac_aside {
  width: 400px;
  height: 100vh-50px;
} */
</style>
