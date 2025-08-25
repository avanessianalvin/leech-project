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
import {useAuthStore} from "@/stores/auth";

export default {
  components: {NotificationSnack, LeftMenu, TopBar},
  data(){
    return{
      TAB_COUNT_KEY:'leech_openTabs'
    }
  },
  methods: {
    incrementTabs() {
      const count = parseInt(localStorage.getItem(this.TAB_COUNT_KEY) || "0", 10);
      localStorage.setItem(this.TAB_COUNT_KEY, count + 1);
    },

    decrementTabs() {
      const count = parseInt(localStorage.getItem(this.TAB_COUNT_KEY) || "0", 10);
      const newCount = Math.max(count - 1, 0);
      localStorage.setItem(this.TAB_COUNT_KEY, newCount);

      if (newCount === 0) {
        // last tab closed
        const authStore = useAuthStore();
        //authStore.logout(true); // logout with sendBeacon
        console.log('this feature is blocked for development mode',authStore)

      }
    }
  },
  mounted() {
    this.incrementTabs();
    window.addEventListener("beforeunload", this.decrementTabs);
    useAuthStore().checkLogin()
  },
  unmounted() {
    window.removeEventListener("beforeunload", this.decrementTabs);
    this.decrementTabs(); // in case Vue itself unmounts App
  }

}
</script>


<style>
tbody tr:nth-of-type(odd) {
  /* 'teal lighten-5' basides on material design color */
  background-color: #dbe7e5;
}

tbody tr:nth-of-type(even) {
  /* 'deep-orange lighten-5' basides on material design color */
  background-color: #ffffff;
}
</style>
