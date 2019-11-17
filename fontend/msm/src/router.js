import Vue from "vue";
import Router from "vue-router";
import Home from './components/Home.vue'
import Test from './components/Test.vue'
import Login from './components/security/Login.vue'

Vue.use(Router);

export default new Router({
    
    routes:[
        {path: '', component:  Home,
        children:[
            {path: '/test', component: Test },
            {path: '/login', component: Login },
        ]
    },
        
    ]
})