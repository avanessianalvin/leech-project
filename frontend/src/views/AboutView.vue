<template>
  <info-component/>
  <v-container>
  <v-row>
    <v-col cols="2" md="4">
      <gateway-component />
    </v-col>
    <v-col cols="2" md="8">
    <technologies-component/>
    </v-col>
  </v-row>
  </v-container>

  <footer-component/>

</template>

<script>
import InfoComponent from "@/components/info/InfoComponent";
import FooterComponent from "@/components/info/FooterComponent";
import TechnologiesComponent from "@/components/info/TechnologiesComponent";
import GatewayComponent from "@/components/info/GatewayComponent";
export default {
  name: "AboutView",
  components: {GatewayComponent, TechnologiesComponent, FooterComponent, InfoComponent}
}
</script>

<style scoped>

</style>