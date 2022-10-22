<template>
  <div>
    <router-view/>
  </div>
</template>

<script>

import Login from "@/views/Login.vue";
import Layout from "@/layout/Layout.vue";
import permission from "@/utils/permission.js";
import router from "@/router";

export default {
  name: "Layout",
  created:function() {
    permission()
  },
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