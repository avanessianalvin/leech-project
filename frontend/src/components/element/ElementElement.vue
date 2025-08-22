<template>
  <div class="custom-chip">
    <span class="chip-text">{{ text }}</span>
    <v-btn icon small class="remove-btn" @click="$emit('remove')" >
      <v-icon>mdi-close</v-icon>
    </v-btn>
  </div>
</template>

<script>
export default {
  name: "ElementElement",
  props: {
    text: {
      type: String,
      required: true,
    },
  },
};
</script>

<style scoped>
.custom-chip {
  display: inline-flex;
  align-items: center;
  padding: 6px; /* bigger than default chip */
  border-radius: 12px; /* less rounded than v-chip */
  background-color: #e0e0e0;
  font-size: 16px;
  margin: 4px;
}

.chip-text {
  margin-right: 6px;
}

.remove-btn {
  font-weight: bolder;
  font-size: 8px;
  min-width: 0;
  width: 20px;
  height: 20px;
  line-height: 0;
}
</style>
