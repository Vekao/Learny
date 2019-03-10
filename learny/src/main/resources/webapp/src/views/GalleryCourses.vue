<template>
    <main>
        <h2>{{ title }}</h2>
        <div id="gallery"></div>
    </main>
</template>

<script>
import axios from "axios";

const urlCourses = 'http://localhost:8080/api/courses';
export default {
    name:"Gallery",
    mounted() {
        
    }
    
}
</script>

<style>

</style>
