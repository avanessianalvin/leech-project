<template>
  <v-app-bar color="primary" dark>
    <v-app-bar-nav-icon @click="$emit('toggleDrawer')" v-if="authStore.isLoggedin"></v-app-bar-nav-icon>
    <v-toolbar-title>Leech Feed Chain</v-toolbar-title>
    <v-spacer></v-spacer>
    <ProfileMenu  v-if="authStore.isLoggedin"/>
  </v-app-bar>
</template>

<script>
import ProfileMenu from './ProfileMenu.vue'
import {useAuthStore} from "@/stores/auth";

export default {
  components: { ProfileMenu },
  data(){
    return{
      authStore:useAuthStore()
    }
  }

}
</script>
