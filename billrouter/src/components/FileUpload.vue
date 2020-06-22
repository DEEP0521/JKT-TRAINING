<template>
  <div class="file">
    <h3>
      <router-link :to="'/billview/' + fileDetails.id"
        >View Uploaded Bills</router-link
      >
      |
      <router-link :to="'/departlog/' + fileDetails.id"
        >View Employee Bill</router-link
      >
      |
      <router-link to="/">EXIT</router-link>
    </h3>
    <h1>BILL UPLOAD</h1>
    <form @submit.prevent="submitBill" enctype="multipart/form-data">
      <table>
        <tr>
          <th>
            <label>Employee Code:</label>
          </th>
          <td>
            <label>{{ fileDetails.id }}</label>
          </td>
        </tr>
        <tr>
          <th>
            <label>Month:</label>
          </th>
          <td>
            <input type="month" v-model="fileDetails.month" />
          </td>
        </tr>
        <tr>
          <th>
            <label>Reimbursement Type:</label>
          </th>
          <td>
            <input
              type="text"
              v-model="fileDetails.type"
              placeholder="Enter Reimbursement type"
            />
          </td>
        </tr>
        <tr>
          <th>
            <label>Select File:</label>
          </th>
          <td>
            <input
              type="file"
              ref="file"
              accept="application/pdf,application/doc"
            />
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
  name: "FileUpload",
  data: function() {
    return {
      fileDetails: {
        id: this.$route.params.id,
        type: "",
        month: "",
        file: "",
        response: "",
        temp: []
      }
    };
  },
  methods: {
    submitBill: function() {
      var formData = new FormData();
      formData.append("user", this.fileDetails.id);
      formData.append("file", this.$refs.file.files[0]);
      formData.append("type", this.fileDetails.type);
      formData.append("month", this.fileDetails.month);

      fetch("http://localhost:10090/users/" + this.fileDetails.id + "/bills", {
        mode: "no-cors",
        method: "post",
        body: formData
      })
        .then(response => {
          this.temp = response.data;
          if (this.temp !== null) {
            console.log("Data Uploaded!");
            this.$router.push({
              path: "/billview/" + this.fileDetails.id
            });
          } else {
            console.log("Error Uploading data");
          }
        })
        .catch(function(errors) {
          console.log(errors);
          console.log("NO Record Found!");
          location.reload();
        });
    }
  },
  props: {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
table,
tr {
  width: 100%;
  color: ghostwhite;
  font-size: 20px;
}
h1 {
  text-align: center;
  color: ghostwhite;
}
h3 {
  text-align: left;
}
input {
  width: 80%;
  padding: 10px 15px;
  margin: 5px 0;
  box-sizing: border-box;
}
#Submit {
  width: 20%;
}
</style>
