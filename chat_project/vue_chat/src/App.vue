<template>
  <div>
    <section style="background-color: white">
      <div class="container py-5">
        <div class="row d-flex justify-content-center">
          <div class="col-md-8 col-lg-6 col-xl-4">
            <div
              class="card"
              id="chat1"
              style="border-radius: 15px; height: 700px"
            >
              <hd></hd>
              <ct></ct>
              <ft></ft>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import hd from "./components/common_header/common_header.vue";
import ft from "./components/common_footer/common_footer.vue";
import ct from "/content.vue";

export default {
  name: "App",
  components: {
    hd,
    ft,
    ct,
  },
  mounted() {
    // this.$router.push("/login_page");
    // this.$router.push("/chat");
    // this.$router.push("/chatRoom");
    // this.$router.push("/setting");
  },
};
</script>
