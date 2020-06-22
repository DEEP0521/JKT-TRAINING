<template>
  <div class="fileUpload">
    <FileUpload />
  </div>
</template>

<script>
// @ is an alias to /src
import FileUpload from "@/components/FileUpload.vue";

export default {
  name: "FileSubmit",
  components: {
    FileUpload
  }
};
</script>
