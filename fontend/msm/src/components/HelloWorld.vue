<template>
  <div class="hello">
    <h1>this is main</h1>
    <p>this is {{value}}</p>
    <p>this is {{number}}</p>
    <p>this usernmae {{dataTest.username}}</p>
    <p>this address {{dataTest.address}}</p>
    <p>this data {{data.address}}</p>
    <button @click="changeByMutations(mydata)">mutation</button>
    <button @click="changeByAcions(1000)">action</button>
  </div>
</template>

<script>
import Vuex from "vuex";
import Data from '../data.json'
export default {
  data() {
    return {
      objectTest: { amount: 10, total: 50 },
      mydata: { username: 'La Văn Việt', address: 'Hà Nội', score: 6 },
      data: Data
    };
  },

  computed: {
    ...Vuex.mapState(["number", "value"]),
    ...Vuex.mapState(['dataTest'])
  },
  methods: {
    ...Vuex.mapMutations({ changeByMutations: "increament" }),
    ...Vuex.mapActions({ changeByAcions: "increamentAction" })
  }
};
</script>


