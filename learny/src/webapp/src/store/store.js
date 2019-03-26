import Vue from 'vue'
import Vuex from 'vuex'
import category from "./category"
// import type from "./type"

Vue.use(Vuex)

  // state: {

  // },
  // mutations: {

  // },
  // actions: {

  // }
  
export default new Vuex.Store({
  modules: {
    category
    // type
  }
})
