<template>
  <section class="page home">
    <figure class=figure_logo>
      <img id="logo" src="@/assets/logo.svg" alt="logo">
    </figure>
    <h1>LEARNY</h1>
    <h2>Cours de loisirs créatifs en ligne</h2>
    <p class="description">
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus, id delectus. Rerum porro, 
      at magni nobis suscipit dolorum nesciunt nemo ad iste, quibusdam, voluptatum laborum error officiis. 
      Aspernatur, ipsa eligendi.
    </p>
    <router-link to="/gallery" tag="button" id="btn" class="btn">COMMENCER</router-link>
  </section>
  
</template>

<script>
// @ is an alias to /src
export default {
  name: 'home',
  components: {
    
  }
}
</script>

<style lang="scss" scoped>
.home {
  display: flex;
  flex-direction: column;
  margin-top: 66px;
  margin-bottom: 60px;
}

.figure_logo {
  text-align: center;
}

p {
  max-width: 800px;
  padding: 10px 50px;
  margin: 20px auto;
}

h1, h2, p {
  text-align: center;
}

h1 {
  margin-top: 20px;
  font-size: 70px;
  font-family: 'Oswald', sans-serif;
  font-weight: 600;
}

h2 {
  font-family: 'Oswald', sans-serif;
  font-size: 30px;
  font-weight: 500;
}


#logo {
  height: 300px;
  align-items: center;
}

#btn {
  align-items: center;
  background-color: #7c2993;
  border: none;
  border-radius: 0.3em;
  color: white;
  font-family: 'Open sans', sans-serif;
  font-size: 1.125em;
  margin: 0 auto;
  padding: 10px 20px;
}

</style>

