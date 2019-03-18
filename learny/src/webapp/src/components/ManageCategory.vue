<template>
    <div class="categories sub-page">
        <h2>Editer les catégories</h2>
        <div class="category" v-for="(cat, i) in categories" :key="i">
            {{ cat.label }}
            <router-link :to="'/admin/edit/category/' + cat.id " tag="button">edit</router-link>
            <button @click="$store.dispatch('category/delete', cat.id)">Supprimer</button>
            <!-- <router-link :to="'/admin/delete/category/' + cat.id " tag="button">delete</router-link> -->
        </div>
    </div>
</template>

<script>
export default {
    beforeCreate() {
        this.$store.dispatch("category/getAll")
    },
    computed: {
        categories() {
            return this.$store.getters["category/all"];
        }
    }
}
</script>

<style scoped lang="scss">
.categories {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    .category {
        flex-direction: row;
        border: 1px solid;
        border-radius: .3rem;
        width: 50%;
        height: 2em;
        align-content: center; 
    }
    
    h2 {
        text-align: center;
    }
}
</style>
