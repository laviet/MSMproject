<template>
  <div>
    <el-header>
      <el-button class="home" type="text" @click="homeMethod">
        <i class="el-icon-s-home"></i>
        Trang chủ
      </el-button>
      <el-input
        class="search"
        placeholder="Search"
        clearable
        v-model="search"
        prefix-icon="el-icon-search"
      >
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>

      <span v-if="currentUser">
        <el-button class="button" type="text" @click="logoutMethod">Đăng xuất</el-button>
        <span class="button">{{currentUser}}</span>
        <el-dropdown class="dropdown" @command="InformationHand">
          <el-button type="text" class="dropdown">
            Thông tin
            <i class="el-icon-caret-bottom el-icon--right"></i>
          </el-button>
          <el-dropdown-menu>
            <el-dropdown-item command="profile">Xem thông tin cá nhân</el-dropdown-item>
            <el-dropdown-item command="update">Cập nhật thông tin</el-dropdown-item>
            <el-dropdown-item command="showInfor">Theo dõi đơn hàng</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <el-dropdown class="dropdown" @command="functionHand">
          <el-button type="text" class="dropdown">
            Chức năng
            <i class="el-icon-caret-bottom el-icon--right"></i>
          </el-button>
          <el-dropdown-menu>
            <span v-for="index in roles" :key="index.id">
              <span v-if="index.name=='ROLE_USER'">
                <el-dropdown-item command="comment">Nhận xét</el-dropdown-item>
              </span>
              <span v-if="index.name=='ROLE_EMPLOYEE'">
                <el-dropdown-item command="createImportInvoice">Tạo hóa đơn nhập</el-dropdown-item>
                <el-dropdown-item command="createExportInvoice">Tạo hóa đơn bán hàng</el-dropdown-item>
              </span>
              <span v-if="index.name=='ROLE_ADMIN'">
                <el-dropdown-item command="showStatistic">Xem thống kê</el-dropdown-item>
              </span>
            </span>
          </el-dropdown-menu>
        </el-dropdown>
      </span>
      <span v-else>
        <el-button class="button" type="text" @click="registerShow=true">đăng ký</el-button>
        <el-button class="button" type="text" @click.stop="loginShow=true">đăng nhập</el-button>
      </span>
    </el-header>

    <Login :visibleLogin="loginShow" @login-close="loginShow=false" />

    <Register :visibleRegister="registerShow" @register-close="registerShow=false" />
  </div>
</template>

<script>
import Login from "./Login.vue";
import Register from "./Register.vue";
import Vuex from "vuex";
export default {
  components: {
    Login,
    Register
  },
  data() {
    return {
      search: "",
      loginShow: false,
      registerShow: false
    };
  },
  methods: {
    ...Vuex.mapActions(["fetchAccessToken", "removeAlert"]),
    homeMethod() {
      this.$router.push("/");
    },
    logoutMethod() {
      if (confirm("Bạn có muốn đăng xuất")) {
        localStorage.removeItem("userLogin");
        localStorage.removeItem("accessToken");
        localStorage.removeItem("message");
        this.fetchAccessToken();
        this.removeAlert();
        this.$router.push("/");
      }
    },
    InformationHand(command) {
      if (command == "profile") {
        let lengthRole = this.roles.length;
        for (let i = 0; i < lengthRole; i++) {
          if (
            "ROLE_ADMIN" == this.roles[i].name ||
            "ROLE_EMPLOYEE" == this.roles[i].name
          ) {
            this.$router.push("/employee");
            return true;
          }
        }
        for (let i = 0; i < lengthRole; i++) {
          if ("ROLE_USER" == this.roles[i].name) {
            this.$router.push("/customer");
            return true;
          }
        }
      } else if (command == "update") {
        let lengthRole = this.roles.length;
        for (let i = 0; i < lengthRole; i++) {
          if (
            "ROLE_ADMIN" == this.roles[i].name ||
            "ROLE_EMPLOYEE" == this.roles[i].name
          ) {
            this.$router.push("/employee/update");
            return true;
          }
        }
        for (let i = 0; i < lengthRole; i++) {
          if ("ROLE_USER" == this.roles[i].name) {
            this.$router.push("/customer/update");
            return true;
          }
        }
      } else {
        alert(command);
      }
    },
    functionHand(command) {
      if(command=='createImportInvoice'){
        this.$router.push('/invoice/import')
      }
      if(command=='createExportInvoice'){
         this.$router.push('/invoice/export')
      }
    }
  },
  computed: {
    ...Vuex.mapState([
      "loggingIn",
      "loginError",
      "accessToken",
      "currentUser",
      "roles",
      "message"
    ])
  }
};
</script>

<style lang="scss" scoped>
.el-header {
  background-color: steelblue;
  line-height: 60px;
}
.home {
  line-height: 25px;
  padding-bottom: 20px;
  text-transform: uppercase;
  color: white;
  font-size: 25px;
  font-family: "Times New Roman", Times, serif;
  font-weight: bold;
}
.search {
  width: 400px;
  margin-left: 100px;
}
.button {
  text-transform: uppercase;
  float: right;
  color: white;
  margin-right: 15px;
  height: 60px;
  font-size: 17px;
  font-family: "Times New Roman", Times, serif;
  font-weight: bold;
}
.dropdown {
  text-transform: uppercase;
  float: right;
  color: white;
  margin-right: 10px;
  height: 60px;
  font-size: 17px;
  font-family: "Times New Roman", Times, serif;
  font-weight: bold;
}
</style>