import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import ProfileView from '../views/ProfileView.vue'
import ElementView from "@/views/ElementView";
import ChainView from "@/views/ChainView";
import DashboardView from "@/views/DashboardView.vue";

const routes = [
    { path: '/', name: 'home', component: HomeView },
    { path: '/dashboard', name: 'dashboard', component: DashboardView },
    { path: '/element', name: 'element', component: ElementView },
    { path: '/chain', name: 'chain', component: ChainView },
    { path: '/about', name: 'about', component: AboutView },
    { path: '/profile', name: 'profile', component: ProfileView },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
