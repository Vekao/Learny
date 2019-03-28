<template>
  <footer id="footer_main">
    <ul id="social">
      <li class="facebook"><a href="https://www.facebook.com/latelierdevekao/" target="_blank" class="fab fa-facebook-square fa-2x"></a></li>
      <li class="facebook"><a href="https://www.instagram.com/atelier_vekao/" target="_blank" class="fab fa-instagram fa-2x"></a></li>
      <li class="facebook"><a href="https://www.pinterest.fr/vekao/" target="_blank" class="fab fa-pinterest-square fa-2x"></a></li>
    </ul>

    <span>&copy;2019 - Virginie Kernel / Simplon.co - Sarcelles</span>  
  </footer>
</template>

<script>
  export default {}
</script>

<style lang="scss" scoped>
.fab:hover {
  color: #7c2993;
  transition: all 0.5s;
  text-decoration: none;
}

.fab {
  transition: all 0.5s;
}

#footer_main {
  padding: 20px 20px;
  height: 120px;
  background: #323232;
  color: white;
  position: relative;
  font-size: 14px;
  text-align: center;
}

#social {
  display: flex;
  list-style-type: none;
  justify-content: center; 
  margin-bottom: 20px;  
}

a {
  color: white;
  text-decoration: none;
  padding: 0 10px;
}

</style>