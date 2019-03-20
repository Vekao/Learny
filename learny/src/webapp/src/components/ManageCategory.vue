<template>
    <div class="categories sub-page">
        <h2>Editer les catégories</h2>
        <div class="category" v-for="(cat, i) in categories" :key="i">
            <input v-model="cat.label" @change="$store.dispatch('category/update', cat)" />
            <!-- <router-link :to="'/admin/edit/category/' + cat.id " tag="button">edit</router-link> -->
            <!--button @click="$store.dispatch('category/update', cat)">Editer</button-->
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
    },
    methods: {
        isEditing() {
            return this.$route.path.match("edit"); // si l'url de la page contient 'edit'
        },
        submit() {
            if (this.isEditing()) {
                this.$store.dispatch('category/update', this.category)
            } else {
                this.$store.dispatch('category/create', this.category)
            }
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
