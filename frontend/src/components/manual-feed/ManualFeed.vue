<template>
  <v-card max-width="800" color="grey-lighten-2">
    <v-card-title>Manual Feed
      <v-btn color="grey-darken-2" @click="showManualFeed = !showManualFeed">--</v-btn>
    </v-card-title>
    <v-row v-show="showManualFeed">
      <v-col class="ma-4">
            Manual feed is for checking chains flow and telegram messages.
      </v-col>
      <v-col class="ma-4">
        <v-card-text>
          <v-row>
            <v-col cols="12" md="6">
              <v-select label="Select to feed" :items="elementStore.elementListSortedCode" v-model="feed.code"/>
            </v-col>
            <v-col cols="12" md="6">
              <v-combobox label="Select Symbol" :items="symbolList" v-model="feed.symbol"/>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12" md="6">
              <v-text-field label="sender" v-model="feed.sender" maxlength="16"/>
            </v-col>
            <v-col cols="12" md="6">
              <v-text-field label="info" v-model="feed.info" maxlength="32"/>
            </v-col>
          </v-row>

        </v-card-text>
        <v-card-actions>
          <v-btn @click="randomFeed" variant="outlined">random</v-btn>
          <v-btn @click="sendFeed" variant="outlined">send</v-btn>
        </v-card-actions>
      </v-col>
    </v-row>
  </v-card>

</template>

<script>
import {useElementStore} from "@/stores/elements";
import {useFeedStore} from "@/stores/feed";
import {useActiveChainStore} from "@/stores/active-chain";

export default {
  name: "ManualFeed",
  data() {
    return {
      showManualFeed: false,
      feed: {
        code: null,
        symbol: "EURUSD",
        sender: '',
        sendDate: 0,
        info: ''
      },
      elementStore: useElementStore(),
      symbolList: ['EURUSD', 'USDJPY', 'XAUUSD', 'US30', 'US100']
    }
  },
  methods: {
    sendFeed() {
      this.feed.sentDate = Date.now()
      useFeedStore().sendFeed(this.feed).then(() =>
          useActiveChainStore().reset())
    },

    randomFrom(array) {
      return array[Math.floor(Math.random() * array.length)];
    },

    randomFeed() {
      const codes = this.elementStore.elementListSorted.map(e => e.code);
      const senderNum = Math.floor(Math.random() * 100) + 1;   // sender1..sender100
      const infoNum = Math.floor(Math.random() * 10000);       // info-xxxx

      this.feed = {
        code: this.randomFrom(codes),
        symbol: this.randomFrom(this.symbolList),
        sender: `sender${senderNum}`,
        info: `info-${infoNum}`
      };
    },
  },
  mounted() {
    this.elementStore.getAll()
  }
}
</script>

<style scoped>

</style>