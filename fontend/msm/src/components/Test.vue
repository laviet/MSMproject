<template>
    <div>this is test {{datatest}}</div>
</template>

<script>
import http from '../http-commom.js'
export default {
    data(){
        return {
            datatest: ''
        }
    },
    methods:{
        getDate(){
            http.post("/login").then(response=>{
                this.datatest=response.data
            })
        }
    },
    mounted(){
        this.getDate()
    }
}
</script>