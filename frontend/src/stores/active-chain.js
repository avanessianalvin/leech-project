import { defineStore } from 'pinia'
import apiClient from "@/assets/plugins/apiClient";
import {useNotificationStore} from "@/stores/notification";


export const useActiveChainStore = defineStore('activeChain', {
    state: () => ({
        activeChainList: [],
        activeChainActiveList: [],
        activeChainConfirmedList: [],

    }),

    getters: {
        activeChainListSorted: (state) => {
            return [...state.activeChainList].sort((a, b) => a.id - b.id);
        },

        activeChainActiveListSorted: (state) => {
            return [...state.activeChainActiveList].sort((a, b) => a.id - b.id);
        },
        activeChainConfirmedListSorted: (state) => {
            return [...state.activeChainConfirmedList].sort((a, b) => a.id - b.id);
        }
    },

    actions: {
        getAll() {
            return apiClient.get("/chain/active/getAll")
                .then(r => {
                    this.activeChainList = r.data;
                    return r.data;
                })
                .catch(e => {
                    console.error("Failed to fetch active chains:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        },
        getAllActive(){
            return apiClient.get("/chain/active/getAllActive")
                .then(r => {
                    this.activeChainActiveList = r.data;
                    return r.data;
                })
                .catch(e => {
                    console.error("Failed to fetch active chains:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        },
        getConfirmed(limit){
            return apiClient.get("/chain/active/getConfirmed?limit="+limit)
                .then(r => {
                    this.activeChainConfirmedList = r.data;
                    return r.data;
                })
                .catch(e => {
                    console.error("Failed to fetch active chains:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        },
        reset(){
          this.getAllActive()
          this.getConfirmed(20)
        },

        remove(o) {
            return apiClient.post('/chain/active/remove',o)
                .then(() => {
                    this.reset()
                })
                .catch(e => {
                    console.error("Failed to delete chain:", e);
                    useNotificationStore().notify(e.message,'error')
                });
        }
    }
});
