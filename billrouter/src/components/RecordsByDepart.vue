<template>
  <div class="verify">
    <h3>
      <router-link :to="'/billview/' + id">View Uploaded Bills</router-link>
      |
      <router-link to="/">EXIT</router-link>
    </h3>
    <h1>Enter Details</h1>
    <form @submit.prevent="login">
      <table>
        <tr>
          <th>
            <label>Department ID:</label>
          </th>
          <td>
            <input
              type="number"
              v-model="departid"
              placeholder="Enter Department Id"
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
              v-model="passcode"
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
      id: this.$route.params.id,
      departid: "",
      passcode: "",
      temp: []
    };
  },
  methods: {
    login: function() {
      axios
        .get("http://localhost:10090//department/" + this.departid, {
          headers: { "Access-Control-Allow-Origin": "*" }
        })
        .then(response => {
          this.temp = response.data.map(x => x.id);
          for (let index = 0; index < this.temp.length; index++) {
            return <p>x.id</p>;
          }
          console.log(this.temp);
          if (this.temp !== null) {
            console.log(response.status);
            this.$router.push({
              path: "/adminview/" + this.departid
            });
          } else {
            alert("Incorrect Department ID");
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
