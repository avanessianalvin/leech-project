<template>
  <div class="custom-chip" :class="{ 'chip-active': messageElement.receivedDate>0}">
    <span class="chip-text">{{ messageElement.code }}</span>
    <v-tooltip activator="parent" location="top">
      {{messageElement.code}}
      <v-card class="pa-2" outlined>
        <div v-for="(value, key) in messageElement" :key="key" class="d-flex">
          <strong>{{ key }}:</strong>
          <span class="ml-1">{{ value }}</span>
        </div>
      </v-card>
    </v-tooltip>
  </div>
</template>

<script>
export default {
  name: "MessageElement",
  props:['messageElement']
}
</script>

<style scoped>
.custom-chip {
  display: inline-flex;
  align-items: center;
  padding: 2px; /* bigger than default chip */
  border-radius: 4px; /* less rounded than v-chip */
  border: 1px black solid;
  background-color: #e0e0e0;
  font-size: 16px;
  margin: 2px;
}

.chip-text {
  margin-right: 6px;
}

.chip-active{
  background-color: deepskyblue;
}
</style>