<template>
  <v-snackbar
      v-model="notification.show"
      :color="notification.color"
      :timeout="notification.timeout"
      location="bottom right"
  >
    {{ notification.message }}
    <template #actions>
      <v-btn icon @click="notification.close()">
        <v-icon>mdi-close</v-icon>
      </v-btn>
    </template>
  </v-snackbar>
</template>

<script setup>
import { useNotificationStore } from '@/stores/notification'

const notification = useNotificationStore()
</script>
