<template>
<div class="course page">
    <header>
        <h2>{{ currentCourse.category.label }}</h2>
        <h3>{{ currentCourse.title }}</h3>
    </header>
    <main >
        <CourseViewer />
    </main>
</div>

</template>

<script>
import CourseViewer from "@/components/CourseViewer.vue";
export default {
    components: {
        CourseViewer
    },
    props: {
        title: String,
        category: String
    },
    computed: {
        currentCourse() {
            return this.$store.getters["course/byId"]
        }
    },
    created() {
        this.$store.dispatch("course/getById", this.$route.params.course);
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
    margin-top: 10px;
}
</style>
