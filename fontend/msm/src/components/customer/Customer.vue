<template>
  <div>
    <el-card>
      <div slot="header" class="header">
        <span>thông tin khách hàng</span>
        <el-button type="text" @click="updateCustomer">Sửa thông tin</el-button>
      </div>
      <div class="text-box">
        <div class="left">
          <img style="width: 150px; height: 150px" src="@/assets/user.png" />
          <h3 class="fullname">{{customer.tenkhachhang}}</h3>
        </div>
        <div class="right">
          <div class="title">
            <div>Email</div>
            <br />
            <br />
            <div>Giới tính</div>
            <br />
            <br />
            <div>Địa chỉ</div>
            <br />
            <br />
            <div>Số điện thoại</div>
            <br />
          </div>
          <div class="content">
            <div>{{customer.email}}</div>
            <br />
            <br />
            <div>{{customer.gioitinh}}</div>
            <br />
            <br />
            <div>{{customer.diachi}}</div>
            <br />
            <br />
            <div>{{customer.sdt}}</div>
          </div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import Axios from "../../http-commom.js";

export default {
  data() {
    return {
      customer: null
    };
  },
  methods: {
    updateCustomer() {
      this.$router.push("customer/update");
    },
    getCustomer() {
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
    this.getCustomer();
  }
};
</script>

<style lang="scss" scoped>
.el-card {
  width: 70%;
  margin: 30px auto;
  background: lightgreen;
  .header {
    text-align: center;
    color: blue;
    font-size: 25px;
    font-weight: bold;
    text-transform: uppercase;
    .el-button {
      float: right;
      color: blue;
      text-decoration: underline;
    }
  }
}
.text-box {
  display: flex;
}
.left {
  border-right: solid lavender 1px;
  flex-grow: 1;
  min-width: 30%;
  text-align: center;
  .fullname {
    text-transform: uppercase;
    font-weight: bold;
  }
}
.right {
  margin-left: 40px;
  flex-grow: 3;
  display: flex;
  .title {
    flex-basis: 25%;
  }
}
</style>