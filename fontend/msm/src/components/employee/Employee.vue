<template>
  <div>
    <el-card>
      <div slot="header" class="header">
        <span>thông tin nhân viên</span>
        <el-button type="text" @click="updateEmployee">Sửa thông tin</el-button>
      </div>
      <div class="text-box">
        <div class="left">
          <img style="width: 150px; height: 150px" src="@/assets/user.png" />
          <h3 class="fullname">{{employee.tennhanvien}}</h3>
        </div>
        <div class="right">
          <div class="title">
            <div>Email</div>
            <br />
            <br />
            <div>Giới tính</div>
            <br />
            <br />
            <div>Ngày sinh</div>
            <br />
            <br />
            <div>Địa chỉ</div>
            <br />
            <br />
            <div>Số điện thoại</div>
            <br />
          </div>
          <div class="content">
            <div>{{employee.email}}</div>
            <br />
            <br />
            <div>{{employee.gioitinh}}</div>
            <br />
            <br />
            <div>
              <el-date-picker
                v-model="employee.ngaysinh"
                type="date"
                format="dd - MM - yyyy"
                readonly
              ></el-date-picker>
            </div>
            <br />
            <div>{{employee.diachi}}</div>
            <br />
            <br />
            <div>{{employee.sdt}}</div>
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
      employee: null
    };
  },
  methods: {
    updateEmployee() {
      this.$router.push("employee/update");
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