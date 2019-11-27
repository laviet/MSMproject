<template>
  <div>
    <el-card>
      <div slot="header" class="header">
        <span>Thống kê</span>
      </div>
      <div>
        <el-form>
          <el-form-item label="Số xe đã bán">
            <span>{{saled}}</span>
          </el-form-item>
          <el-form-item label="Số xe còn lại">
            <span>{{remain}}</span>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
import Axios from "../../http-commom.js";
export default {
  data() {
    return {
      saled: null,
      remain: null
    };
  },
  methods: {
    getCountSalle() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("statistic/saled", myConfig)
        .then(resp => {
          this.saled = resp.data.myData;
        })
        .catch(err => {
          this.$router.push("/denied");
          window.console.log(err);
        });
    },
    getCountRemain() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("statistic/remain", myConfig)
        .then(resp => {
          this.remain = resp.data.myData;
        })
        .catch(err => {
          this.$router.push("/denied");
          window.console.log(err);
        });
    }
  },
  beforeMount() {
    this.getCountSalle();
    this.getCountRemain();
  }
};
</script>

<style lang="scss" scoped>
.el-card {
  width: 30%;
  margin: 30px auto;
  background: lightgreen;
}
.header {
  text-align: center;
  color: blue;
  font-size: 20px;
  font-weight: bold;
  text-transform: uppercase;
}
</style>