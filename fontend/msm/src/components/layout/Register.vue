<template>
  <div>
    <el-dialog
      title="Nhập thông tin"
      :visible.sync="visibleRegister"
      :before-close="registerClose"
      center
      width="45%"
      :close-on-click-modal="false"
    >
      <el-form
        label-width="130px"
        :label-position="labelPosition"
        :model="registerInfo"
        :rules="rules"
        status-icon
        ref="registerInfo"
      >
        <el-form-item label="Họ tên" prop="name">
          <el-input v-model="registerInfo.name"></el-input>
        </el-form-item>
        <el-form-item label="Email" prop="email">
          <el-input v-model="registerInfo.email"></el-input>
        </el-form-item>
        <el-form-item label="Vai trò" prop="role">
          <el-select v-model="registerInfo.role" placeholder="Vui lòng chọn" multiple>
            <el-option
              v-for="option in options"
              :key="option.value"
              :value="option.value"
              :label="option.label"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Tên đăng nhập" prop="username">
          <el-input v-model="registerInfo.username"></el-input>
        </el-form-item>
        <el-form-item label="Mật khẩu" prop="password">
          <el-input v-model="registerInfo.password" show-password></el-input>
        </el-form-item>
        <el-form-item label="Nhập lại mật khẩu" prop="repassword">
          <el-input v-model="registerInfo.repassword" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="registerForm('registerInfo')">ĐĂNG KÝ</el-button>
          <el-button
            type="primary"
            @click="resetFrom('registerInfo')"
            style="margin-left: 50px"
          >LÀM MỚI</el-button>
          <el-button type="primary" @click="cancelForm" style="margin-left: 50px">HỦY</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import Axios from "../../http-commom.js";
export default {
  props: {
    visibleRegister: null
  },
  data() {
    var checkPass = (rule, value, callback) => {
      if (value !== this.registerInfo.password) {
        callback(new Error("Mật khẩu không khớp"));
      } else {
        callback();
      }
    };
    return {
      registerInfo: {
        name: "",
        email: "",
        username: "",
        password: "",
        repassword: "",
        role: []
      },
      options: [
        { value: "user", label: "Khách hàng" },
        { value: "employee", label: "Nhân viên" },
        { value: "admin", label: "Quản trị viên" }
      ],
      labelPosition: "left",
      rules: {
        name: [{ required: true, message: "Nhập họ tên", trigger: "blur" }],
        email: [
          { required: true, message: "Nhập email", trigger: "blur" },
          {
            type: "email",
            message: "Email không hợp lệ",
            trigger: ["blur", "change"]
          }
        ],
        role: [{ required: true, message: "Chọn vai trò", trigger: "change" }],
        username: [
          { required: true, message: "Nhập tên đăng nhập", trigger: "blur" }
        ],
        password: [
          { required: true, message: "Nhập mật khẩu", trigger: "blur" },
          { min: 8, message: "Nhập mật khẩu ít nhất 8 ký tự", trigger: "blur" }
        ],
        repassword: [
          { required: true, message: "Nhập lại mật khẩu", trigger: "blur" },
          { validator: checkPass, trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    registerClose() {
      this.visibleRegister = false;
      this.$emit("register-close");
    },
    registerForm(data) {
      this.$refs[data].validate(valid => {
        if (valid) {
          Axios.post('auth/signup', this.registerInfo)
          .then(response=>{
            this.dataSignup=response.data
            alert(response.data)
            this.$refs[data].resetFields();
            this.registerClose()
          })
          .catch(err=>{
            alert("Lỗi đăng ký: "+err)
          })
        }
      });
    },
    resetFrom(data) {
      this.$refs[data].resetFields();
    },
    cancelForm() {
      this.visibleRegister = false;
      this.$emit("register-close");
    }
  }
};
</script>