<template>
  <div>
    <p>this is demo</p>
    <button @click="local"> save</button>
    <p>data: {{dataLocal}}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      search: "",
      dataLocal: localStorage.getItem('local')
    };
  },
  methods:{
    local(){
      this.dataLocal=localStorage.setItem("local","this is local")
    }
  }
};
</script>
