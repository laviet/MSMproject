import Vue from 'vue'
import App from './App.vue'
import Vuex from 'vuex'
import router from './router.js'
import {store} from './store/store.js'
import ElementUI  from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false
Vue.use(Vuex)
Vue.use(ElementUI);

new Vue({
  router,
  store, 
  render: h => h(App),
}).$mount('#app')
