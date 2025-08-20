<template>
Elelemts
  <v-btn @click="getAll">getAll</v-btn>
</template>

<script>
import {useElementStore} from "@/stores/elements";

export default {
  name: "ElementView",
  data(){
    return{
      elementStore:useElementStore()
    }
  },

  methods:{
    getAll(){
      this.elementStore.getAll();
    }
  }
}
</script>

<style scoped>

</style>