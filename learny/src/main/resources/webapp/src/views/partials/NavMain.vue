<template>
    <nav id="nav_main">
        <router-link v-for="category in categories" :key="category" :to="'/gallery/category/' + category.id">{{ category.label }}</router-link>
    </nav>

</template>

<script>

// FOR DYNAMIC MENU :
import axios from "axios";

const URL = "http://localhost:8090/api/categories";
export default {
    name: "NavBar",
    mounted() {
        this.getCategories();
    },
    data() {
        return { categories: [] }
    },
    methods: {
       getCategories() {
           axios.get(URL).then(response => {
               this.categories = response.data;
           }).catch(error => {
               alert(error);
           })
       }
    }
}
</script>

<style lang="scss" scoped>
#nav_main {
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    margin-left: 10%;
    width: 80%;
    
}

#nav_main a {
    color: black;
    font-weight: 300;
    font-size: 1.375em;
    text-decoration: none;
}

</style>

