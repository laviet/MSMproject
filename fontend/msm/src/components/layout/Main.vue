<template>
  <div>
     <img style="width: 150px; height: 150px" :src="require(`@/images/${namePicture}`)" />
     <img style="width: 150px; height: 150px" src="@/images/pic1.jpg"/>
  </div>
</template>

<script>
export default {
  data() {
    return {
      url: '@/images/pic1.jpg',
      namePicture: 'pic2.jpg'
    };
  }
};
</script>