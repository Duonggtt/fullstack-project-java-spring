<script lang="ts" setup>
import { useAuthStore } from '../stores/auth';
import toastr from 'toastr';

const auth = useAuthStore();

function logout() {
    auth.logout();
    toastr.info('Logout successfully!');
}
</script>

<template>
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
          </li>
        </ul>
    
        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" data-widget="fullscreen" href="#" role="button">
              <i class="fas fa-expand-arrows-alt"></i>
            </a>
          </li>
          <li class="nav-item">
            <a @click="logout" class="nav-link" data-widget="control-sidebar" data-controlsidebar-slide="true" href="#" role="button">
              Logout
            </a>
          </li>
        </ul>
      </nav>
</template>

