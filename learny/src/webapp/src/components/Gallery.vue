<template>
    <div class="gallery" :class="{isProject: 'project'}">
        <header class="titles">
            <h3>{{ title }}</h3>
            <h4 v-if="hasSubtitle">{{ subtitle }}</h4>  
        </header>
        <div class="thumbnails">
            <CourseThumbnail v-for="course in courses" :key="course.id" :img="course.thumbnail" :title="course.title"/>
        </div>  
    </div>
</template>

<script>
import CourseThumbnail from "@/components/CourseThumbnail.vue";
export default {
    data() {
        return {
            isProject: this.props.subtitle === "projets" 
        }
    },
  
    components: {
        CourseThumbnail
    },
    props: { 
        title: String,
        courses: Object,
        hasSubtitle: Boolean,
        subtitle: String
    }
}
</script>

<style lang="scss" scoped>
h3 {
    background-color: #323232;
    padding: 11px 200px 12px 20px;
    color: white;
    font-family: 'Open sans', sans-serif;
    font-size: 22px;
    font-weight: 400;
    text-transform: uppercase;
    margin-right: 50px;  
}

// h3::after {
//     content: "";
//     background-image: url("../../assets/miniban.jpg");
//     background-repeat: no-repeat;
//     margin-left: 103px;
//     width: 45px;
//     height: 45px;
    
//     position: absolute;
// }

// h4::before {
//     display: block;
//     content: "";
//     background-color: white;
//     width: 45px;
//     height: 45px;
//     transform: rotate(45deg);
//     margin-left: -103px;
//     margin-top: -7px;
//     position: absolute;
// }
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

.thumbnails {
    display: flex;
}

</style>




