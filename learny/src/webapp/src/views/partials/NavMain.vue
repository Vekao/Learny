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
    justify-content: space-around;
    text-transform: uppercase;
    flex-direction: row;
    width: 100%;
    white-space: nowrap;
}

#nav_main a {
    color: black;
    font-weight: 300;
    font-size: 1.25em;
    text-decoration: none;
}

</style>

