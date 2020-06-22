<template>
  <div class="fileUpload">
    <EmployeeLog />
  </div>
</template>

<script>
// @ is an alias to /src
import EmployeeLog from "@/components/EmployeeLog.vue";

export default {
  name: "VerifyLogin",
  components: {
    EmployeeLog
  }
};
</script>
