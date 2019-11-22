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
        <el-dropdown class="dropdown" @command="handCommand">
          <el-button type="text" class="dropdown">
            Thông tin
            <i class="el-icon-caret-bottom el-icon--right"></i>
          </el-button>
          <el-dropdown-menu>
            <el-dropdown-item command="1">Xem thông tin cá nhân</el-dropdown-item>
            <el-dropdown-item command="2">Cập nhật thông tin</el-dropdown-item>
            <el-dropdown-item command="3">Theo dõi đơn hàng</el-dropdown-item>
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
      if(confirm("Bạn có muốn đăng xuất")){
      localStorage.removeItem("userLogin");
      localStorage.removeItem("accessToken");
      localStorage.removeItem("message");
      this.fetchAccessToken();
      this.removeAlert();
      this.$router.push("/");
      }
    },
    handCommand(command) {
      if (command == 1) {
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
      } else if (command == 2) {
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
  margin-left: 250px;
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