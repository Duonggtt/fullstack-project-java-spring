<script lang="ts" setup>
    import toastr from 'toastr';
    import 'toastr/build/toastr.min.css';
    import { useAuthStore } from '../stores/auth';
    import { reactive } from 'vue';

    const user = reactive({
      username: '',
      password: ''
    });

    function onSubmit() {
        console.log(user);
        if(user.username !== '' && user.password !== '') {
            useAuthStore().login(user.username, user.password);
        }
    }

      
  </script>

<template>
    <!-- <div class="login container">
      <h2 class="text-center mt-5">Login</h2>
      <div class="mb-4 " style="display: flex; justify-content: center; align-items: center;">
        <form @submit.prevent="onSubmit" class="mt-5 p-8 shadow-md rounded-md col-md-3">
          <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" v-model="user.username" class="form-control" placeholder="username" required>
          </div>
          <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" v-model="user.password" class="form-control" placeholder="password" required>
          </div>
          <div style="text-align: center;">
            <button type="submit" class="btn btn-primary mt-3">Login</button>
          </div>
        </form>
      </div>
    </div> -->

    <section class="ftco-section img js-fullheight">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-6 text-center mb-5">
            <h2 class="heading-section">Login Here</h2>
          </div>
        </div>
        <div class="row justify-content-center">
          <div class="col-md-6 col-lg-4">
            <div class="login-wrap p-0">
              <h3 class="mb-4 text-center">STUDENT MANAGE</h3>
              <form @submit.prevent="onSubmit" class="signin-form">
                <div class="form-group">
                  <input type="text" id="username" v-model="user.username" class="form-control" placeholder="Username" required>
                </div>
                <div class="form-group">
                  <input type="password" id="password" v-model="user.password" class="form-control" placeholder="Password" required>
                  <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                </div>
                <div class="form-group">
                  <button type="submit" class="form-control btn btn-primary submit px-3">Sign In</button>
                </div>
                <div class="form-group d-md-flex">
                  <div class="w-50">
                    <label class="checkbox-wrap checkbox-primary">Remember Me
                      <input type="checkbox" checked>
                      <span class="checkmark"></span>
                    </label>
                  </div>
                  <div class="w-50 text-md-right">
                    <a href="#" style="color: #fff">Forgot Password</a>
                  </div>
                </div>
              </form>
              <p class="w-100 text-center">&mdash; Or Sign In With &mdash;</p>
              <div class="social d-flex text-center">
                <a href="#" class="px-2 py-2 mr-md-1 rounded"><span class="ion-logo-facebook mr-2"></span> Facebook</a>
                <a href="#" class="px-2 py-2 ml-md-1 rounded"><span class="ion-logo-twitter mr-2"></span> Twitter</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </template>
  

  <style scoped>
    section {
      background-image: url(../assets/images/bg.jpg);
      background-repeat: no-repeat;
      background-size: cover; /* Change to 'contain' if you want to see the entire image */
      background-position: center; /* Center the image */
      height: 100vh; /* Full height */
      width: 100vw;
    }
</style>