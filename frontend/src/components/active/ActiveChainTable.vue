<template>
  <v-card>
    <v-card-title>{{title}}</v-card-title>
  <v-data-table :items="itemList"
                :headers="tableHeaders"
                :header-props="{style: {fontWeight:600}}"
                :items-per-page="itemsPerPage"
                :hide-default-footer="itemList.length<itemsPerPage"
                density="compact">

    <template v-slot:[`item.start`]="{ item }">
      {{moment(item.startTime).calendar()}}
    </template>

    <template v-slot:[`item.confirm`]="{ item }">
      {{item.confirmTime>0?moment(item.confirmTime).calendar():'--'}}
    </template>

    <template v-slot:[`item.chain`]="{ item }">
      <active-chain :active-chain="item"/>
    </template>

    <template v-slot:[`item.action`]="{ item }">
      <v-btn size="small" icon="mdi-delete" @click="remove(item)"></v-btn>
    </template>

  </v-data-table>
  </v-card>
</template>

<script>
import {useActiveChainStore} from "@/stores/active-chain";
import ActiveChain from "@/components/active/ActiveChain";
import moment from 'moment'

export default {
  name: "ActiveChainTable",
  components: {ActiveChain},
  props:['itemList','title','itemsPerPage'],
  data(){
    return{
      activeChainStore: useActiveChainStore(),
      moment:moment,
      tableHeaders:[
      {title: 'ID', key: 'id', align: 'start'},
      {title: 'Title', key: 'title', align: 'start'},
      {title: 'Symbol', key: 'symbol', align: 'start'},
      {title: 'Chain', key: 'chain', align: 'start', sortable: false},
      {title: 'Active', key: 'active', align: 'start', sortable: false},
      {title: 'Start', key: 'start', align: 'start'},
      {title: 'Confirm', key: 'confirm', align: 'start', sortable: false},
      {title: 'Action', key: 'action', align: 'end', sortable: false},
    ],

    }
  },
  methods:{
    remove(o){
      this.$emit("remove",o)
    }
  }


}
</script>

<style scoped>

</style>