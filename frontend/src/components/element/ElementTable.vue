<template>
  <v-sheet border rounded max-width="600">
    <v-data-table
        :headers="headers"
        :header-props="{style: {fontWeight:600}}"
        :hide-default-footer="elementStore.elementList.length < 11"
        :items="elementStore.elementList"
        density="compact"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>
            <v-icon color="medium-emphasis" icon="code-block-brackets" size="x-small" start></v-icon>

            Elements
          </v-toolbar-title>

          <v-btn
              class="me-2"
              prepend-icon="mdi-plus"
              rounded="lg"
              text="Add an element"
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

      <template v-slot:[`item.code`]="{ item }">
        <element-element :element="item" :remove-button="false" :show-tooltip="false"/>
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
        :title="`${isEditing ? 'Edit' : 'Add'} an Element`"
    >
      <template v-slot:text>
        <v-row>

          <v-col cols="12" md="6">
            <v-text-field v-model="formModel.code" label="Code" maxlength="8"></v-text-field>
          </v-col>

          <v-col cols="12" md="6">
            <v-text-field v-model="formModel.title" label="Title" maxlength="32"></v-text-field>
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
import {useElementStore} from "@/stores/elements";
import ElementElement from "@/components/element/ElementElement";
export default {
  name: "ElementTable",
  components: {ElementElement},
  data() {
    return {
      currentYear: new Date().getFullYear(),
      formModel: this.createNewRecord(),
      dialog: false,
      headers: [
        { title: 'ID', key: 'id', align: 'start'},
        { title: 'Code', key: 'code', align: 'start'},
        { title: 'Title', key: 'title', align: 'start' },
        { title: 'Actions', key: 'actions', align: 'end', sortable: false },
      ],
      elementStore:useElementStore()
    }
  },

  computed: {
    isEditing() {
      return !!this.formModel.id
    }
  },

  mounted() {
    this.reset()
  },

  methods: {
    createNewRecord() {
      return {
        title: '',
        author: '',
        genre: '',
        year: this.currentYear,
        pages: 1,
      }
    },

    add() {
      this.formModel = this.createNewRecord()
      this.dialog = true
    },

    edit(item) {
      this.formModel = { ...item }
      this.dialog = true
    },

    remove(item) {
      if (confirm("Are ou sure to remove?")) {
        this.elementStore.remove(item)
      }
    },

    save() {
      this.elementStore.save(this.formModel)
      this.dialog = false
    },

    reset() {
      this.dialog = false
      this.formModel = this.createNewRecord()
      this.elementStore.getAll()
    }
  }
}
</script>


<style scoped>
.v-data-table thead th{
  font-weight: bold !important;
}


</style>