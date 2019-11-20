import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export const store = new Vuex.Store({

    state: {
        number: 0,
        value: 'la van viet',
        dataTest: {},

        accessToken: null,
        loggingIn: false,
        loginError: null,
        currentUser: null,
        message: null,
        roles:[]
    },
    mutations: {
        increament(state, n) {
            // state.number+=n.amount
            state.dataTest = n
        },
        currentUserSave: (state, user)=>{
          state.currentUser=user
        },
        rolesSave: (state, roles)=>{
          state.roles=roles
        },
        loginStart: (state, message) => {
          state.loggingIn = true
          state.loginError=message;
          state.message='Đăng nhập thành công'
        },
        loginStop: (state, errorMessage) => {
          state.loggingIn = false;
          state.loginError = errorMessage;
          state.message='Sai thông tin đăng nhập'
        },
        updateAccessToken: (state, accessToken) => {
          state.accessToken = accessToken;
        }
    },

    actions: {
        increamentAction: ({ commit }, delay) => {
            setTimeout(() => {
                commit('increament', 5)
            }, delay)
        },

        doLogin({ commit }, loginData) {
            
      
            axios.post('http://localhost:9090/api/auth/signin', {
              ...loginData
            })
            .then(response => {
              localStorage.setItem('accessToken', response.data.token);
              localStorage.setItem('userLogin', response.data.currentUser);
              localStorage.setItem('rolesUser',JSON.stringify(response.data.role) );
              commit('updateAccessToken', response.data.token);
              commit('loginStart',null);
              commit('currentUserSave', response.data.currentUser)
              commit('rolesSave', response.data.role)
            })
            .catch(error => {
              commit('loginStop', error.response.data.error);
              commit('updateAccessToken', null);
              commit('currentUserSave', null)
            })
          },
          fetchAccessToken({ commit }) {
            commit('updateAccessToken', localStorage.getItem('accessToken'));
            commit('currentUserSave', localStorage.getItem('userLogin'));
            commit('rolesSave', JSON.parse(localStorage.getItem('rolesUser')));
          }
    },
    getters: {
        calNumber: state => {
            return state.number++
        }
    },
})