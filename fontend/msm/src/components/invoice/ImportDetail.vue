<template>
  <div>
    <el-dialog
      class="dialog"
      title="Thông tin chi tiết cho từng sản phẩm"
      :visible.sync="visibleDetail"
      center
      :before-close="closeDialog"
      width="30%"
      :close-on-click-modal="false"
    >
      <span style="text-align:center;display: block; margin-bottom: 12px;">Nhập xe thứ {{number}}</span>
      <el-form
        :model="importData"
        :rules="rules"
        ref="importData"
        label-width="100px"
        class="demo-ruleForm"
        :label-position="labelPosition"
      >
        <el-form-item label="Số khung" prop="sokhung">
          <el-input v-model="importData.sokhung"></el-input>
        </el-form-item>
        <el-form-item label="Số máy" prop="somay">
          <el-input v-model="importData.somay"></el-input>
        </el-form-item>
        <el-form-item></el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('importData')">OK</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import Axios from "../../http-commom.js";
export default {
  props: {
    visibleDetail: null,
    detailId: null,
    inputNumber: null
  },
  data() {
    return {
      labelPosition: "left",
      number: 1,
      importData: {
        sokhung: "",
        somay: "",
        chitietnhapId: null,
      },
      rules: {
        sokhung: [
          { required: true, message: "Nhập số khung", trigger: "blur" }
        ],
        somay: [{ required: true, message: "Nhập số máy", trigger: "blur" }]
      }
    };
  },
  methods: {
    closeDialog() {
      if (this.number < this.inputNumber) {
        alert("nhap du so xe");
      } else {
        this.visibleDetail = false;
        this.$emit("dialog-close");
      }
    },
    submitForm(formName) {
      var myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.importData.chitietnhapId = this.detailId;
          Axios.post("import/motorcycleDetail", this.importData, myConfig)
            .then(resp => {
              alert(resp.data);
              this.number++;
              this.importData.sokhung = "";
              this.importData.somay = "";
            })
            .catch(err => {
              alert(err);
            });
          if (this.number == this.inputNumber) {
            this.number = 0;
            this.$emit("dialog-close");
          }
        }
      });
    }
  }
  //   beforeMount() {
  //     this.importData.chitietnhapId = this.detailId;
  //   }
};
</script>

<style lang="scss" scoped>
</style>