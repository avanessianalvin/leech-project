<template>
  <v-container max-width="500">
    <v-card class="pa-6 pa-6 rounded-xl elevation-3" min-width="400" elevation="8" color="blue-lighten-4" >
      <v-card-title class="text-h6 text-center">Login</v-card-title>

      <v-card-text>
        <v-form v-model="valid" ref="form">
          <v-text-field
              v-model="username"
              label="Username"
              prepend-inner-icon="mdi-account"
              :rules="[rules.required]"
              outlined
              dense
          />
          <v-text-field
              v-model="password"
              label="Password"
              type="password"
              prepend-inner-icon="mdi-lock"
              :rules="[rules.required]"
              outlined
              dense
              @keyup.enter="onLogin"
          />
        </v-form>
      </v-card-text>

      <v-card-actions class="d-flex flex-column">
        <v-btn
            variant="outlined"
            color="primary"
            class="w-100"
            :disabled="!valid"
            @click="onLogin"
        >
          Login
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
import {useAuthStore} from "@/stores/auth";
export default {
  name: "LoginForm",
  data() {
    return {
      username: "",
      password: "",
      valid: false,
      rules: {
        required: (value) => !!value || "Required.",
      },
      authStore:useAuthStore()
    };
  },
  methods: {
    onLogin() {
      if (this.$refs.form.validate()) {
        const credentials = {username:this.username,
        password:this.password}
        this.authStore.login(credentials)
      }
    },
  },
};
</script>
