import axios from "axios";

export default {
    namespaced: true,
    state: {
        currentCourse: null,
        courses: []
    },
    getters: {
        all(state) {
            return state.courses;
        },
        byId(state, id) {
           axios.get("/courses/" + id)
           .then(res => {
               console.log("response from server =>", res.data)
               ctx.commit("setCourse", res.data)
           })
           .catch(err => {
               alert(error);
           })
            // return function wrapper(id) {
            //     return state.courses.filter(el => {
            //         return el.id === id
            //     })[0];
            // }
        },
        current(state) {
            return state.currentCourse;
        }
    },
    mutations: {
        setCourse(state, el) {
            state.course = el;
        },
        addCourses(state, el) {
            var courses = state.courses;
            courses.push(el);
            state.courses = courses;
        },
        deleteCourses(state, id) {
            state.courses = state.courses.filter(
                course => course.id != id
            );
        },
        updateCourse(state, el) {
            console.log("todo update el", state, el);
              // state
              // state.courses = els;
        },
        setCurrentCourse(state, el) {
            state.currentCourse = el;
        }
    },
    actions: {
         getAll(ctx) {
           axios.get("/courses")
           .then(res => {
               console.log("response from server =>", res.data)
               ctx.commit("setCourses", res.data)
           })
           .catch(err => {
               alert(error);
           })
        },
        
        create(ctx, course) {
           axios.post("/courses", course)
           .then(res => {
               console.log("response from server =>", res.data)
               ctx.commit("addCourses", res.data)
           })
           .catch(err => {
               alert(error);
           })  
        },
        delete(ctx, id) {
           axios.delete("/courses/" +  id)
           .then(res => {
               console.log("response from server =>", res.id)
               ctx.commit("deleteCourses", id)
           })
           .catch(err => {
               alert(error);
           })  
        },
        update(ctx, course) {
            axios
                .put("/courses/", course)
                .then(res => {
                  console.log("success editing course", res);
                  ctx.commit("updateCourse", course);
                })
                .catch(err => {
                  console.error("error when getting all courses", err);
                });
        },
        
        }
}