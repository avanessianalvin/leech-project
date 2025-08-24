<template>
  <element-table/>
</template>

<script>
import {useElementStore} from "@/stores/elements";
import ElementTable from "@/components/element/ElementTable";

export default {
  name: "ElementView",
  components: {ElementTable},
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