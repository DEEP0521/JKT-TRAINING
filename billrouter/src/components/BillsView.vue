<template>
  <div class="viewBills">
    <h3>
      <router-link :to="'/file/' + empid">Upload Bill</router-link> |
      <router-link to="/">EXIT</router-link>
    </h3>
    <h1>Employee Bills!</h1>
    <table>
      <tr>
        <th>Month</th>
        <th>Reimbursement Type</th>
        <th>Delete Bill</th>
        <th>Download Bill</th>
      </tr>
      <tr v-for="n in store" :key="n.id">
        <td>{{ n.month }}</td>
        <td>{{ n.type }}</td>
        <td>
          <button v-show="n.file != null" @click="deleteBill(n.id)">
            Delete
          </button>
        </td>
        <td>
          <button
            v-show="n.file != null"
            @click="downloadBill(n.id, n.month, n.type)"
          >
            Link
          </button>
        </td>
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
      empid: this.$route.params.id,
      store: [],
      temp: ""
    };
  },
  created() {
    axios
      .get("http://localhost:10090//Bills/" + this.empid, {
        headers: { "Access-Control-Allow-Origin": "*" }
      })
      .then(response => {
        this.store = response.data;
        console.log(this.store.length);
        this.month = this.store.month;
        this.type = this.store.type;
        if (this.store.length != 0) {
          console.log("Data Found!");
        } else if (this.store.length == 0) {
          alert("No Data Found!");
          this.$router.push({
            path: "/file/" + this.empid
          });
        }
      })
      .catch(function(errors) {
        console.log(errors);
        alert("NO Record Found!");
        this.$router.push({
          path: "/file/" + this.empid
        });
      });
  },
  methods: {
    downloadBill(fileId, month, type) {
      axios
        .get("http://localhost:10090//downloadFile/" + fileId, {
          responseType: "blob",
          headers: { "Access-Control-Allow-Origin": "*" }
        })
        .then(response => {
          var fileURL = window.URL.createObjectURL(new Blob([response.data]));
          var fileLink = document.createElement("a");

          fileLink.href = fileURL;
          fileLink.setAttribute(
            "download",
            this.empid + " " + month + " " + type + ".pdf"
          );
          document.body.appendChild(fileLink);

          fileLink.click();
        })
        .catch(function(errors) {
          console.log(errors);
          alert("NO Record Found!");
          location.reload();
        });
    },
    deleteBill(fileId) {
      axios
        .delete("http://localhost:10090//Bills/" + fileId, {
          headers: { "Access-Control-Allow-Origin": "*" }
        })
        .then(response => {
          this.temp = response.data;
          if (this.temp != null) {
            console.log("Bill Deleted");
            location.reload();
          } else {
            console.log("Internal Error");
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
