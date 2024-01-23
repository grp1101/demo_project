<template>
  <div>
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  name: "content_page",
  data() {
    return {};
  },
  mounted() {
    this.$router.push("/setting");
  },
};
</script>
