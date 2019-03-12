<template>
    <footer id="footer_main">
      <span>&copy;2019 - Virginie Kernel / Simplon.co - Sarcelles</span>
      <div id="social">
        
      </div>
      <ul id="social">
        <li>instagram</li>
        <li>facebook</li>
        <li>pinterest</li>
      </ul>
  </footer>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
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
  margin-top: 10px;
}

#social > li {
  padding: 0 10px;
}
</style>