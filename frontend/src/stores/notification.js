import { defineStore } from 'pinia'

export const useNotificationStore = defineStore('notification', {
    state: () => ({
        show: false,
        message: '',
        color: 'success', // success | error | info | warning
        timeout: 3000
    }),
    actions: {
        notify(message, color = 'success', timeout = 3000) {
            this.message = message
            this.color = color
            this.timeout = timeout
            this.show = true
        },
        close() {
            this.show = false
        }
    }
})
