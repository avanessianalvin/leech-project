<template>
  <v-container fluid class="fill-height bg-container">
    <div class="content">
      <v-row>
        <v-col cols="12" md="8">
          <info-component/>
        </v-col>

        <v-col cols="12" md="4" v-if="!authStore.isLoggedin">
          <log-in @toggleLogin="showLogin=!showLogin" v-if="showLogin"/>
          <sign-up-form  @toggleLogin="showLogin=!showLogin"  v-else/>
        </v-col>
      </v-row>

      <v-row align="baseline">
        <v-col cols="12" md="4">
          <gateway-component/>
        </v-col>
        <v-col cols="12" md="8">
          <technologies-component/>
        </v-col>
      </v-row>
      </div>

  </v-container>
  <footer-component/>


</template>

<script>
import LogIn from "@/components/LogIn.vue";
import {useAuthStore} from "@/stores/auth";
import InfoComponent from "@/components/info/InfoComponent";
import FooterComponent from "@/components/info/FooterComponent";
import TechnologiesComponent from "@/components/info/TechnologiesComponent";
import GatewayComponent from "@/components/info/GatewayComponent";
import SignUpForm from "@/components/SignUp";


export default {
  name: "HomeView",
  components: {SignUpForm, GatewayComponent, TechnologiesComponent, FooterComponent, InfoComponent, LogIn},
  data() {
    return {
      authStore: useAuthStore(),
      showLogin:true
    }
  },
  mounted() {
    this.authStore.checkLogin()
  }
}
</script>

<style scoped>
.bg-container::before {
  content: "";
  position: absolute;
  inset: 0; /* top:0; right:0; bottom:0; left:0 */
  background: url('@/assets/img/dashboard-sample.png') center/cover no-repeat;
  filter: blur(2px);
  opacity: .6;
  z-index: 0; /* behind content */
}

.content {
  position: relative;
  z-index: 1;
  color: white;
}
</style>