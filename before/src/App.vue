<template>
  <div>
    <router-view/>
  </div>
</template>

<script>

import Login from "@/views/Login.vue";
import Layout from "@/layout/Layout.vue";
import {activeRouter} from "@/utils/permission.js";

export default {
  name: "Layout",
  created:function() {
    activeRouter()
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