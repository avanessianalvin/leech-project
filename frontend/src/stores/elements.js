import {defineStore} from 'pinia'
import apiClient from "@/assets/plugins/apiClient";

export const useElementStore = defineStore('element', {
        state: () => ({
            elements:[]
        }),
        getters: {
            elements: (state) => state.elements
        },
        actions: {
            getAll(){
                apiClient.get("/element/getAll").then(r => this.elements =  r.data).catch(e=> console.log(e))
            }

        }
    }
)