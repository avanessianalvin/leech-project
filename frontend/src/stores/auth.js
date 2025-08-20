import {defineStore} from 'pinia'
import apiClient from "@/assets/plugins/apiClient";

export const useAuthStore = defineStore('auth', {
        state: () => ({
            token:localStorage.getItem('leechtoken'),
            username: null
        }),
        getters: {
            isLoggedIn: (state) => !!state.username
        },
        actions: {
            login(credentials) {
                apiClient.post('/auth/login',credentials)
                    .then(res=>{
                        this.token = res.data.token
                        localStorage.setItem('leechtoken',this.token)
                        alert('logged in')
                    })
                    .catch(e=>alert('not logged in' + e))

            },
            logout() {
                apiClient.post('/auth/logout')
                    .then(()=>{
                        this.token = ''
                        localStorage.setItem('leechtoken',this.token)
                        alert('logged out')
                    })
                    .catch(e=>alert('error in logout' + e))

            }
        }
    }
)