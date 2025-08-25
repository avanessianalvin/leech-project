<template>
  <v-row>
    <!-- Info Component -->
    <v-col
        cols="12"
        :md="!authStore.isLoggedin ? 4 : 6"
    >
      <info-component/>
    </v-col>

    <!-- Log In (only if not logged in) -->
    <v-col
        cols="12"
        md="4"
        v-if="!authStore.isLoggedin"
    >
      <log-in/>
    </v-col>

    <!-- Image -->
    <v-col
        cols="12"
        :md="!authStore.isLoggedin ? 4 : 6"
    >
      <v-container>
        <v-img :src="require('@/assets/img/dashboard-sample.png')"/>
      </v-container>
    </v-col>
  </v-row>

  <technologies-component/>
  <footer-component/>
</template>

<script>
import LogIn from "@/components/LogIn.vue";
import {useAuthStore} from "@/stores/auth";
import InfoComponent from "@/components/info/InfoComponent";
import FooterComponent from "@/components/info/FooterComponent";
import TechnologiesComponent from "@/components/info/TechnologiesComponent";


export default {
  name: "HomeView",
  components: {TechnologiesComponent, FooterComponent, InfoComponent, LogIn},
  data() {
    return {
      authStore: useAuthStore()
    }
  },
  mounted() {
    this.authStore.checkLogin()
  }
}
</script>

<style scoped>

</style>