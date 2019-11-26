<template>
  <div>
    <el-card shadow="never">
      <div slot="header" class="header">
        <span>hóa đơn nhập</span>
      </div>
      <el-form
        :model="importData"
        :rules="rules"
        label-width="120px"
        :label-position="lablePosition"
        ref="importData"
      >
        <div class="content">
          <div class="above">
            <el-form-item label="Số hóa đơn" prop="id">
              <el-input v-model="importData.id"></el-input>
            </el-form-item>
            <el-form-item label="Ngày nhập" prop="ngaynhap">
              <el-date-picker
                v-model="importData.ngaynhap"
                type="date"
                format="dd - MM - yyyy"
                placeholder="Chọn ngày nhập"
              ></el-date-picker>
            </el-form-item>
            <el-form-item label="Nhà cung cấp" prop="nhacungcapId">
              <el-select
                v-model="importData.nhacungcapId"
                placeholder="Chọn nhà cung cấp"
                filterable
                clearable
              >
                <el-option
                  v-for="supplier in suppliers"
                  :key="supplier.id"
                  :value="supplier.id"
                  :label="supplier.tennhacungcap"
                ></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="Nhân viên" prop="nhanvienId">
              <el-select
                v-model="importData.nhanvienId"
                placeholder="Chọn nhân viên"
                clearable
                filterable
              >
                <el-option
                  v-for="employee in employees"
                  :key="employee.manhanvien"
                  :value="employee.manhanvien"
                  :label="employee.tennhanvien"
                >
                  <span style="margin-right: 10px;">{{employee.manhanvien}}</span>
                  <span>{{employee.tennhanvien}}</span>
                </el-option>
              </el-select>
            </el-form-item>
          </div>
          <div class="under">
            <el-form-item label="Sản phẩm" prop="sanphamId">
              <el-select
                v-model="importData.sanphamId"
                placeholder="Chọn sản phẩm"
                clearable
                filterable
                :remote-method="getMoneyChoose(importData.sanphamId)"
              >
                <el-option
                  v-for="product in products"
                  :key="product.id"
                  :value="product.id"
                  :label="product.loaisanpham+' - '+product.tensanpham"
                >
                  <span style="margin-right: 20px;">{{product.loaisanpham}}</span>
                  <span>{{product.tensanpham}}</span>
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="Số lượng" prop="soluong">
              <el-input-number
                v-model="importData.soluong"
                :min="1"
                @change="calculateMoney(importData.soluong)"
              ></el-input-number>
            </el-form-item>
            <el-form-item label="Đơn giá" prop="dongia">
              <span style="font-weight: bold">{{formatPrice(priceProduct)}} đ</span>
            </el-form-item>
          </div>
        </div>
        <div class="button">
          <el-button
            type="primary"
            style="margin-right: 60px;"
            @click="confirm('importData')"
          >XÁC NHẬN</el-button>
          <el-button type="primary" @click="reset('importData')">LÀM MỚI</el-button>
        </div>
      </el-form>
    </el-card>

    <ImportDetail
      :visibleDetail="showDialog"
      :detailId="chitietnhapId"
      :inputNumber="number"
      @dialog-close="showDialog=false"
    />
  </div>
</template>

<script>
import Axios from "../../http-commom.js";
import ImportDetail from "./ImportDetail.vue";
export default {
  components: {
    ImportDetail
  },
  data() {
    var checkDate = (rule, value, callback) => {
      if (value > new Date()) {
        callback(new Error("Chọn ngày nhỏ hơn hoặc bằng ngày hiện tại"));
      } else {
        callback();
      }
    };
    return {
      suppliers: null,
      employees: null,
      products: null,
      lablePosition: "left",
      priceProduct: null,
      number: null,
      showDialog: false,
      chitietnhapId: null,

      importData: {
        id: "",
        ngaynhap: null,
        nhacungcapId: "",
        nhanvienId: null,
        sanphamId: "",
        soluong: null,
        dongia: null
      },
      rules: {
        id: [
          { required: true, message: "Nhập số hóa đơn", trigger: "blur" },
          {
            min: 8,
            message: "Nhập số hóa đơn lớn hơn băng bằng 8 ký tự",
            trigger: "blur"
          }
        ],
        ngaynhap: [
          { required: true, message: "Chọn ngày nhập", trigger: "blur" },
          { validator: checkDate, trigger: "change" }
        ],
        nhacungcapId: [
          { required: true, message: "Chọn nhà cung cấp", trigger: "change" }
        ],
        nhanvienId: [
          { required: true, message: "Chọn nhân viên", trigger: "change" }
        ],
        sanphamId: [
          { required: true, message: "Chọn sản phẩm", trigger: "change" }
        ]
      }
    };
  },
  methods: {
    confirm(data) {
      var myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      this.$refs[data].validate(valid => {
        if (valid) {
          Axios.post("import", this.importData, myConfig).then(resp => {
            if (resp.data) {
              for (let i = 0; i < this.products.length; i++) {
                if (this.importData.sanphamId == this.products[i].id) {
                  if (this.products[i].loaisanpham == "Xe máy") {
                    this.chitietnhapId = resp.data;
                    this.showDialog = true;
                  }else if(this.products[i].loaisanpham == "Phụ tùng"){
                    for(let i=0;i<this.number;i++){
                      let data={chitietnhapId: resp.data}
                       Axios.post("import/motorcycleDetail",data, myConfig)
                    }
                    alert('Thành công')
                  }
                }
              }
            } else {
              alert("error "+resp.data);
            }
          });
        }
      });
    },
    reset(data) {
      this.priceProduct = 0;
      this.$refs[data].resetFields();
    },
    calculateMoney(n) {
      this.number = n;
    },
    getMoneyChoose(id) {
      for (let i = 0; i < this.products.length; i++) {
        if (id == this.products[i].id) {
          if (this.number) {
            this.priceProduct = this.products[i].dongia * this.number;
            this.importData.dongia = this.priceProduct;
          } else {
            this.priceProduct = this.products[i].dongia;
            this.importData.dongia = this.priceProduct;
          }
        }
      }
    },

    formatPrice(value) {
      let val = (value / 1).toFixed(0).replace(".", ",");
      return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
    },
    getEmployees() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("employee/employees", myConfig)
        .then(resp => {
          this.employees = resp.data.myData;
        })
        .catch(err => {
          alert("getEmployees error: " + err);
        });
    },
    getManufacturer() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("manufacturer", myConfig)
        .then(resp => {
          this.manufacturer = resp.data.myData;
        })
        .catch(err => {
          alert("getManufacturer error: " + err);
        });
    },

    getSuppliers() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("suppliers", myConfig)
        .then(resp => {
          this.suppliers = resp.data.myData;
        })
        .catch(err => {
          alert("getSupplier error: " + err);
        });
    },
    getProducts() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("product", myConfig)
        .then(resp => {
          this.products = resp.data.myData;
        })
        .catch(err => {
          alert("getSupplier error: " + err);
        });
    }
  },
  beforeMount() {
    this.getSuppliers();
    this.getEmployees();
    this.getProducts();
  }
};
</script>

<style lang="scss" scoped>
.el-card {
  width: 70%;
  margin: 30px auto;
  background: rgba(180, 182, 162, 0.582);

  .header {
    text-align: center;
    color: blue;
    font-size: 25px;
    font-weight: bold;
    text-transform: uppercase;
  }
}
.content {
  display: flex;
  .above {
    border-right: solid lavender 1px;
    flex-basis: 50%;
    padding-right: 4%;
  }
  .under {
    flex-basis: 50%;
    padding-left: 4%;
  }
}
.button {
  margin: 30px 300px 10px 300px;
}
</style>