<template>
  <div>
    <!-- <h1>Discord Clone Project</h1> -->
    <!-- 디스코드 색깔: #5882FA -->
    <headerContent @loginClick="loginClick"></headerContent>
    <bodyContent></bodyContent>
    <footerContent></footerContent>
  </div>

  <!-- loing버튼내에서 클릭 이벤트 설정해가지고 위의 login링크를 강제적으로 클릭해서 페이지를 넘어가는 식으로 설정하기. login 링크는 숨김 처리-->
  <!-- 라우터를 콜해가지고 전환시켜서 컴포넌트 내에서 선언할 수 있도록 나중에 한번 찾아보기-->
</template>

<script>
import headerContent from "./components/main/header-content.vue";
import bodyContent from "./components/main/body-content.vue";
import footerContent from "./components/main/footer-content.vue";

export default {
  name: "main-page",
  components: {
    headerContent,
    bodyContent,
    footerContent,
  },
  methods: {
    loginClick() {
      console.log("main-page loginClick 메소드 실행");
      // this.$("#login_page_link").Click();
    },
  },
};
</script>

<style></style>
