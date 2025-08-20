import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'


// Vuetify imports
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'



// Import Material Design Icons
import { aliases, mdi } from 'vuetify/iconsets/mdi'

// Import the actual CSS for mdi icons
import '@mdi/font/css/materialdesignicons.css'

const vuetify = createVuetify({
    components,
    directives,
    icons: {
        defaultSet: 'mdi',
        aliases,
        sets: {
            mdi,
        },
    },
})

const app = createApp(App)
app.use(router)   // <-- register router
app.use(createPinia())
app.use(vuetify)
app.mount('#app')
