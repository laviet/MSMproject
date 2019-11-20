<template>
  <div>
    <h1>Login form</h1>
    <p v-if="loginError">{{ loginError }}</p>
    <p v-if="accessToken">Login Successful {{accessToken}}</p>
    <p></p>
    <div>
      <input type="text" required v-model="username" placeholder="Username" />
      <br />
      <br />
      <input type="text" v-model="password" placeholder="Password" />
      <br />
      <br />
      status: {{status}}
      <button @click="loginSubmit">Login</button>
      token: {{dataresponse}}
    </div>
  </div>
</template>

<script>
import Vuex from "vuex";
export default {
  data() {
    return {
      username: "",
      password: "",
      message: "",
      status: "",
      dataresponse: "",
      token: ""
    };
  },
  computed: {
    ...Vuex.mapState(["loggingIn", "loginError", "accessToken"])
  },
  methods: {
    ...Vuex.mapActions(["fetchAccessToken"]),
    ...Vuex.mapActions(["doLogin"]),
    loginSubmit() {
      this.doLogin({
        username: this.username,
        password: this.password
      });
    }
  },
  created() {
    this.fetchAccessToken();
  }
};
</script>