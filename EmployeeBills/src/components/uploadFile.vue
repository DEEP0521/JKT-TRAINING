<template>
  <div id="upload-File">
    <h1>BILL UPLOAD</h1>
      <form @submit.prevent="submitBill" enctype="multipart/form-data">
        <table>
          <tr>
            <th>
              <label>Employee Code:</label>
            </th>
            <td>
              <input type="number" v-model="fileDetails.employee_id" placeholder="Enter employee code">
            </td>
          </tr>
          <tr>
            <th>
              <label>Start Date:</label>
            </th>
            <td>
              <input type="date" v-model="fileDetails.start_date">
            </td>
          </tr>
          <tr>
            <th>
              <label>End Date:</label>
            </th>
            <td>
              <input type="date" v-model="fileDetails.end_date">
            </td>
          </tr>
          <tr>
            <th>
              <label>Reimbursement Type:</label>
            </th>
            <td>
              <input type="text" v-model="fileDetails.type" placeholder="Upload file type">
            </td>
          </tr>
          <tr>
            <th>
              <label>Select File:</label>
            </th>
            <td>
              <input type="file" ref="file">
            </td>
          </tr>
          <tr>
            <th colspan="2">
              <button id="Submit">Submit!</button>
            </th>
          </tr>
        </table>
      </form>
  </div>
</template>

<script>

export default {
  name:"App",
  data () {
    return {
      fileDetails:{
          employee_id:'',
          type:'',
          start_date:'',
          end_date:'',
          file:''
      },
      response:''
    }
  },
  
  methods: {
     submitBill:function(){
      
      var formData= new FormData();
      formData.append('file',this.$refs.file.files[0]);
      formData.append('type',this.fileDetails.type);
      formData.append('start_date',this.fileDetails.start_date);
      formData.append('end_date',this.fileDetails.end_date);
      formData.append('user',this.fileDetails.employee_id);
      
      fetch('http://localhost:10090/Bills',{
        mode:"no-cors",
        method:'post',
        body:formData
      }).then((response)=>{
        if(response.status!=200){
          console.log("Error Uploading Data!");
        }else{
          console.log("Data Uploaded!")
        }
      }).catch(function(){
        console.log('FAILURE');
      });
    }
  }
}
</script>

<style>
table,tr{
  width: 100%;
  color: ghostwhite;
  font-size: 20px;
}
h1{
  text-align: center;
  color: ghostwhite;
}
input{
  width: 80%;
  padding: 10px 15px;
  margin:5px 0;
  box-sizing: border-box;
  }
#Submit{
  width: 20%; 
}
</style>
