<template>
  <div>
      this is main
  </div>
</template>

<script>
import Vuex from "vuex";
export default {
  methods: {
          ...Vuex.mapActions(["fetchAccessToken"]),
    logout() {
      alert("dang xua");
      localStorage.removeItem("currentUser");
      this.$router.push("/");
    }
  },
  computed:{
       ...Vuex.mapState(["roles"])
  },
    created() {
    this.fetchAccessToken();
  }
};
</script>