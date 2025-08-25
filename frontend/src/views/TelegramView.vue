<template>
Telegram
  <telegram-table/>
  <telegram-help class="mt-12"/>

</template>

<script>
import TelegramTable from "@/components/telegram/TelegramTable";
import TelegramHelp from "@/components/telegram/TelegramHelp";
export default {
  name: "TelegramView",
  components: {TelegramHelp, TelegramTable}
}
</script>

<style scoped>

</style>