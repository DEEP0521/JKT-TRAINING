<template>
  <div class="adminview">
    <AdminBill />
  </div>
</template>

<script>
// @ is an alias to /src
import AdminBill from "@/components/BillsView.vue";

export default {
  name: "AdminBill",
  components: {
    AdminBill
  }
};
</script>
