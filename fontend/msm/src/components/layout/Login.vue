<template>
  <div>
    <el-dialog
      class="dialog"
      title="Vui lòng nhập thông tin"
      :visible.sync="visibleLogin"
      center
      :before-close="closeDialog"
      width="35%"
      :close-on-click-modal="false"
    >
      <el-form
        :model="credential"
        status-icon
        :rules="rules"
        ref="credential"
        label-width="120px"
        class="demo-ruleForm"
        :label-position="labelPosition"
      >
        <el-form-item label="Tên đăng nhập" prop="username">
          <el-input type="text" v-model="credential.username" v-on:keyup.enter="submitForm('credential')"></el-input>
        </el-form-item>
        <el-form-item label="Mật khẩu" prop="password">
          <el-input type="password" show-password v-model="credential.password" v-on:keyup.enter="submitForm('credential')" ></el-input>
        </el-form-item>
        <el-form-item>
          <span v-if="loggingIn" style="color: blue">{{message}}</span>
          <span v-else style="color: red">{{message}}</span>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('credential')">ĐĂNG NHẬP</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import Vuex from "vuex";
export default {
  props: {
    visibleLogin: null
  },
  data() {
    var checkUsername = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("Vui lòng nhập tên đăng nhập"));
      } else {
        setTimeout(() => {
          if (this.credential.username !== "") {
            this.$refs.credential.validateField("username");
          }
          callback();
        }, 500);
      }
    };
    var checkPassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("Vui lòng nhập mật khẩu"));
      } else {
        setTimeout(() => {
          if (this.credential.password !== "") {
            this.$refs.credential.validateField("password");
          }
          callback();
        }, 500);
      }
    };
    return {
      labelPosition: "left",
      credential: {
        username: "",
        password: ""
      },
      rules: {
        username: [{ validator: checkUsername, trigger: "blur" }],
        password: [
          { validator: checkPassword, trigger: "blur" },
          { min: 8, message: "Mật khẩu ít nhất 8 ký tự", trigger: "blur" }
        ]
      }
    };
  },
  computed: {
    ...Vuex.mapState(["loggingIn", "loginError", "message"])
  },
  methods: {
    ...Vuex.mapActions(["fetchAccessToken"]),
    ...Vuex.mapActions(["doLogin"]),

    closeDialog() {
      this.visibleLogin = false;
      this.credential.username = "";
      this.credential.password = "";
      this.$emit("login-close");
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.doLogin({
            username: this.credential.username,
            password: this.credential.password
          });
        } else {
          return false;
        }
      });
    }
  },

  created() {
    this.fetchAccessToken();
  }
};
</script>
