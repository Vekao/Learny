<template>
    <div class="page gallery">
        <h3>{{ title }}</h3>
        <h4 v-if="hasSubtitle">{{ subtitle }}</h4>
        <CourseThumbnail v-for="course in courses" :key="course.id" :img="course.thumbnail" :title="course.title"/>
    </div>
</template>

<script>
import CourseThumbnail from "@/components/CourseThumbnail.vue";
export default {
    components: {
        CourseThumbnail
    },
    props: { 
        title: String,
        courses: Object
    }
}
</script>

<style>
h3 {
    background-color: #323232;
    background-image: url("../assets/ban.svg");
    background-repeat: no-repeat;
    color: white;
    font-family: 'Open sans', sans-serif;
    font-weight: 400;
    font-size: 22px;
    margin-bottom: 25px;
    text-transform: uppercase;  
}

.gallery {
    padding: 20px 6%;
    height: 300px;  
}

</style>
