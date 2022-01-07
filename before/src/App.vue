<template>
  <div>
    <!-- 头部 -->
    <Header />
    <!-- 主体 -->
    <div class="body">
      <!-- 侧边栏 -->
      <Aside class="body_aside" />
      <!-- 内容区域 -->
      <router-view />
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import Aside from "@/components/Aside.vue";

export default {
  name: "Layout",
  components: {
    Header,
    Aside,
  },
};
</script>

<style scoped>
.body {
  display: flex;
}
.body_aside {
  width: auto;
}
</style>