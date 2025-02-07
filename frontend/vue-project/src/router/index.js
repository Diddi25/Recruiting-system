import { createRouter, createWebHistory } from 'vue-router'
import HomePresenter from '@/presenters/HomePresenter'
import RegisterPresenter from '@/presenters/RegisterPresenter'
import LoginPresenter from '@/presenters/LoginPresenter'
import ApplicationPresenter from '@/presenters/ApplicationPresenter'
import ApplicationListPresenter from '@/presenters/ApplicationListPresenter'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePresenter,
    },
    {
      path: '/register',
      name: 'register',
      component: RegisterPresenter,
    },
    {
      path: '/login',
      name: 'login',
      component: LoginPresenter,
    },
    {
      path: '/apply',
      name: 'apply',
      component: ApplicationPresenter,
    },
    {
      path: '/applications',
      name: 'applications',
      component: ApplicationListPresenter,
    },
  ],
})

export default router
