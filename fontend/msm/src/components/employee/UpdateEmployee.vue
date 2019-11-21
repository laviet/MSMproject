<template>
  <div>
    <el-card>
      <div slot="header" class="header">
        <span>cập nhật thông tin cá nhân</span>
      </div>
      <el-form
        :model="employee"
        :rules="rules"
        label-width="120px"
        :label-position="lablePosition"
        ref="employee"
      >
        <el-form-item label="Tên nhân viên" prop="tennhanvien">
          <el-input v-model="employee.tennhanvien"></el-input>
        </el-form-item>
        <el-form-item label="Email" prop="email">
          <el-input v-model="employee.email"></el-input>
        </el-form-item>
        <el-form-item label="Giới tính" prop="gioitinh">
          <el-select v-model="employee.gioitinh">
            <el-option value="Nam" label="Nam"></el-option>
            <el-option value="Nữ" label="Nữ"></el-option>
            <el-option value="Khác" label="Khác"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Địa chỉ" prop="diachi">
          <el-input v-model="employee.diachi"></el-input>
        </el-form-item>
        <el-form-item label="Số điện thoại" prop="sdt">
          <el-input v-model="employee.sdt"></el-input>
          <el-input style="display: none;" v-model="employee.manhanvien"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updateEmployee('employee')">Cập nhật</el-button>
          <el-button type="primary" @click="resetForm('employee')">Làm mới</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  
  </div>
</template>

<script>
import Axios from "../../http-commom.js";
export default {
  data() {
    return {
      updateMessage: "",
      lablePosition: "left",
      employee: {
        manhanvien: "",
        tennhanvien: "",
        email: "",
        gioitinh: "",
        diachi: "",
        sdt: ""
      },
      rules: {
        tennhanvien: [
          { required: true, message: "Nhập tên nhân viên", trigger: "blur" }
        ],
        email: [
          { required: true, message: "Nhập email", trigger: "blur" },
          {
            type: "email",
            message: "Email không hợp lệ",
            trigger: ["blur", "change"]
          }
        ]
      }
    };
  },
  methods: {
    resetForm(data) {
      this.$refs[data].resetFields();
    },
    updateEmployee(data) {
      var myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      this.$refs[data].validate(valid => {
        if (valid) {
          Axios.post("employee/updateEmployee", this.employee, myConfig).then(resp => {
            alert(resp.data)
          });
          
        }
      });
    },

    getEmployee() {
      var myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("employee", myConfig)
        .then(resp => {
          this.employee = resp.data.myData;
        })
        .catch(err => {
          window.console.error(err);
        });
    }
  },
  beforeMount() {
    this.getEmployee();
  }
};
</script>

<style lang="scss" scoped>
.el-card {
  width: 700px;
  margin: 30px auto;
  background: lightgreen;
  .header {
    text-align: center;
    color: blue;
    font-size: 25px;
    font-weight: bold;
    text-transform: uppercase;
  }
}
.el-form {
  width: 500px;
  margin: 0 auto;
}
.el-button {
  text-transform: uppercase;
}
</style>