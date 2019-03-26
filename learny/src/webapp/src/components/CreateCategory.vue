<template>
    <form id="form-course" @submit="$event.preventDefault();$store.dispatch('category/create', category);">
        <label for="">Label de la catégorie</label>
        <input type="text" v-model="category.label">
        <button>Créer</button>
    </form>
</template>

<script>
export default {
    created() {
        this.$store.dispatch("category/getAll");
    },
    data() {
        return {
            category: {
                label: null
            }
        }
    },
}
</script>

<style lang="scss" scoped>
#form-course {
    display: flex;
    flex-direction: column;
    width: 50%;
    margin: 0 auto;
    margin-top: 50px;
    margin-bottom: 30px;
    label {
        align-self: start;
        margin-bottom: 5px;
        margin-top: 20px;
    }
    input {
        padding: 10px;
        border-radius: 0.3em;
        border: 1px solid black;
    }
    button {
        margin-top: 10px;
        padding: 10px;
        align-self: center;
    }
    select {
        height: 3em;
        border-radius: 0.3em;
        border: 1px solid black;
        width: 30%;
        text-indent: 5px;
        text-transform: capitalize;
        font-family: 'Open Sans', sans-serif;
        font-size: 0.8em; 
    }
    
}

</style>
