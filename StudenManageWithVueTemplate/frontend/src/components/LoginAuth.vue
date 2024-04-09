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
    <div class="login container">
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
    </div>
  </template>
  
