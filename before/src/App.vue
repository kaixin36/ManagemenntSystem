<template>
  <div>
    <!-- 头部 -->
    <Header />
    <!-- 主体 -->
    <div class="body">
      <!-- 侧边栏 -->
      <SelfAside class="" style="width:230px"/>
      <!-- 内容区域 -->
      <router-view />
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import SelfAside from "@/components/SelfAside.vue";

export default {
  name: "Layout",
  components: {
    Header,
    SelfAside,
  },
};
</script>

<style scoped>
.body {
  display: flex;
}
</style>