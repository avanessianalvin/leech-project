import { defineStore } from 'pinia'
import apiClient from "@/assets/plugins/apiClient";
import {useNotificationStore} from "@/stores/notification";


export const useChainStore = defineStore('chain', {
    state: () => ({
        chainList: []
    }),

    getters: {
        chainListSorted: (state) => {
            return [...state.chainList].sort((a, b) => a.id - b.id);
        }
    },

    actions: {
        getAll() {
            return apiClient.get("/chain/getAll")
                .then(r => {
                    this.chainList = r.data;
                    return r.data;
                })
                .catch(e => {
                    console.error("Failed to fetch chains:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        },

        save(o) {
            return apiClient.post("/chain/save", o)
                .then(r => {
                    const saved = r.data;
                    // Replace existing if same id, otherwise push
                    const idx = this.chainList.findIndex(el => el.id === saved.id);
                    if (idx > -1) {
                        this.chainList.splice(idx, 1, saved);
                    }else {
                        this.chainList.push(saved)
                    }
                    return saved;
                })
                .catch(e => {
                    console.error("Failed to save chain:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        },

        remove(o) {
            return apiClient.post('/chain/remove',o)
                .then(() => {
                    this.chainList = this.chainList.filter(el => el.id !== o.id);
                })
                .catch(e => {
                    console.error("Failed to delete chain:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        }
    }
});
