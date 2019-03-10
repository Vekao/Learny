<template>

 
    <nav id="nav_main">
        <a v-for="category in categories" v-bind:key="category">{{ category.label }}</a>
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
           return axios.get(URL).then(response => {
               this.categories = response.data;
           }).catch(error => {
               alert(error);
           })
       }
    }
}
</script>

<style lang="scss" scoped>
#menu {
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    margin-left: 10%;
    width: 80%;
}

#menu a {
    color: black;
    font-weight: 300;
    font-size: 1.375em;
}

</style>

