<template>
  <chain-list/>

  <element-element text="i am an element"/>

p</template>

<script>
import ChainList from "@/components/ChainList.vue";
import ElementElement from "@/components/element/ElementElement.vue";

export default {
  name: "ChainView",
  components: {ElementElement, ChainList}
}
</script>

<style scoped>

</style>