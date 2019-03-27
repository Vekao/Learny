<template>
    <form id="form-course" @submit="$event.preventDefault();postCourse();">
        <label for="">Titre du cours</label>
        <input type="text" v-model="course.title">
        <label for="">Catégorie</label>
        <select name="select">
            <option v-for="category in categories" :key="category">{{ category.label }}</option>  
        </select>
        <label for="">Type</label>
        
        <select name="select">
            <option v-for="type in types" :key="type">{{ type.label }}</option>  
        </select>
 
        <button>Créer</button>
    </form>
</template>

<script>
export default {

}
</script>

<style>

</style>
