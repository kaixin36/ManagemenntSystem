import { createRouter, createWebHistory } from 'vue-router'
import Layout from '@/layout/Layout.vue'
import Login from '@/views/Login.vue'
import User from '@/views/User.vue'
import UserRole from '@/views/UserRole.vue'

const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/Login.vue')
    
  },
  {
    path: '/',
    name: 'layout',
    component: Layout,
    children: [
      {
        path: '/user',
        name: 'user',
        component: User
      },
      {
        path: '/userRole',
        name: 'userRole',
        component: UserRole
      }
    ]
  }

  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
