<template>
  <div>
    <hd></hd>
    <router-view></router-view>
  </div>
</template>

<script>
import hd from "./components/common_header/common_header.vue";

export default {
  name: "App",
  components: {
    hd,
  },
  mounted() {
    this.$router.push("/login_page");
  },
};
</script>
