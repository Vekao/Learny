<template>
    <nav id="menu">
        <a id="nav_home" href="/">Learny</a>
        <a v-for="category in categories" v-bind:key="category">{{ category.label }}</a>
    </nav>
</template>

<script>
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

<style>
#nav_home {
    background-image: url(../assets/logo.svg);
    display: inline-block;
    background-size: 55px auto;
    background-repeat: no-repeat;
    text-indent: -9999999999999px;
    overflow: hidden;
}

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

nav {
    height: 74px;
}

</style>
