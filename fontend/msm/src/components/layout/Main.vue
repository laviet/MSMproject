<template>
  <div class="header">
    <div class="main">
      <div class="title">
        <span>
          <el-input
            class="search"
            placeholder="Search"
            clearable
            v-model="search"
            prefix-icon="el-icon-search"
          >
            <el-button slot="append" icon="el-icon-search" @click="searchData"></el-button>
          </el-input>
        </span>
        <span style="margin-left: 70px;">
          <el-select v-model="sort" placeholder="Sắp xếp" clearable filterable :change="dataSort()">
            <el-option
              v-for="product in options"
              :key="product.value"
              :value="product.value"
              :label="product.label"
            ></el-option>
          </el-select>
        </span>
      </div>
      <span v-for="product in products" :key="product.id" class="content">
        <el-card shadow="hover">
          <img style="width: 241px; height: 180px" :src="require(`@/images/${product.hinhanh}`)" />
          <div>
            <div class="productName">{{product.tensanpham}}</div>
            <div>Màu sắc: {{product.mausac}}</div>
            <div>
              Giá:
              <span style="font-weight: bold">{{formatPrice(product.dongia)}} đ</span>
            </div>
          </div>
        </el-card>
      </span>
    </div>
  </div>
</template>

<script>
import Axios from "../../http-commom.js";
export default {
  data() {
    return {
      products: null,
      search: null,
      sort: null,
      options: [
        { value: "loaisanpham", label: "Loại sản phẩm" },
        { value: "tensanpham", label: "Tên sản phẩm" },
        { value: "dongia", label: "Giá" }
      ]
    };
  },

  methods: {
    searchData() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      if (this.search != null) {
        Axios.get("product/search?name=" + this.search, myConfig).then(resp => {
          this.products = resp.data.myData;
        });
      }
    },
    dataSort() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      if (this.sort != null) {
        Axios.get("product/sort?category=" + this.sort, myConfig).then(resp => {
          this.products = resp.data.myData;
        });
      }
    },
    getProducts() {
      let myConfig = {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("accessToken")
        }
      };
      Axios.get("product", myConfig).then(resp => {
        this.products = resp.data.myData;
      });
    },
    formatPrice(value) {
      let val = (value / 1).toFixed(0).replace(".", ",");
      return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
    }
  },
  beforeMount() {
    this.getProducts();
  }
};
</script>

<style lang="scss" scoped>
.header {
  padding: 20px 0;
}
.main {
  width: 90%;
  margin: 0 auto;
  .title {
    margin-bottom: 10px;
    .search {
      width: 400px;
      margin-left: 400px;
    }
  }
}
.el-card {
  display: inline-block;
  margin: 10px;
  .productName {
    font-weight: bold;
    color: red;
    font-size: 20px;
    margin: 5px 0 10px 0;
    text-align: center;
  }
}
</style>