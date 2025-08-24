<template>

  <div class="custom-chip">
    <span class="chip-text">{{ element.code }}</span>
    <v-btn v-if="removeButton" icon class="remove-btn" @click="$emit('remove',element)">
      <v-icon>mdi-close</v-icon>
    </v-btn>
    <v-tooltip activator="parent" location="top">
      {{element.code}}
      <v-card class="pa-2" outlined>
        <div v-for="(value, key) in element" :key="key" class="d-flex">
          <strong>{{ key }}:</strong>
          <span class="ml-1">{{ value }}</span>
        </div>
      </v-card>
    </v-tooltip>
  </div>

</template>

<script>
export default {
  name: "ElementElement",
  props: {
    element: {
      type: Object,
      required: true,
    },
    removeButton: {
      type: Boolean,
      default: true
    },
    showTooltip: {
      type: Boolean,
      default: true
    }
  },
};
</script>

<style scoped>
.custom-chip {
  display: inline-flex;
  align-items: center;
  padding: 6px; /* bigger than default chip */
  border-radius: 4px; /* less rounded than v-chip */
  border: 1px black solid;
  background-color: #e0e0e0;
  font-size: 16px;
  margin: 4px;
}

.chip-text {
  margin-right: 6px;
}

.remove-btn {
  font-weight: bolder;
  font-size: 12px;
  max-width: 24px;
  max-height: 24px;
  line-height: 0;
}
</style>
