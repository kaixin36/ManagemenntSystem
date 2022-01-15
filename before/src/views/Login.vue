<template>
  <div style="" class="main_area">
    <div class="login_area">
      <div class="title">欢迎登录</div>
      <div class="login_info">
        <el-form ref="form" :model="form" >
          <el-form-item>
            <el-input v-model="form.username" prefix-icon="User"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="form.password" show-password prefix-icon="Lock"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary"  @click="onSubmit" style="width: 100%"
              >登录</el-button
            >
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request.js";


export default {
  name: "Login",
  data() {
    return {
      form: {
        name: 2,
      },
    };
  },
  created() {},
  methods: {},
};
import { ref } from 'vue'
import { Calendar, Search } from '@element-plus/icons-vue'
const input1 = ref('')
const input2 = ref('')
const input3 = ref('')
const input4 = ref('')
</script>

<style scoped>
.main_area {
  width: 100%;
  height: 100vh;
  background-color: darkslateblue;
  overflow: hidden;
  /* display: flex;justify-content: center;align-items: center */
}
.login_area {
  width: 400px;
  margin: 150px auto;
}
.title {
  color: #cccccc;
  font-size: 30px;
  text-align: center;
}

.login_info {
  margin-top: 30px;
}
</style>