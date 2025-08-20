// src/plugins/axios.js or src/axios.js
import axios from 'axios'
import router from '@/router';

const apiClient = axios.create({
    baseURL: '/api', // automatically prepends /api to all requests
    headers: {
        'Content-Type': 'application/json',
    },
})

apiClient.interceptors.request.use(config => {
    const token = localStorage.getItem('leechtoken') // or from Pinia store
    if (token) {
        config.headers.Authorization = `Bearer ${token}`
    }
    return config
})
apiClient.interceptors.response.use(
    response => response,
    error => {
        if (error.response && error.response.status === 403) {
            localStorage.removeItem('token'); // clear invalid token
            router.push('/');            // redirect to home
        }
        return Promise.reject(error);
    }
);

export default apiClient
