<template>
  <div class="departmentBill">
    <RecordsByDepart />
  </div>
</template>

<script>
// @ is an alias to /src
import RecordsByDepart from "@/components/RecordsByDepart.vue";

export default {
  name: "DepartmentLog",
  components: {
    RecordsByDepart
  }
};
</script>
