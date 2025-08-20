<template>
  <v-app-bar color="primary" dark>
    <v-app-bar-nav-icon @click="$emit('toggleDrawer')"></v-app-bar-nav-icon>
    <v-toolbar-title>My App</v-toolbar-title>
    <v-spacer></v-spacer>

    <NotificationMenu />
    <ProfileMenu />
  </v-app-bar>
</template>

<script>
import ProfileMenu from './ProfileMenu.vue'
import NotificationMenu from './NotificationMenu.vue'

export default {
  components: { ProfileMenu, NotificationMenu },

}
</script>
