<template>
  <v-container class="my-12">
    <v-card color="blue-lighten-4" class="pa-6 rounded-xl elevation-3">
      <v-card-title class="text-h5 font-weight-bold mb-4">
        🔧 Technologies Used
      </v-card-title>

      <v-row>
        <!-- Backend -->
        <v-col cols="12" md="6">
          <v-sheet class="pa-4 rounded-lg bg-grey-lighten-4">
            <div class="d-flex align-center mb-2">
              <v-icon class="mr-2" color="primary">mdi-server</v-icon>
              <span class="font-weight-bold">Backend</span>
            </div>
            <div class="text-body-2">
              Java • Spring Boot • Hibernate • Lombok • JWT • PostgreSQL
            </div>
          </v-sheet>
        </v-col>

        <!-- Frontend -->
        <v-col cols="12" md="6">
          <v-sheet class="pa-4 rounded-lg bg-grey-lighten-4">
            <div class="d-flex align-center mb-2">
              <v-icon class="mr-2" color="deep-purple">mdi-monitor</v-icon>
              <span class="font-weight-bold">Frontend</span>
            </div>
            <div class="text-body-2">
              Vue • Vuetify
            </div>
          </v-sheet>
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>
<script>
export default {
  name: "TechnologiesComponent"
}
</script>

<style scoped>

</style>