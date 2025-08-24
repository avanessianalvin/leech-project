<template>
  <v-tooltip
      open-on-hover
      location="top"
  >
    <!-- Activator -->
    <template #activator="{ props }">
      <v-btn v-bind="props" color="primary">Hover me</v-btn>
    </template>

    <!-- Tooltip content -->
    <v-card style="max-width: 200px; padding: 8px;">
      <v-list dense>
        <v-list-item
            v-for="(prop, index) in properties"
            :key="index"
            class="hover:bg-grey-100 rounded"
        >
          <v-list-item-title>{{ prop.name }}: {{ prop.value }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-card>
  </v-tooltip>
</template>

<script>
export default {
  name: 'ToolTip',

  data() {
    return {
      properties: [
        { name: 'ID', value: 123 },
        { name: 'Name', value: 'Alice' },
        { name: 'Role', value: 'Admin' },
      ]
    }
  },
}
</script>

<style scoped>

</style>