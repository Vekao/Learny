<template>
  <main class="page section">
    <h2 class="title">{{ currentCategory.label }}</h2>
    <Gallery
      v-for="section in sections"
      :key="section.id"
      :title="section.title"
      :courses="section.courses"
    />
  </main>
</template>

<script>
import Gallery from "@/components/Gallery.vue";


export default {
  name: "gallery",
  components: {
    Gallery
  },

  data() {
    return {
      sections: []
    };
  },
  computed: {
      currentCategory() {
          return this.$store.getters["category/byId"](Number(this.$route.params.category))
      }
  },
  mounted() {
    this.getCategory();
  },

  beforeRouteUpdate: function(to, from, next) {
    next();
    this.getCategory();
  },

  methods: {
    getCategory() {
      this.sections = [
        { id: 1, title: "techniques", hasSubtitle: false, courses: [] },
        {
          id: 2,
          title: "projets",
          hasSubtitle: false,
          courses: [
            {
              id: 1,
              title: "Tricoter un bonnet",
              thumbnail: "vignette_01.jpg"
            },
            {
              id: 2,
              title: "Tricoter des mitaines",
              thumbnail: "vignette_02.jpg"
            },
            { id: 3, title: "Tricoter un snood", thumbnail: "vignette_03.jpg" }
          ]
        }
      ];
    }
  }
};
</script>

<style lang="scss" scoped>
h2 {
  font-family: "Oswald", sans-serif;
  font-weight: 600;
  font-size: 40px;
  text-align: center;
  text-transform: uppercase; 
}

.section {
  margin-top: 46px;
  margin-bottom: 30px;
}
</style>


