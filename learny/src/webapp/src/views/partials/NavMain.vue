<template>
  <nav id="nav_main">
    <router-link
      v-for="(category, n) in categories"
      :key="n"
      :to="'/gallery/category/' + category.id"
    >{{ category.label }}</router-link>
  </nav>
</template>

<script>
// FOR DYNAMIC MENU :
export default {
  name: "NavBar",
  created() {
    this.$store.dispatch("category/getAll");
  },
  computed: {
    categories() {
      return this.$store.getters["category/all"];
    }
  },
  data() {
    return { };
  },
  methods: {}
};
</script>

<style lang="scss" scoped>
#nav_main {
  display: flex;
  justify-content: space-around;
  text-transform: uppercase;
  flex-direction: row;
  width: 100%;
  white-space: nowrap;
}

#nav_main a {
  color: black;
  font-weight: 300;
  font-size: 1.15em;
  text-decoration: none;
}
</style>

