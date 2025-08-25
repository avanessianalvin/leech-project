<template>
  <v-sheet border rounded>
    <v-data-table
        :headers="headers"
        :header-props="{style: {fontWeight:600}}"
        :hide-default-footer="telegramStore.telegramListSorted.length < 11"
        :items="telegramStore.telegramListSorted"
        density="compact"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>
            <v-icon color="medium-emphasis" icon="code-block-brackets" size="x-small" start></v-icon>

            Telegram
          </v-toolbar-title>

          <v-btn
              class="me-2"
              prepend-icon="mdi-plus"
              rounded="lg"
              text="Add a Telegram"
              border
              @click="add"
          ></v-btn>
          <v-btn
              class="me-2"
              prepend-icon="mdi-refresh"
              rounded="lg"
              text="Refrsh"
              border
              @click="reset"
          ></v-btn>
        </v-toolbar>
      </template>

      <template v-slot:[`item.enabled`]="{ item }">
        <v-checkbox :model-value="item.enabled" @click="toggleEnabled(item)"/>
      </template>

      <template v-slot:[`item.actions`]="{ item }">
        <div class="d-flex ga-2 justify-end">
          <v-icon color="medium-emphasis" icon="mdi-pencil" size="small" @click="edit(item)"></v-icon>

          <v-icon color="medium-emphasis" icon="mdi-delete" size="small" @click="remove(item)"></v-icon>
        </div>
      </template>

      <template v-slot:no-data>
        <v-btn
            prepend-icon="mdi-backup-restore"
            rounded="lg"
            text="Reset data"
            variant="text"
            border
            @click="reset"
        ></v-btn>
      </template>
    </v-data-table>
  </v-sheet>

  <v-dialog v-model="dialog" max-width="500">
    <v-card
        :title="`${isEditing ? 'Edit' : 'Add'} a Telegram`"
    >
      <template v-slot:text>
        <v-row>

          <v-col cols="12" md="6">
            <v-text-field v-model="formModel.title" label="Title" maxlength="16"></v-text-field>
          </v-col>

          <v-col cols="12" md="6">
            <v-checkbox v-model="formModel.enabled" label="Enabled"></v-checkbox>
          </v-col>

          <v-col cols="12" md="12">
            <v-text-field v-model="formModel.token" label="Token ex:8121406254:AAFA1SsOpagmZCdzInAzUz7iZFl8bDYN1kg" maxlength="64"></v-text-field>
          </v-col>

          <v-col cols="12" md="12">
            <v-text-field v-model="formModel.chatId" label="Chat id ex:-1002957982628" maxlength="20"></v-text-field>
          </v-col>

          <v-col cols="12" md="12">
            <v-text-field v-model="formModel.tags" label="Tags separated with',' or ';'" maxlength="64"></v-text-field>
          </v-col>


        </v-row>
      </template>

      <v-divider></v-divider>

      <v-card-actions class="bg-surface-light">
        <v-btn text="Cancel" variant="plain" @click="dialog = false"></v-btn>

        <v-spacer></v-spacer>

        <v-btn text="Save" @click="save"></v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import {useTelegramStore} from "@/stores/telegram";

export default {
  name: "TelegramTable",
  data() {
    return {
      currentYear: new Date().getFullYear(),
      formModel: this.createNewRecord(),
      dialog: false,
      headers: [
        {title: 'ID', key: 'id', align: 'start'},
        {title: 'Title', key: 'title', align: 'start'},
        {title: 'Token', key: 'token', align: 'start'},
        {title: 'Chat id', key: 'chatId', align: 'start', sortable: false},
        {title: 'Tags', key: 'tags', align: 'start', sortable: false},
        {title: 'Enabled', key: 'enabled', align: 'start'},
        {title: 'Actions', key: 'actions', align: 'end', sortable: false},
      ],
      telegramStore: useTelegramStore()
    }
  },
  methods: {
    createNewRecord() {
      return {}
    },

    add() {
      this.formModel = this.createNewRecord()
      this.dialog = true
    },

    edit(item) {
      this.formModel = {...item}
      this.dialog = true
    },

    remove(item) {
      if (confirm("Are ou sure to remove?")) {
        this.telegramStore.remove(item)
      }
    },

    save() {
      this.telegramStore.save(this.formModel)
      this.dialog = false
    },

    reset() {
      this.dialog = false
      this.formModel = this.createNewRecord()
      this.telegramStore.getAll()
    },

    toggleEnabled(o){
      o.enabled = !o.enabled
      this.telegramStore.save(o).then(()=> this.telegramStore.getAll())
    }
  },
  beforeMount() {
    this.reset()
  }
}
</script>

<style scoped>

</style>