<template>
  <!-- Now this connects automatically with v-model in parent -->
  <v-navigation-drawer v-model="modelValue" app temporary>
    <v-list nav>
      <v-list-item :to="{ name: 'home' }">
        <v-list-item-title>Home</v-list-item-title>
      </v-list-item>
      <v-list-item :to="{ name: 'dashboard' }">
        <v-list-item-title>Dashboard</v-list-item-title>
      </v-list-item>
      <v-list-item :to="{ name: 'element' }">
        <v-list-item-title>Element</v-list-item-title>
      </v-list-item>
      <v-list-item :to="{ name: 'chain' }">
        <v-list-item-title>Chain</v-list-item-title>
      </v-list-item>
      <v-list-item :to="{ name: 'telegram' }">
        <v-list-item-title>Telegram</v-list-item-title>
      </v-list-item>
      <v-list-item :to="{ name: 'about' }">
        <v-list-item-title>About</v-list-item-title>
      </v-list-item>
      <v-list-item :to="{ name: 'profile' }">
        <v-list-item-title>Profile</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  data(){
    return{
      modelValue:false
    }
  },
  methods:{
    toggle(){
      this.modelValue = !this.modelValue
    }
  }
}
</script>