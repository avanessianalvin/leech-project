<template>
  <element-element v-for="item in elementList" :key="item" :element="item" :remove-button="removeButton" @remove="forwardEvent"/>
</template>

<script>
import ElementElement from "@/components/element/ElementElement";
export default {
  name: "ChainElement",
  components: {ElementElement},
  props:['elementList','removeButton'],
  methods:{
    forwardEvent(element){
      this.$emit('remove',element)
    }
  }

}
</script>

<style scoped>

</style>