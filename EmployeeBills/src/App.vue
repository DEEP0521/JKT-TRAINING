<template>
  <div id="Employee">
    
    <upload-File></upload-File>
  </div>
</template>

<script>

import uploadFile from './components/uploadFile.vue';

export default {
  components:{
    'upload-File':uploadFile
  },
  data () {
    return {
      
    }
  }
}
</script>

<style>
body{
  background-color: darkgray;
}
#Employee{
  margin-block: inherit;
  box-sizing: border-box;
  background-color:rgb(24, 98, 121);
  height: 630px;
  border: 30px solid rgb(13, 55, 70);
}
</style>
