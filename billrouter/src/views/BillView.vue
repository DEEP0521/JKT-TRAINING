<template>
  <div class="fileUpload">
    <BillsView />
  </div>
</template>

<script>
// @ is an alias to /src
import BillsView from "@/components/BillsView.vue";

export default {
  name: "FileSubmit",
  components: {
    BillsView
  }
};
</script>
