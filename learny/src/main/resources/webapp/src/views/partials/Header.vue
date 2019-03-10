<template>
    <header id="header_main">
        <Logo />
        <NavMain />
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
    height: 74px;
    // border-bottom: 1px solid #e4e4e4;
    border-bottom: 1px solid rgba(0,0,0,0.14);
}
</style>



