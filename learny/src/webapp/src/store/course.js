import axios from "axios";

export default {
    namespaced: true,
    state: {
        currentCourse: null
    },
    getters: {
        byId(state) {
            return state.currentCourse;
        }
    },
    mutations: {
        setCurrentCourse(state, course) {
            state.currentCourse = course;
        }
    },
    actions: {
         getById(ctx, id) {
           axios.get("/courses/" + id)
           .then(res => {
               console.log("response from server =>", res.data)
               ctx.commit("setCurrentCourse", res.data)
           })
           .catch(err => {
               alert(error);
           })
        }
    }
}