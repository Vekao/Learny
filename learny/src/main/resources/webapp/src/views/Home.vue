<template>
  <section class="page_home">
    <figure>
      <img id="logo" src="@/assets/logo.svg" alt="logo">
    </figure>
    <h1>COURS DE LOISIRS CREATIFS</h1>
    <p class="description">
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus, id delectus. Rerum porro, 
      at magni nobis suscipit dolorum nesciunt nemo ad iste, quibusdam, voluptatum laborum error officiis. 
      Aspernatur, ipsa eligendi.
    </p>
    <button id="btn">COMMENCER</button>
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
.page_home {
  display: flex;
  flex-direction: column;
}

p {
  max-width: 800px;
  padding: 10px 50px;
  margin: 20px 20px;
  margin-top: 2em;
  margin: 20px auto;
}

h1, p {
  text-align: center;
}

h1 {
  margin-top: 2em;
  font-size: 50px;
  font-family: 'Oswald', sans-serif;
  font-weight: 500;
}

#logo {
  height: 300px;
  align-items: center;
  margin-top: 66px;
}

#btn {
  align-items: center;
  background-color: purple;
  border: none;
  border-radius: 0.3em;
  color: white;
  font-family: 'Oswald', sans-serif;
  font-size: 1.2em;
  letter-spacing: 2px;
  margin: 0 auto;
  padding: 10px 20px;
}
</style>

