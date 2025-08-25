<template>
  Dashboard
  <manual-feed/>
  <active-chain-table :item-list="activeChainStore.activeChainActiveListSorted" title="Active List" @remove="remove" @reset="reset"/>
  <active-chain-table :item-list="activeChainStore.activeChainConfirmedListSorted" title="Confirmed" @remove="remove" @reset="reset"/>
</template>


<script>
import {defineComponent} from 'vue'
import ActiveChainTable from "@/components/active/ActiveChainTable";
import ManualFeed from "@/components/manual-feed/ManualFeed";
import {useActiveChainStore} from "@/stores/active-chain";

export default defineComponent({
  name: "DashboardView",
  components: {ManualFeed, ActiveChainTable},
  data(){
    return{
      activeChainStore: useActiveChainStore()
    }
  },
  methods:{
    reset(){
      this.activeChainStore.getAll()
      this.activeChainStore.getAllActive()
      this.activeChainStore.getConfirmed(20)

    },
    remove(o){
      if (confirm("Are you sure to remove?"))
        this.activeChainStore.remove(o)
    }
  },
  mounted() {
    this.reset()
  }
})
</script>



<style scoped>

</style>