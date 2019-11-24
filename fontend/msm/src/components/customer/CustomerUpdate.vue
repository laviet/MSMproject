<template>
  <div>
    <el-card>
      <div slot="header" class="header">
        <span>cập nhật thông tin khách hàng</span>
      </div>
      <el-form
        :model="customer"
        :rules="rules"
        label-width="120px"
        :label-position="lablePosition"
        ref="customer"
      >
        <el-form-item label="Tên khách hàng" prop="tenkhachhang">
          <el-input v-model="customer.tenkhachhang"></el-input>
        </el-form-item>
        <el-form-item label="Email" prop="email">
          <el-input v-model="customer.email"></el-input>
        </el-form-item>
        <el-form-item label="Giới tính" prop="gioitinh">
          <el-radio-group v-model="employee.gioitinh">
            <el-radio  label="Nam"></el-radio>
            <el-radio  label="Nữ"></el-radio>
            <el-radio  label="Khác"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="Địa chỉ" prop="diachi">
          <el-input v-model="customer.diachi"></el-input>
        </el-form-item>
        <el-form-item label="Số điện thoại" prop="sdt">
          <el-input v-model="customer.sdt"></el-input>
          <el-input style="display: none;" v-model="customer.makhachhang"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updateCustomer('customer')">Cập nhật</el-button>
          <el-button type="primary" @click="resetForm('customer')">Làm mới</el-button>
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
      customer:null
      ,
      rules: {
        tenkhachhang: [
          { required: true, message: "Nhập tên khách hàng", trigger: "blur" }
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
    updateCustomer(data) {
      var myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      this.$refs[data].validate(valid => {
        if (valid) {
          Axios.post("customer/updateCustomer", this.customer, myConfig).then(resp => {
            alert(resp.data)
          });
          
        }
      });
    },

    getcustomer() {
      var myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("customer", myConfig)
        .then(resp => {
          this.customer = resp.data.myData;
        })
        .catch(err => {
          window.console.error(err);
        });
    }
  },
  beforeMount() {
    this.getcustomer();
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
  margin-right: 30px;
}
</style>