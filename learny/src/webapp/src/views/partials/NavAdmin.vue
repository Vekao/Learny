<template>
  <nav id="nav_admin" class="nav">
        <ul class="list">
            <router-link tag="li" class="link clickable" to="/admin/create">Créer un cours</router-link>
            <router-link tag="li" class="link clickable" to="/admin/edit">Editer un cours</router-link>
            <li>Liste des cours</li>
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
  padding-top: 20%;
  line-height : 2.5;
  .list {
    list-style: none;
    text-align: left;
    padding-left: 15%;
    :hover {
      color: #7c2993;
    }
  }
}
</style>
