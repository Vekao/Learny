<template>
    <header id="header_main">
        <Logo />
        <NavMain />
        <router-link to="/admin-panel" tag="button" class="btn btn-connect">Se connecter</router-link>
    </header>
</template>

<script>
import Logo from "@/components/Logo.vue";
import NavMain from "./NavMain.vue";

export default {
    components: {
        Logo,
        NavMain
    }
}
</script>

<style lang="scss" scoped>
#header_main {
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-items: center;
    height: 74px;
    padding: 0 50px;
    border-bottom: 1px solid rgba(0,0,0,0.14);
}

.btn-connect {
  align-items: center;
  background-color: #7c2993;
  border: none;
  border-radius: 0.3em;
  color: white;
  font-family: 'Open sans', sans-serif;
  font-size: 1.125em;
  padding: 10px 20px;
  white-space: nowrap;
}
</style>



