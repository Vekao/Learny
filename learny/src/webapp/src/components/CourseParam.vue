<template>
    <form id="form-course" @submit="$event.preventDefault();$store.dispatch('course/create', course);">
        <label for="">Titre du cours</label>
        <input type="text" v-model="course.title">
        
        <label for="">Catégorie du cours</label>
        <select name="select">
            <option v-for="category in categories" :key="category.id">{{ category.label }}</option>  
        </select>
        
        <label for="">Type de cours</label>
        <select name="select">
            <option v-for="type in types" :key="type.id">{{ type.label }}</option>  
        </select>
 
        <button>Créer</button>
    </form>
</template>

<script>
export default {
  created() {
        this.$store.dispatch("category/getAll");
        this.$store.dispatch("type/getAll");
    },
    data() {
        return {
            course: {
                title: null,
                category: null,
                type: null
            }
        }
    },
    computed: {
        categories() {
            return this.$store.getters["category/all"]
        },
        types() {
            return this.$store.getters["type/all"]
        }
    },
    methods: {
        postCourse() {
            console.log(this.course);
            console.log("cours à poster...")
        }
    }
}
</script>

<style lang="scss" scoped>
#form-course {
    display: flex;
    flex-direction: column;
    width: 50%;
    margin: 0 auto;
    margin-top: 50px;
    margin-bottom: 30px;
    label {
        align-self: start;
        margin-bottom: 5px;
        margin-top: 20px;
    }
    input {
        padding: 10px;
        border-radius: 0.3em;
        border: 1px solid black;
    }
    button {
        margin-top: 10px;
        padding: 10px;
        align-self: center;
    }
    select {
        height: 3em;
        border-radius: 0.3em;
        border: 1px solid black;
        width: 30%;
        text-indent: 5px;
        text-transform: capitalize;
        font-family: 'Open Sans', sans-serif;
        font-size: 0.8em; 
    } 
}

</style>
