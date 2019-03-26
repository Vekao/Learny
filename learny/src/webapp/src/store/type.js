import axios from "axios";

export default {
    namespaced: true,
    state: {
        types: []
    },
    getters: {
        all(state) {
            return state.types;
        },
        byId(state) {
            return function wrapper(id) {
                return state.types.filter(type => {
                    return type.id === id
                })[0];
            }
        }
    },
    mutations: {
        setTypes(state, types) {
            state.types = types;
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
        },
        create(ctx, category) {
           axios.post("/categories", category)
           .then(res => {
               console.log("response from server =>", res.data)
               ctx.commit("setCategories", res.data)
           })
           .catch(err => {
               alert(error);
           })  
        },
        delete(ctx, category) {
           axios.delete("/categories", category)
           .then(res => {
               console.log("response from server =>", res.data)
               ctx.commit("setCategories", res.data)
           })
           .catch(err => {
               alert(error);
           })  
        },
        
    }
}