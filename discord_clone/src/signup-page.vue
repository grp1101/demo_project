<template>
  <div class="signupPage_background">
    <!-- <signup-form-content></signup-form-content> -->
  </div>
</template>

<script>
// import signupFormContent from "./components/signup/signupForm-content.vue";

export default {
  name: "signup-page",
  components: {
    // signupFormContent,
  },
};
</script>

<style>
.signupPage_background {
  /* background-color: #5882FA ;  */
  /*nav의 스타일 때문인지 백그라운드 컬러 적용안됨*/
  /* color: white; */
  height: 100vh;
  width: 100%;
  background-image: url("@/assets/jenna12.jpg");
  /*이미지 사이즈 꽉 채워주는 방법인데 height: 100%*/
  background-size: cover;
  display: flex;
  align-items: center;
}
</style>
