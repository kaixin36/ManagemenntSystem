<template>
  <div style="" class="main_area">
    <div class="login_area">
      <div class="title">欢迎登录后台管理</div>
      <div class="login_info">
        <el-form ref="form" :model="form" :rules="rules">
          <el-form-item prop="username">
            <el-input v-model="form.username" prefix-icon="User"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input
              v-model="form.password"
              show-password
              prefix-icon="Lock"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="login" style="width: 100%"
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
import { reactive } from "vue";

const rules = reactive({
  username: [
    {
      required: true,
      message: "请输入用户名",
      trigger: "blur",
    },
  ],
  password: [
    {
      required: true,
      message: "请输入密码",
      trigger: "blur",
    },
  ],
});

export default {
  name: "Login",
  data() {
    return {
      form: {
        username: "",
        password: "",
      },
      rules: rules,
    };
  },
  created() {},
  methods: {
    login() {
       //this.$router.push("/");

  //  if (this.$refs.form.validate((x) => x)) {
  //       request.post("/user/login", this.form).then((res) => {
  //         this.$router.push("/");
  //       });
  //     }
  
    request.post("/user/login", this.form).then((res) => {
          this.$router.push("/");
        });
    },
  },
};
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