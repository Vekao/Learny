<template> 
        <div>
            <button class="title active">Schémas</button>
            <button class="title active">Photos</button>
            <button class="title active">Vidéos</button>
            <div class="content"><iframe class="cadre" width="800" height="450" src="https://www.youtube.com/embed/4Q46xYqUwZQ" frameborder="0"
                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>
            <!-- <b-tabs content-class="mt-3">
                <b-tab class="nav" title="Schémas" active></b-tab>
                <b-tab class="nav" title="Photos"></b-tab>
                <b-tab class="nav" title="Vidéos"><iframe class="cadre" width="800" height="450" src="https://www.youtube.com/embed/4Q46xYqUwZQ" frameborder="0"
                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></b-tab>
            </b-tabs> -->
        </div>
</template>

<script>
import Gallery from "@/components/Gallery.vue";

export default {
    
    name: "gallery",
    components: {
    Gallery
    },
    
    computed: {
        currentCategory() {
            return this.$store.getters["category/byId"](Number(this.$route.params.category))
        }
    }, 
   
  mounted() {
    this.getCategory();
  }
}
</script>

<style lang="scss" scoped>
section {
    padding: 20px 0;
}

.nav {
    font-family: "Open Sans", sans-serif;
    font-size: 22px;
}

.cadre {
    border: 1px solid #323232;
    height: 500px;
}

</style>
