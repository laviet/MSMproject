import Vue from "vue";
import Router from "vue-router";
import Home from './components/Home.vue'
import Test from './components/Test.vue'
import Login from './components/security/Login.vue'
import Demo from './components/Demo.vue'
import Main from './components/layout/Main.vue'
import UserRouter from './components/user/router.js'
import CustomerRouter from './components/customer/router.js'
import HelloWorld from './components/HelloWorld.vue'


Vue.use(Router);

export default new Router({

    routes: [
        {
            path: '/', component: Home,
            children: [
                { path: '', component: Main },
                { path: 'test', component: Test },
                { path: 'login', component: Login },
                { path: 'demo', component: Demo },
                { path: 'hello', component: HelloWorld },
            ]
            .concat(UserRouter)
            .concat(CustomerRouter)
        }
    ]

})

