<template>
    <main class="page gallery">
        <h2>{{ title }}</h2>
        <Gallery v-for="section in sections" 
                :key="section.id" 
                :title="section.title" 
                :courses="section.courses" 
                :hasSubtitle="section.hasSubtitle"
                :subtitle="section.subtitle"/>
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
            title: "tous les cours",
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
            this.sections = [
                { id: 11, title: "tricot", hasSubtitle: true, subtitle: "techniques", courses: []},
                { id: 12, title: "tricot", hasSubtitle: true, subtitle: "projets", courses: [
                    { id: 1, title: "Tricoter un bonnet", thumbnail: "vignette_01.jpg"},
                    { id: 2, title: "Tricoter des mitaines", thumbnail: "vignette_02.jpg"},
                    { id: 3, title: "Tricoter un snood", thumbnail: "vignette_03.jpg"}
                ]},
                { id: 21, title: "crochet", hasSubtitle: true, subtitle: "techniques", courses: []},
                { id: 22, title: "crochet", hasSubtitle: true, subtitle: "projets", courses: [
                    { id: 4, title: "Tricoter un bonnet", thumbnail: "vignette_01.jpg"},
                    { id: 5, title: "Tricoter des mitaines", thumbnail: "vignette_02.jpg"},
                    { id: 6, title: "Tricoter un snood", thumbnail: "vignette_03.jpg"}
                ]},
                { id: 31, title: "couture", hasSubtitle: true, subtitle: "techniques", courses: []},
                { id: 32, title: "couture", hasSubtitle: true, subtitle: "projets", courses: [
                    { id: 7, title: "Tricoter un bonnet", thumbnail: "vignette_01.jpg"},
                    { id: 8, title: "Tricoter des mitaines", thumbnail: "vignette_02.jpg"},
                    { id: 9, title: "Tricoter un snood", thumbnail: "vignette_03.jpg"}
                ]}
            ]
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
    text-transform: uppercase; 
}

</style>


