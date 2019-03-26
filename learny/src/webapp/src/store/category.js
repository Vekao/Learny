import axios from "axios";

export default {
    namespaced: true,
    state: {
        currentCategory: null,
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
        },
        current(state) {
            return state.currentCategory;
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
        updateCategory(state, cat) {
            console.log("todo update cat", state, cat);
              // state
              // state.categories = cats;
        },
        setCurrentCategory(state, cat) {
            state.currentCategory = cat;
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
        update(ctx, category) {
            axios
                .put("/categories/", category)
                .then(res => {
                  console.log("success editing category", res);
                  ctx.commit("updateCategory", category);
                })
                .catch(err => {
                  console.error("error when getting all categories", err);
                });
        },
        
        }
}