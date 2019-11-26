<template>
  <div>
    <el-card shadow="never">
      <div slot="header" class="header">
        <span>hóa đơn bán hàng</span>
      </div>
      <el-form
        :model="exportData"
        :rules="rules"
        label-width="120px"
        :label-position="lablePosition"
        ref="exportData"
      >
        <div class="content">
          <div class="above">
            <el-form-item label="Số hóa đơn" prop="id">
              <el-input v-model="exportData.id"></el-input>
            </el-form-item>
            <el-form-item label="Ngày bán" prop="ngayban">
              <el-date-picker
                v-model="exportData.ngayban"
                type="date"
                format="dd - MM - yyyy"
                placeholder="Chọn ngày bán"
              ></el-date-picker>
            </el-form-item>
            <el-form-item label="Nhân viên tạo" prop="nhanvienId">
              <el-select
                v-model="exportData.nhanvienId"
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
            <el-form-item label="Khách hàng" prop="khachhangId">
              <el-select
                v-model="exportData.khachhangId"
                placeholder="Chọn khách hàng"
                clearable
                filterable
              >
                <el-option
                  v-for="customer in customers"
                  :key="customer.makhachhang"
                  :value="customer.makhachhang"
                  :label="customer.tenkhachhang"
                >
                  <span style="margin-right: 10px;">{{customer.makhachhang}}</span>
                  <span>{{customer.tenkhachhang}}</span>
                </el-option>
              </el-select>
            </el-form-item>
          </div>
          <div class="under">
            <el-form-item label="Sản phẩm" prop="sanphamId">
              <el-select
                v-model="exportData.sanphamId"
                placeholder="Chọn sản phẩm"
                clearable
                filterable
                :remote-method="getMoneyChoose(exportData.sanphamId)"
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
                v-model="exportData.soluong"
                :min="1"
                @change="calculateMoney(exportData.soluong)"
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
            @click="confirm('exportData')"
          >XÁC NHẬN</el-button>
          <el-button type="primary" @click="reset('exportData')">LÀM MỚI</el-button>
        </div>
      </el-form>
    </el-card>

    <ExportDetail
      :visibleDetail="showDialog"
      :detailId="hoadonnhapId"
      :inputNumber="number"
      :product="sokhungsomay"
      @dialog-close="showDialog=false"
    />
  </div>
</template>

<script>
import Axios from "../../http-commom.js";
import ExportDetail from "./ExportDetail.vue";
export default {
  components: {
    ExportDetail
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
      employees: null,
      products: null,
      customers: null,
      lablePosition: "left",
      priceProduct: null,
      number: null,
      showDialog: false,
      hoadonnhapId: null,
      masanphamId: null,
      sokhungsomay: [],

      exportData: {
        id: "",
        ngayban: null,
        nhanvienId: null,
        khachhangId: null,
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
        ngayban: [
          { required: true, message: "Chọn ngày nhập", trigger: "blur" },
          { validator: checkDate, trigger: "change" }
        ],
        nhacungcapId: [
          { required: true, message: "Chọn nhà cung cấp", trigger: "change" }
        ],
        nhanvienId: [
          { required: true, message: "Chọn nhân viên", trigger: "change" }
        ],
        khachhangId: [
          { required: true, message: "Chọn khách hàng", trigger: "change" }
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
          Axios.post("export", this.exportData, myConfig).then(resp => {
            if (resp.data) {
              for (let i = 0; i < this.products.length; i++) {
                if (this.exportData.sanphamId == this.products[i].id) {
                  this.masanphamId = this.products[i].id;
                  if (this.products[i].loaisanpham == "Xe máy") {
                    this.getImportDetail();
                    this.hoadonnhapId = resp.data;
                    this.showDialog = true;
                  } else if (this.products[i].loaisanpham == "Phụ tùng") {
                    for (let i = 0; i < this.number; i++) {
                      let data = { hoadonnhapId: resp.data };
                      Axios.post("export/motorcycleDetail", data, myConfig);
                    }
                    alert("Thành công");
                  }
                }
              }
            } else {
              alert("error roi con dau" + resp.data);
            }
          });
        }
      });
    },
    reset(data) {
      this.priceProduct = 0;
      this.$refs[data].resetFields();
    },
    getImportDetail() {
      var myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("export/getImportDetail?id=" + this.masanphamId, myConfig).then(
        resp => {
          this.sokhungsomay = resp.data.myData;
        }
      );
    },
    calculateMoney(n) {
      this.number = n;
    },
    getMoneyChoose(id) {
      for (let i = 0; i < this.products.length; i++) {
        if (id == this.products[i].id) {
          if (this.number) {
            this.priceProduct = this.products[i].dongia * this.number;
            this.exportData.dongia = this.priceProduct;
          } else {
            this.priceProduct = this.products[i].dongia;
            this.exportData.dongia = this.priceProduct;
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
    getCustomers() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("customer/customers", myConfig)
        .then(resp => {
          this.customers = resp.data.myData;
        })
        .catch(err => {
          alert("getCustomer error: " + err);
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
    this.getEmployees();
    this.getProducts();
    this.getCustomers();
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