<template>
  <nav id="nav_admin" class="nav">
        <ul class="list">
            <router-link tag="li" class="link" to="/profile/admin/manage-ressources">Liste des cours</router-link>
            <li>Editer un cours</li>
        </ul>
  </nav>
</template>

<script>

export default {};
</script>

<style scoped lang="scss">
.nav {
  display: flex;
  flex-direction: column;
  padding: 10px 0;
  .list {
    list-style: none;
    text-align: left;
    padding-left: 15%;
  }
}
</style>
