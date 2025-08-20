import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import ProfileView from '../views/ProfileView.vue'
import ElementView from "@/views/ElementView";
import ChainView from "@/views/ChainView";

const routes = [
    { path: '/', name: 'Home', component: HomeView },
    { path: '/', name: 'Element', component: ElementView },
    { path: '/', name: 'Chain', component: ChainView },
    { path: '/about', name: 'About', component: AboutView },
    { path: '/profile', name: 'Profile', component: ProfileView },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
