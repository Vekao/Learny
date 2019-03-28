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
            axios.get("/types")
            .then(res => {
                console.log("response from server =>", res.data)
                ctx.commit("setTypes", res.data)
            })
            .catch(err => {
                alert(error);
            })
        },
        create(ctx, type) {
            axios.post("/types", type)
            .then(res => {
                console.log("response from server =>", res.data)
                ctx.commit("setTypes", res.data)
            })
            .catch(err => {
                alert(error);
            })  
        },
        delete(ctx, type) {
            axios.delete("/types", type)
            .then(res => {
                console.log("response from server =>", res.data)
                ctx.commit("setTypes", res.data)
            })
            .catch(err => {
                alert(error);
            })  
        },
    }
}