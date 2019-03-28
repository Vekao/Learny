import Vue from 'vue'
import Vuex from 'vuex'
import category from "./category"
import course from "./course"
import type from "./type"

Vue.use(Vuex)
  
export default new Vuex.Store({
  modules: {
    category,
    course,
    type
  }
})
