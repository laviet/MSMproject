<template>
  <div>
    <button @click="getData">OK</button>
    <button @click="removeToken">remove</button>
    <p>this is data: {{datatest}}</p>
    <p>this is token: {{token}}</p>
  </div>
</template>

<script>
import Axios from "../http-commom.js";

var myConfig = {
  headers: {
    Authorization: "Bearer " + localStorage.getItem("accessToken")
  }
};
export default {
  data() {
    return {
      datatest: "",
      token: ""
    };
  },
  methods: {
    getData() {
      this.token = localStorage.getItem("accessToken");
      Axios.get("api/test/customer", myConfig)
        .then(response => {

          this.datatest = response;
        })
        .catch(err => {
          alert("loi roi" + err);
        });
    },
    removeToken() {
      Axios.get("norole").then(response => {
        this.datatest = response.data;
      });
    }
  }
};
</script>