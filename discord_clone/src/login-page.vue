<template>
  <div class="loginPage_background">
    <!-- 라우터 관련 사이트 :https://2dongdong.tistory.com/41 -->

    <!-- <login-form-content></login-form-content> -->

    <router-link to="login_page_content" active-class="true">1</router-link>

    <transition name="bounce">
      <router-view> </router-view>
    </transition>
  </div>
</template>

<script>
export default {
  name: "login-page",
  components: {},
  watch() {},
};
</script>

<style>
.loginPage_background {
  background-color: #5882fa;
  /*nav의 스타일 때문인지 백그라운드 컬러 적용안됨*/
  color: white;
  height: 100vh;
  width: 100%;
  background-image: url("@/assets/jenna12.jpg");
  /*이미지 사이즈 꽉 채워주는 방법인데 height: 100%*/
  background-size: cover;
  display: flex;
  align-items: center;
}

.bounce-enter-active {
  animation: bounce-in 0.5s;
}
.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}
@keyframes bounce-in {
  0% {
    transform: scale(0);
  }
  50% {
    transform: scale(1.25);
  }
  100% {
    transform: scale(1);
  }
}
</style>
