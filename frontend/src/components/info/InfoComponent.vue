<template>
  <v-container>
    <v-card color="blue-lighten-4" class="pa-6 rounded-xl elevation-3">
      <v-card-title class="text-h5 font-weight-bold mb-4">
        Leech Feed Chain
      </v-card-title>
      <v-card-subtitle>
        Event-Chain Manager and Messaging
      </v-card-subtitle>

      <v-card-text>
        <p class="ma-3">
          This system automates event chains by processing signals from various indicators, checking their order, and
          sending summarized alerts to Telegram channels, helping users make informed stock market decisions. It enables
          real-time monitoring, detects complex conditions, and executes rule-based triggers without manual effort.
        </p>
      </v-card-text>
      <v-btn variant="plain" @click="show=!show">{{ !show ? 'more' : 'less' }}...</v-btn>

      <v-card-text v-if="show">
        <p class="ma-3">
          This system allows you to build custom event chains using flexible elements. You define the elements, link
          them together into chains, and then feed data into the system. Each chain continuously evaluates the incoming
          feed, automating the process of checking whether all elements are triggered in the correct order.</p>
        <p class="ma-3">
          Once a chain is fully satisfied, the system instantly sends a notification to some Telegram channels or groups
          via tags in chains, further enhancing automation of alerts.</p>
        <p class="ma-3">
          This system was primarily designed to collect signals from various indicators, check them in chains, and send
          a summarized signal to the user, helping them decide on actions in the stock market.</p>
        <p class="ma-3">
          This gives you a powerful way to automate monitoring, detect complex conditions, and get real-time alerts
          without manual checks. Whether you want to track workflows, monitor data streams, or create rule-based
          triggers, our platform makes it easy to design, connect, and act.</p>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "InfoComponent",
  data() {
    return {
      show: false
    }
  }
}
</script>

<style scoped>

</style>