<template>
    <div id="admin" class="page admin">
        <h2 class="title">DASHBOARD ADMINISTRATEUR</h2>
        <aside id="aside"> 
            <NavAdmin />
        </aside>
        <router-view class="sub-page"></router-view>
    </div>
</template>

<script>
import NavAdmin from "./partials/NavAdmin.vue";
export default {
    components:{
        NavAdmin
    }
}
</script>

<style lang="scss" scoped>
#admin {
  display: grid;
  grid-template-columns: repeat(10, 1fr);
  grid-template-rows: repeat(8, 1fr);
}

#aside {
  grid-column: 1 / 3;
  grid-row: 1 / 9;
  background-color: #a9adb0;
  color: white;
}

.title {
    margin-top: 20px;
    text-align: center;
    font-size: 40px;
    font-family: 'Oswald', sans-serif;
    font-weight: 600;
    grid-column: 3 / 11;
    grid-row: 1 / 2;
}

.sub-page {
  grid-row: 2 / 9;
  grid-column: 3 / 11;
  padding-left: 20px;
}
</style>

