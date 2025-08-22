import { defineStore } from 'pinia'
import apiClient from "@/assets/plugins/apiClient";

export const useElementStore = defineStore('element', {
    state: () => ({
        elementList: []
    }),

    getters: {
        elementListSorted: (state) => {
            return [...state.elementList].sort((a, b) => a.id - b.id);
        }
    },

    actions: {
        getAll() {
            return apiClient.get("/element/getAll")
                .then(r => {
                    this.elementList = r.data;
                    return r.data;
                })
                .catch(e => {
                    console.error("Failed to fetch elements:", e);
                    throw e;
                });
        },

        save(o) {
            return apiClient.post("/element/save", o)
                .then(r => {
                    const saved = r.data;
                    // Replace existing if same id, otherwise push
                    const idx = this.elementList.findIndex(el => el.id === saved.id);
                    if (idx > -1) {
                        this.elementList.splice(idx, 1, saved);
                    } else {
                        this.elementList.push(saved);
                    }
                    return saved;
                })
                .catch(e => {
                    console.error("Failed to save element:", e);
                    throw e;
                });
        },

        remove(o) {
            return apiClient.post('/element/remove',o)
                .then(() => {
                    this.elementList = this.elementList.filter(el => el.id !== o.id);
                })
                .catch(e => {
                    console.error("Failed to delete element:", e);
                    throw e;
                });
        }
    }
});
