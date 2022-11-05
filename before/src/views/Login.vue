<template>
  <div style="  position:absolute;
    left:100px;
    top:100px;
    height:700px;
    width:600px">
    <ChartLine ref="chart_line_one" />
  </div>
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

import ChartLine from "@/components/ChartLint.vue";
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

      name: "张雪",
      xData: ["2020-02", "2020-03", "2020-04", "2020-05"],
      yData: [30, 132, 80, 134],
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
  components: {
    ChartLine,
  },
  mounted() {
    const { name, xData, yData } = this;
    console.log(this.$refs);
    this.$refs.chart_line_one.initChart();
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