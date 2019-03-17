<template>
  <div id="app">
    <div id="nav">
      <HeaderMain />
    </div>
    <router-view/>
    <FooterMain />
  </div>
</template>

<script>
import HeaderMain from "@/views/partials/Header.vue";
import FooterMain from "@/views/partials/Footer.vue";

export default {
  components: {
    HeaderMain,
    FooterMain 
  }
}
</script>

<style lang="scss">
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

body {
  font-size: 16px;
  overflow-x: hidden;
  width: 100%;  
}

.page {
  position :relative;
  min-height: calc(100vh - (74px + 120px));
}

#app {
  color: #323232;
  font-family: 'Open Sans', sans-serif;
  letter-spacing: 1px;
}

.clickable, .btn, .link {
    cursor: pointer;
}
</style>
