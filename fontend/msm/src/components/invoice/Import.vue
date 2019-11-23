<template>
  <div>
    <button @click="getSuppliers">get supplier</button>
  </div>
</template>

<script>
import Axios from "../../http-commom.js";
export default {
  data() {
    return {
      suppliers: null
    };
  },
  methods: {
    getSuppliers() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("suppliers", myConfig)
        .then(resp => {
          this.suppliers = resp.data.myData;
        })
        .catch(err => {
          alert("getSupplier error: " + err);
        });
    }
  },
  beforeMount(){
      this.getSuppliers()
  }
};
</script>