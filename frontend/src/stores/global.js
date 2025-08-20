import {defineStore} from 'pinia'

export const useGlobalStore = defineStore('global', {
        state: () => ({
            username: null
        }),
        getters: {
            isLoggedIn: (state) => !!state.username
        },
        actions: {
            login(username) {
                this.username = username;

            },
            logout() {
                this.username = null

            }
        }
    }
)