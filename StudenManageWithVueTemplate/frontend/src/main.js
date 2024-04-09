import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import './assets/css/tailwind.css'
import { createPinia } from 'pinia'

const pinia = createPinia()
const app = createApp(App)

// Use Pinia with your Vue application
app.use(createPinia());
app.use(router)

app.mount('#app')
