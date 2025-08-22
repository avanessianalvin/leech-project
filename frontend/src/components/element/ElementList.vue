<template>
  <v-card class="mx-auto" style="max-width: 900px; overflow-x: auto;">
    <!-- Toolbar -->
    <v-card-title>
      <v-btn color="primary" @click="addRow">
        <v-icon>mdi-plus</v-icon>
      </v-btn>
      <v-btn color="primary" @click="refresh">
        <v-icon>mdi-refresh</v-icon>
      </v-btn>

    </v-card-title>

    <!-- Data Table -->
    <v-data-table
        :items="elementStore.elementListSorted"
        :headers="headers"
        item-key="id"
        class="elevation-1"
        hide-default-footer
    >
      <template #item="{ item }">
        <tr>
          <!-- ID -->
          <td>{{ item.id }}</td>

          <!-- Name -->
          <td>
            <v-text-field
                v-if="drafts[item.id]"
                v-model="drafts[item.id].name"
                dense
                hide-details
            />
            <span v-else>{{ item.name }}</span>
          </td>

          <!-- Opposite -->
          <td>
            <v-text-field
                v-if="drafts[item.id]"
                v-model="drafts[item.id].opposite"
                dense
                hide-details
            />
            <span v-else>{{ item.opposite }}</span>
          </td>

          <!-- Description -->
          <td>
            <v-text-field
                v-if="drafts[item.id]"
                v-model="drafts[item.id].description"
                dense
                hide-details
            />
            <span v-else>{{ item.description }}</span>
          </td>

          <!-- Actions -->
          <td>
            <!-- Edit / Save -->
            <v-btn icon small color="primary" @click="toggleEdit(item)">
              <v-icon v-if="!drafts[item.id]">mdi-pencil</v-icon>
              <v-icon v-else>mdi-content-save</v-icon>
            </v-btn>

            <!-- Cancel -->
            <v-btn
                v-if="drafts[item.id]"
                icon
                small
                color="grey"
                @click="cancelEdit(item)"
            >
              <v-icon>mdi-cancel</v-icon>
            </v-btn>

            <!-- Delete -->
            <v-btn icon small color="error" @click="removeRow(item)">
              <v-icon>mdi-delete</v-icon>
            </v-btn>
          </td>
        </tr>
      </template>
    </v-data-table>
  </v-card>
</template>

<script>
import { useElementStore } from "@/stores/elements";

export default {
  name: "EditableTable",
  data() {
    return {
      headers: [
        { text: "ID", value: "id" },
        { text: "Name", value: "name" },
        { text: "Opposite", value: "opposite" },
        { text: "Description", value: "description" },
        { text: "Actions", value: "actions", sortable: false },
      ],
      drafts: {}, // holds temporary edits
      elementStore: useElementStore(),
    };
  },
  methods: {
    async toggleEdit(item) {
      if (!this.drafts[item.id]) {
        // start editing → copy item into draft
        this.drafts[item.id] = { ...item };
      } else {
        // save changes
        try {
          const updated = await this.elementStore.save(this.drafts[item.id]);
          Object.assign(item, updated); // sync changes
        } catch (e) {
          console.error(e);
        }
        delete this.drafts[item.id]; // exit edit mode
      }
    },
    cancelEdit(item) {
      delete this.drafts[item.id]; // just remove draft → discard changes
    },
    async removeRow(item) {
      if(! confirm("Sure to remove " + item.name)) return
      try {
        await this.elementStore.remove(item);
      } catch (e) {
        console.error(e);
      }

    },

    async refresh() {
      try {
        await this.elementStore.getAll();
      } catch (e) {
        console.error(e);
      }
    },
    addRow() {
      const tempId = "new-" + Date.now();
      this.drafts[tempId] = {
        id: tempId,
        name: "",
        opposite: "",
        description: "",
      };
      this.elementStore.elementList.unshift(this.drafts[tempId]);
    },

  },

  async beforeMount() {
    await this.elementStore.getAll();
  },
};
</script>
