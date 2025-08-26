<template>
  <v-menu offset-y>
    <template #activator="{ props }">
      <v-btn icon v-bind="props">
        <v-avatar size="32">
          <v-icon>mdi-account</v-icon>
        </v-avatar>
      </v-btn>
    </template>

    <v-list>
      <v-list-item @click="goProfile">
        <v-list-item-title>Profile</v-list-item-title>
      </v-list-item>
      <v-list-item @click="logout">
        <v-list-item-title>Logout</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-menu>
</template>

<script>
import {useAuthStore} from "@/stores/auth";

export default {

  methods: {
    logout() {
      useAuthStore().logout()
    },
    goProfile() {
      this.$router.push('/profile')
    }
  }
}
</script>
