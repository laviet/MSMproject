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
        loginError: null
    },
    mutations: {
        increament(state, n) {
            // state.number+=n.amount
            state.dataTest = n
        },
        loginStart: state => state.loggingIn = true,
        loginStop: (state, errorMessage) => {
          state.loggingIn = false;
          state.loginError = errorMessage;
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
            commit('loginStart');
      
            axios.post('http://localhost:9090/api/auth/signin', {
              ...loginData
            })
            .then(response => {
              localStorage.setItem('accessToken', response.data.token);
              commit('loginStop', null);
              commit('updateAccessToken', response.data.token);
            })
            .catch(error => {
              commit('loginStop', error.response.data.error);
              commit('updateAccessToken', null);
            })
          },
          fetchAccessToken({ commit }) {
            commit('updateAccessToken', localStorage.getItem('accessToken'));
          }
    },
    getters: {
        calNumber: state => {
            return state.number++
        }
    },
})