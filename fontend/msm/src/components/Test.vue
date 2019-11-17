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

export default {
  data() {
    return {
      datatest: "",
      token: ""
    };
  },
  methods: {
    getData() {
      const myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      this.token = localStorage.getItem("accessToken");
      Axios.get("api/test/admin", myConfig).then(response => {
          alert('hoe')
        this.datatest = response;
      }).catch(err=>{
          alert("heelo"+err)
      })
    },
    removeToken(){
        Axios.get("norole").then(response => {
        this.datatest = response.data;
      });
    }
  }
};
</script>