import { createRouter, createWebHistory } from 'vue-router'

import ViewStudents from '../views/ViewStudents.vue'
import ViewMajors from '../views/ViewMajors.vue'
import ViewClazzs from '../views/ViewClazzs.vue'

import AddStudent from '../views/AddStudent.vue'
import AddMajor from '../views/AddMajor.vue'
import AddClazz from '../views/AddClazz.vue'

import UpdateMajor from '../views/UpdateMajor.vue'
import UpdateStudent from '../views/UpdateStudent.vue'
import UpdateClazz from '../views/UpdateClazz.vue'

import Login from '../components/LoginAuth.vue'
import { useAuthStore } from '../stores/auth'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },

    // student
    {
      path: '/student/list',
      name: 'ViewStudents',
      component: ViewStudents
    },
    {
      path: '/student/create',
      name: 'createStudent',
      component: AddStudent
    },
    {
      path: '/student/update/:id',
      name: 'updateStudent',
      component: UpdateStudent
    },

    //Major
    {
      path: '/major/list',
      name: 'ViewMajors',
      component: ViewMajors
    },
    {
      path: '/major/create',
      name: 'CreateMajor',
      component: AddMajor
    },
    {
      path: '/major/update/:id',
      name: 'UpdateMajor',
      component: UpdateMajor
    },

    //clazz
  
    {
      path: '/clazz/list',
      name: 'ViewClazzs',
      component: ViewClazzs
    },
    {
      path: '/clazz/create',
      name: 'CreateClazz',
      component: AddClazz
    },
    {
      path: '/clazz/update/:id',
      name: 'UpdateClazz',
      component: UpdateClazz
    },


  ]
});
router.beforeEach(async (to) => {
  const publicPages = ['/'];
  const authRequired = !publicPages.includes(to.path);
  const auth = useAuthStore();
  if(authRequired && auth.user == '') {
    return '/'
  }
})

export default router
