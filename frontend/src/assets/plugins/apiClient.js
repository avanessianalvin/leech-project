// src/plugins/axios.js or src/axios.js
import axios from 'axios'

const apiClient = axios.create({
    baseURL: '/api', // automatically prepends /api to all requests
    headers: {
        'Content-Type': 'application/json',
    },
})

export default apiClient
