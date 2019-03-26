<template>
    <main class="course page">
        <h2>TITRE</h2>
        <h3>Catégorie</h3>
        <CourseViewer />
    </main>
</template>

<script>
import CourseViewer from "@/components/CourseViewer.vue";
export default {
    components:{
        CourseViewer
    }
}

</script>

<style <style lang="scss" scoped>
.course {
    width: 800px;
    margin: 0 auto;
    top: 20px;
}

h2 {
    text-transform: uppercase;
    color: white;
    background-color: #323232;
    height: 45px;
    font-size: 30px;
    font-weight: 600;
    font-family: "Open Sans", sans-serif;
    padding: 3px 0 0 47px;
}

h3 {
    font-size: 20px;
    font-weight: 600;
    font-family: "Open Sans", sans-serif;
    margin-left: 47px;
}
</style>
