import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export const store=new Vuex.Store({

    state:{
        number: 0,
        value: 'la van viet',
        dataTest: {}
    },
    mutations:{
        increament(state, n){
            // state.number+=n.amount
            state.dataTest=n
        }
    },

    actions:{
        increamentAction:({commit}, delay)=>{
            setTimeout(()=>{
                commit('increament',5)
            },delay)
        }
    },
    getters:{
        calNumber: state=>{
            return state.number++
        }
    },
})