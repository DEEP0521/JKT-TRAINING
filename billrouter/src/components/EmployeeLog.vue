<template>
  <div class="verify">
    <h1>Enter Details</h1>
    <form @submit.prevent="login">
      <table>
        <tr>
          <th>
            <label>Employee Code:</label>
          </th>
          <td>
            <input
              type="number"
              v-model="logDetails.id"
              placeholder="Enter employee code"
            />
          </td>
        </tr>
        <tr>
          <th>
            <label>Password:</label>
          </th>
          <td>
            <input
              type="password"
              v-model="logDetails.passcode"
              placeholder="Enter your password"
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
import axios from "axios";

export default {
  name: "EmployeeLog",
  data: function() {
    return {
      logDetails: {
        id: "",
        passcode: "",
        temp: ""
      }
    };
  },
  methods: {
    login: function() {
      axios
        .get("http://localhost:10090//users/" + this.logDetails.id, {
          headers: { "Access-Control-Allow-Origin": "*" }
        })
        .then(response => {
          this.logDetails.temp = response.data;
          if (this.logDetails.temp !== null) {
            this.$router.push({
              path: "/file/" + this.logDetails.id
            });
          } else {
            console.log("No Record Found!");
          }
        })
        .catch(function(errors) {
          console.log(errors);
          alert("NO Record Found!");
          location.reload();
        });
    }
  }
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
