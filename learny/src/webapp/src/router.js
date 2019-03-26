import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/login',
      name: 'login',
      component: () => import( /* webpackChunkName: "about" */ './components/FormLogin.vue')
    },
    {
      path: "/register",
      name: "register",
      component: () =>
      import(/* webpackChunkName: "register" */ "./views/Register.vue")
    },

    {
      path: '/admin',
      name: 'admin',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import( /* webpackChunkName: "about" */ './views/AdminPanel.vue'),
      children: [
        {
          path: 'create-category',
          name: 'create-category',
          component: () => import( /* webpackChunkName: "create-course" */ './components/CreateCategory.vue')
        },
        {
          path: 'manage-category',
          name: 'manage-category',
          component: () => import( /* webpackChunkName: "create-course" */ './components/ManageCategory.vue')
        },
        {
          path: 'create-course',
          name: 'create-course',
          component: () => import( /* webpackChunkName: "create-course" */ './components/CreateCourse.vue')
        },
        {
          path: 'edit',
          name: 'edit',
          component: () => import( /* webpackChunkName: "edit-course" */ './components/EditCourse.vue')
        }
      ]
    },
    {
      path: '/gallery',
      name: 'allgallery',
      component: () => import( /* webpackChunkName: "about" */ './views/GalleryAllCourses.vue')
    },
    {
      path: '/gallery/category/:category',
      name: 'gallery',
      component: () => import( /* webpackChunkName: "about" */ './views/GalleryCourses.vue')
    },
    {
      path: "*",
      name: "404",
      component: () => import( /* webpackChunkName: "404" */ './views/NotFound.vue')
    }
  ]
})