<template>
  <message-element v-for="o in activeChain.waitList" :key="o" :message-element="o"/>
</template>

<script>
import {useActiveChainStore} from "@/stores/active-chain";
import MessageElement from "@/components/active/MessageElement";

export default {
  name: "ActiveChain",
  components: {MessageElement},
  props:['activeChain'],
  methods:{
    remove(){
      useActiveChainStore().remove(this.activeChain)
    }
  }
}
</script>

<style scoped>

</style>