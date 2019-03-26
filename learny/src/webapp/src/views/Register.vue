<template>
  <div class="page register">
    <h1>Register</h1>
    <p>
      If you already have an account, please <router-link to="/login">log in</router-link>
    </p>
    <FormRegister />
  </div>
</template>

<script>
import FormRegister from "@/components/FormRegister.vue";
export default {
  components: {
    FormRegister
  }
};
</script>

<style>
</style>
