<template>
  <v-card variant="elevated" color="blue-lighten-4">
    <v-card-title>
      Steps to Implement Telegram Messaging
      <v-btn @click="show=!show">--</v-btn>
    </v-card-title>
    <v-card-text v-if="show">
      <v-list dense>
        <v-list-item>
            <v-list-item-title>
              1. Create a Telegram bot using <code>@BotFather</code>. After creation, you will receive a token—keep it safe.
            </v-list-item-title>
        </v-list-item>

        <v-list-item>
            <v-list-item-title>
              2. Create one or more Telegram channels and add the bot you created as an administrator.
            </v-list-item-title>
        </v-list-item>

        <v-list-item>
            <v-list-item-title>
              3. Send a message to the channel(s) to ensure the bot can access them.
            </v-list-item-title>
        </v-list-item>

        <v-list-item>
            <v-list-item-title>
              4. Open your browser and visit the following URL, replacing <code>&lt;token&gt;</code> with the token from step 1:
              <br>
              <code>https://api.telegram.org/bot&lt;token&gt;/getUpdates</code>
            </v-list-item-title>
        </v-list-item>

        <v-list-item>
            <v-list-item-title>
              5. Look through the response for a field like <code>"id": -1002957453423</code>. This is the chat ID for your channel.
            </v-list-item-title>
        </v-list-item>

        <v-list-item>
            <v-list-item-title>
              You can add multiple Telegram channels by repeating steps 2–5. There is no need to create more than one bot.
            </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-card-text>
  </v-card>

</template>

<script>
export default {
  name: "TelegramHelp",
  data(){
    return{
      show:false
    }
  }
}
</script>

<style scoped>

</style>