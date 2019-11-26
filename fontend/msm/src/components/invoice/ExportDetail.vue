<template>
  <div>
    <el-dialog
      class="dialog"
      title="Chọn số khung số máy"
      :visible.sync="visibleDetail"
      center
      :before-close="closeDialog"
      width="35%"
      :close-on-click-modal="false"
    >
      <span style="text-align:center;display: block; margin-bottom: 12px;">Nhập xe thứ {{number}}</span>
      <el-form
        :model="importData"
        :rules="rules"
        ref="importData"
        label-width="150px"
        class="demo-ruleForm"
        :label-position="labelPosition"
      >
        <el-form-item label="Số khung - số máy" prop="id">
          <el-select
            v-model="importData.id"
            placeholder="Chọn số khung số máy"
            clearable
            filterable
          >
            <el-option
              v-for="p in product"
              :key="p.id"
              :value="p.id"
              :label="p.sokhung+' - '+p.somay"
            >
              <span style="margin-right: 20px;">{{p.id}}</span>
              <span style="margin-right: 20px;">{{p.sokhung}}</span>
              <span>{{p.somay}}</span>
            </el-option>
          </el-select>
        </el-form-item>
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
    inputNumber: null,
    product: null
  },
  data() {
    return {
      labelPosition: "left",
      number: 1,
      importData: {
        id: null,
        chitiethoadonId: null,
      },
      rules: {
        id: [
          { required: true, message: "Chọn số khung số máy", trigger: "blur" }
        ],
      }
    };
  },
  methods: {
    closeDialog() {
      if (this.number < this.inputNumber+1) {
        alert("nhập đủ số xe là " + this.inputNumber);
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
          this.importData.chitiethoadonId = this.detailId;
          Axios.post("export/updateMotorcycle", this.importData, myConfig)
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
};
</script>

<style lang="scss" scoped>
</style>