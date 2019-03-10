<template>
    <main class="page gallery">
        <h2>{{ title }}</h2>
        <Gallery v-for="section in sections" :key="section.id" :title="section.title" />
    </main>
</template>

<script>
import axios from "axios";
import Gallery from "@/components/Gallery.vue"

const urlCourses = 'http://localhost:8090/api/courses';
export default {
    name:"gallery",
    components: {
        Gallery
    },
    
    data() {
        return {
            title: '',
            sections: []
        }
    },
    
    mounted() {
        this.getCategories()
    },
    
    beforeRouteUpdate: function(to, from, next) {
        next()
        this.getCategories()
    },
    
    methods: {
        getCategories() {
            this.title = "tous les cours";
        }
    }
}
</script>

<style lang="scss" scoped>

h2 {
    font-family: 'Oswald', sans-serif;
    font-weight: 600;
    font-size: 40px;
    text-align: center;
}

.gallery {
    margin-top: 46px;
}
</style>


