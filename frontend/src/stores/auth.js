import {defineStore} from 'pinia'
import apiClient from "@/assets/plugins/apiClient";
import router from "@/router";
import {useNotificationStore} from "@/stores/notification";


export const useAuthStore = defineStore('auth', {

        state: () => ({
            token: localStorage.getItem('leechtoken'),
            user: null,
            loggedin:false
        }),
        getters: {
            isLoggedin: (state) => state.loggedin
        },
        actions: {
            checkLogin(){
                apiClient.get('/user/islogged')
                    .then(()=>this.loggedin=true)
                    .catch(()=>this.loggedin=false)
            },
            signup(credentials) {
                return apiClient.post('/auth/signup', credentials)
                    .then(res => {
                        useNotificationStore().notify(res.data)
                    })
                    .catch((e) =>{
                        useNotificationStore().notify(e.message,"error")
                    })
            },
            login(credentials) {
                apiClient.post('/auth/login', credentials)
                    .then(res => {
                        this.token = res.data.token
                        localStorage.setItem('leechtoken', this.token)
                        router.push('/dashboard')
                        this.user = res.data.user
                        this.loggedin=true;
                        useNotificationStore().notify("You are logged in.")
                    })
                    .catch((e) =>{
                        useNotificationStore().notify("not correct username or password" + e.message,"error")
                    })
            },
            setToken(token) {
                this.token = token;
                localStorage.setItem("leechtoken", token);
            },

            logout(sync = false) {
                if (!this.token) return;

                const token = this.token;

                // clear immediately
                this.token = null;
                localStorage.removeItem("leechtoken");
                this.loggedin=false;
                router.push('/')


                if (sync) {
                    // works even if window is closing
                    const blob = new Blob([JSON.stringify({token})], {type: "application/json"});
                    navigator.sendBeacon("/auth/logout", blob);
                } else {
                    // normal logout (user clicks button, etc.)
                    fetch("/auth/logout", {
                        method: "POST",
                        headers: {"Content-Type": "application/json"},
                        body: JSON.stringify({token}),
                    }).catch(() => {
                        // ignore network errors
                    });
                }
            }

        }
    }
)
