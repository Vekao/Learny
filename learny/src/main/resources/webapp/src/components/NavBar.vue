<template>
    <nav>
        <a v-for="category in categories" :href="category.url">{{ category.label }}</a>
    </nav>
</template>

<script>
import axios from "axios";
const URL = "http://localhost:8090/api/categories";
export default {
    name: "NavBar",
    data() {
        return { categories: [] }
    },
    methods: {
       getCategories() {
           return axios.get(URL).then(response => {
               this.categories = response.data;
           }).catch(error => {
               console.error(error);
           })
       }
    }
}
</script>

<style>

</style>
