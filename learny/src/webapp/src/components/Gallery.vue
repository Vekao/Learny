<template>
    <div class="gallery">
        <header class="titles">
            <h3>{{ title }}</h3>
            <h4 v-if="hasSubtitle">{{ subtitle }}</h4>  
        </header>
        <div class="thumbnails">
            <CourseThumbnail v-for="course in courses" :key="course.id" :img="course.thumbnail" :title="course.title" :id="course.id"/>
        </div>  
    </div>
</template>

<script>
import CourseThumbnail from "@/components/CourseThumbnail.vue";
export default {
    data() {
        return {
            isProject: this.$props.subtitle === "projets" 
        }
    },
    components: {
        CourseThumbnail
    },
    props: { 
        title: String,
        courses: Array,
        hasSubtitle: Boolean,
        subtitle: String
    }
}
</script>

<style>

.thumbnails {
    display: flex;
    flex-wrap: wrap;
}

</style>


<style lang="scss" scoped>
//gallery courses title
h3 {
    background-color: #323232;
    padding: 11px 200px 12px 20px;
    color: white;
    font-family: 'Open sans', sans-serif;
    font-size: 1.25em;
    font-weight: 400;
    text-transform: uppercase;
    margin-right: 50px;
    ::after {
        content: "";
        position: absolute;
        right: 0px;
        bottom: 0;
        width: 0;
        height: 0;
        border-right: 20px solid red;
        border-top: 30px solid transparent;
        border-bottom: 24px solid transparent;
    }  
}


h4 {
    font-size: 22px;
    font-weight: normal;
    text-transform: capitalize;
    padding-top: 10px;
    padding-bottom: 12px;
}

div.gallery {
    padding: 20px 6%;  
}

.titles {
    display: flex;
    margin-bottom: 25px;
}



</style>




