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
        },
        addCategories(state, cat) {
            var categories = state.categories;
            categories.push(cat);
            state.categories = categories;
        },
        deleteCategories(state, id) {
            state.categories = state.categories.filter(
                category => category.id != id
            );
        },
        
       
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
               ctx.commit("addCategories", res.data)
           })
           .catch(err => {
               alert(error);
           })  
        },
        delete(ctx, id) {
           axios.delete("/categories/" +  id)
           .then(res => {
               console.log("response from server =>", res.id)
               ctx.commit("deleteCategories", id)
           })
           .catch(err => {
               alert(error);
           })  
        },
        
    }
}