<template>
  <element-list/>
</template>

<script>
import {useElementStore} from "@/stores/elements";
import ElementList from "@/components/element/ElementList.vue";

export default {
  name: "ElementView",
  components: {ElementList},
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