import {defineStore} from 'pinia'
import apiClient from "@/assets/plugins/apiClient";

export const useFeedStore = defineStore('feed', {
        state: () => ({

        }),
        getters: {
        },
        actions: {
            sendFeed(m){
                return apiClient.post("/message/feed",m)
            }

        }
    }
)