<template>
  <info-component/>
  <technologies-component/>
  <footer-component/>
</template>

<script>
import InfoComponent from "@/components/info/InfoComponent";
import FooterComponent from "@/components/info/FooterComponent";
import TechnologiesComponent from "@/components/info/TechnologiesComponent";
export default {
  name: "AboutView",
  components: {TechnologiesComponent, FooterComponent, InfoComponent}
}
</script>

<style scoped>

</style>