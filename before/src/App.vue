<template>
  <div>
    <router-view/>
  </div>
</template>

<script>

import Login from "@/views/Login.vue";
import Layout from "@/layout/Layout.vue";

export default {
  name: "Layout",
  components: {
    Login,
    Layout
  },
};
</script>

<style scoped>
.body {
  display: flex;
}
</style>