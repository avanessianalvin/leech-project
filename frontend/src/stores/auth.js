import {defineStore} from 'pinia'
import apiClient from "@/assets/plugins/apiClient";
import router from "@/router";
import {useNotificationStore} from "@/stores/notification";


export const useAuthStore = defineStore('auth', {

        state: () => ({
            token: localStorage.getItem('leechtoken'),
            user: null
        }),
        getters: {
            isLoggedIn: (state) => !!state.user
        },
        actions: {
            login(credentials) {
                apiClient.post('/auth/login', credentials)
                    .then(res => {
                        this.token = res.data.token
                        localStorage.setItem('leechtoken', this.token)
                        router.push('/dashboard')
                        this.user = res.data.user
                        useNotificationStore().notify("You are logged in.")
                    })
                    .catch((e) =>{
                        useNotificationStore().notify("not correct username or password" + e.message,"error")
                    })

            },
            logout() {
                apiClient.post('/auth/logout')
                    .then(() => {
                        this.token = ''
                        localStorage.removeItem('leechtoken')
                        router.push('/')
                        this.user = null
                        useNotificationStore().notify("Logged out successfully")
                    })
                    .catch(e => alert('error in logout' + e))

            }
        }
    }
)
