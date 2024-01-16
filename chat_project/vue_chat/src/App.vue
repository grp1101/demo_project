<template>
  <div>
    <hd></hd>
    <router-view></router-view>
    <ft></ft>
  </div>
</template>

<script>
import hd from "./components/common_header/common_header.vue";
import ft from "./components/common_footer/common_footer.vue";

export default {
  name: "App",
  components: {
    hd,
    ft,
  },
  mounted() {
    // this.$router.push("/login_page");
    this.$router.push("/chat");
    // this.$router.push("/chatRoom");
  },
};
</script>
