import axios from "axios";

export default {
    namespaced: true,
    state: {
        categories: []
    },
    getters: {
        all(state) {
            return state.categories;
        },
        byId(state) {
            return function wrapper(id) {
                return state.categories.filter(cat => {
                    return cat.id === id
                })[0];
            }
        }
    },
    mutations: {
        setCategories(state, cats) {
            state.categories = cats;
        }
    },
    actions: {
          getAll(ctx) {
           axios.get("/categories")
           .then(res => {
               console.log("response from server =>", res.data)
               ctx.commit("setCategories", res.data)
           })
           .catch(err => {
               alert(error);
           })
        }
    }
}