<template>
  <v-card max-width="500" color="blue-lighten-4" class="pa-6 rounded-xl elevation-3">
    <v-card-title class="text-h5 font-weight-bold mb-4">
      🔌 Gateway
  </v-card-title>
  <v-card-text>
    <pre>
POST {ip:port}/api/message/feed
  {
    sentDate:long (GMT milliseconds)
    symbol:String 16 (case sensitive)
    code:String 8 (case sensitive)
    sender:String 16
    info:String 32
  }
// no need to authorize
      </pre>
  </v-card-text>
</v-card>
</template>

<script>
export default {
  name: "GatewayComponent"
}
</script>

<style scoped>

</style>