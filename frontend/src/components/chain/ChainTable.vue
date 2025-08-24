<template>
  <v-sheet border rounded>
    <v-data-table
        :headers="headers"
        :header-props="{style: {fontWeight:600}}"
        :hide-default-footer="chainStore.chainList.length < 11"
        :items="chainStore.chainListSorted"
        density="compact"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>
            <v-icon color="medium-emphasis" icon="code-block-brackets" size="x-small" start></v-icon>

            Chains
          </v-toolbar-title>

          <v-btn
              class="me-2"
              prepend-icon="mdi-plus"
              rounded="lg"
              text="Add an chain"
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

      <template v-slot:[`item.chain`]="{ item }">
        <chain-element :element-list="item.elementList" :remove-button="false"/>
      </template>

      <template v-slot:[`item.enabled`]="{ item }">
        <v-checkbox  :model-value="item.enabled" @change="toggleEnabled(item)"/>
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
        :title="`${isEditing ? 'Edit' : 'Add'} an Chain`"
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
            <v-text-field v-model="formModel.symbols" label="Symbols separate with ','"></v-text-field>
          </v-col>

          <v-col cols="12" md="12">
            <v-text-field v-model="formModel.description" label="Description" maxlength="32"></v-text-field>
          </v-col>

          <v-col cols="12" md="6">
            <v-combobox label="Select to add"  :items="elementStore.elementListSorted" item-title="code" item-value="item" v-model="elementToAdd"/>
          </v-col>

          <v-col cols="12" md="6">
            <v-btn color="blue" @click="addElement">Add</v-btn>
          </v-col>

          <v-col cols="12" md="12">
            <chain-element :element-list="formModel.elementList" @remove="removeElement"/>
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
import {useChainStore} from "@/stores/chains";
import ChainElement from "@/components/chain/ChainElement";
import {useElementStore} from "@/stores/elements";

export default {
  name: "ChainTable",
  components: {ChainElement},
  data() {
    return {
      currentYear: new Date().getFullYear(),
      formModel: this.createNewRecord(),
      elementToAdd:null,
      dialog: false,
      headers: [
        {title: 'ID', key: 'id', align: 'start'},
        {title: 'Title', key: 'title', align: 'start'},
        {title: 'Symbols', key: 'symbols', align: 'start'},
        {title: 'Chain', key: 'chain', align: 'start', sortable: false},
        {title: 'Description', key: 'description', align: 'start', sortable: false},
        {title: 'Enabled', key: 'enabled', align: 'start'},
        {title: 'Actions', key: 'actions', align: 'end', sortable: false},
      ],
      chainStore: useChainStore(),
      elementStore: useElementStore()
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
        elementList:[]
      }
    },

    add() {
      this.formModel = this.createNewRecord()
      this.dialog = true
    },

    edit(item) {
      this.formModel = {...item}
      this.formModel.elementList = [...item.elementList]
      this.dialog = true
    },

    remove(item) {
      if (confirm("Are ou sure to remove?")) {
        this.chainStore.remove(item)
      }
    },

    save() {
      this.formModel.elementList=this.formModel.elementList.map(el => {
        if (el.id && el.id < 0) {
          delete el.id
          return el
        }
        return el
      })
      this.chainStore.save(this.formModel)
      this.dialog = false
    },

    reset() {
      this.dialog = false
      this.formModel = this.createNewRecord()
      this.chainStore.getAll()
      this.elementStore.getAll()
    },

    addElement(){
      let add = {... this.elementToAdd}
      add.id =  - new Date().getTime()
      this.formModel.elementList.push(add)
    },
    removeElement(element){
      this.formModel.elementList = this.formModel.elementList.filter(el => el.id !== element.id)
    },
    toggleEnabled(chain){
      chain.enabled = !chain.enabled
      this.chainStore.save(chain)
      this.chainStore.getAll()
    }

  }
}
</script>


<style scoped>
.v-data-table thead th {
  font-weight: bold !important;
}


</style>