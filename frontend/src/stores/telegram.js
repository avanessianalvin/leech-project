import { defineStore } from 'pinia'
import apiClient from "@/assets/plugins/apiClient";
import {useNotificationStore} from "@/stores/notification";


export const useTelegramStore = defineStore('telegram', {
    state: () => ({
        telegramList: []
    }),

    getters: {
        telegramListSorted: (state) => {
            return [...state.telegramList].sort((a, b) => a.id - b.id);
        }
    },

    actions: {
        getAll() {
            return apiClient.get("/telegram/getAll")
                .then(r => {
                    this.telegramList = r.data;
                    return r.data;
                })
                .catch(e => {
                    console.error("Failed to fetch telegrams:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        },

        save(o) {
            return apiClient.post("/telegram/save", o)
                .then(r => {
                    const saved = r.data;
                    // Replace existing if same id, otherwise push
                    const idx = this.telegramList.findIndex(el => el.id === saved.id);
                    if (idx > -1) {
                        this.telegramList.splice(idx, 1, saved);
                    }else {
                        this.telegramList.push(saved)
                    }
                    return saved;
                })
                .catch(e => {
                    console.error("Failed to save telegram:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        },

        remove(o) {
            return apiClient.post('/telegram/remove',o)
                .then(() => {
                    this.telegramList = this.telegramList.filter(el => el.id !== o.id);
                })
                .catch(e => {
                    console.error("Failed to delete telegram:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        }
    }
});
