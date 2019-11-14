import Vue from 'vue'
import App from './App.vue'
import Vuex from 'vuex'
import router from './router.js'
import {store} from './store/store.js'

Vue.config.productionTip = false
Vue.use(Vuex)

new Vue({
  router,
  store, 
  render: h => h(App),
}).$mount('#app')
