<template>
  <div class="verify">
    <h3>
      <router-link to="/">Exit</router-link>
    </h3>
    <h1>Employee Bills!</h1>
    <table>
      <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Department ID</th>
      </tr>
      <tr v-for="n in store" :key="n.id">
        <td>{{ n.username }}</td>
        <td>{{ n.first_name }} +" "+ {{ n.last_name }}</td>
        <td>{{ n.department_id }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "BillsView",
  data: function() {
    return {
      departmentID: this.$route.params.logDetails.departid,
      store: []
    };
  },
  created() {
    axios
      .get("http://localhost:10090//department/" + this.departid, {
        responseType: "json",
        headers: { "Access-Control-Allow-Origin": "*" }
      })
      .then(response => {
        this.temp = response.data.map(x => x.first_name);
        console.log(this.temp);
      })
      .catch(function(errors) {
        console.log(errors);
        alert("NO Record Found!");
        location.reload();
      });
  },
  methods: {}
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
