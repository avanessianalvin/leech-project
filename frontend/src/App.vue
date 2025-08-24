<template>
  <v-app>
    <top-bar @toggleDrawer="this.$refs.leftMenu.toggle()"/>
    <left-menu ref="leftMenu"/>

    <v-main>
      <v-container fluid>
        <router-view></router-view>
      </v-container>
      <notification-snack/>
    </v-main>
  </v-app>
</template>

<script>
import TopBar from "@/components/TopBar";
import LeftMenu from "@/components/LeftMenu";
import NotificationSnack from "@/components/NotificationSnack.vue";

export default {
  components: {NotificationSnack, LeftMenu, TopBar},

}
</script>


<style>

</style>
