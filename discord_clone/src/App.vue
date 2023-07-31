<template>
<div>
  <!-- 뷰 페이지 이동 예제 -->
<!-- 참고 사이트 : https://bicute.tistory.com/180 -->
  <!-- <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <router-view />  -->  <!-- 실제 페이지가 보여질 위치 -->
  <nav>
    <router-link to="/"></router-link>
    <!-- <router-link  to="/login" id="login_page_link">login</router-link> -->
    <!-- <button type="button" v-on:click="login()">임시</button> -->
  </nav>

  <router-view></router-view >

</div>
</template>

<script>

export default {
  name: 'App',
  components: {
  },
  methods: {
    login(){
      console.log("App.vue login 메소드 실행");
// this.$("#login_page_link").click(); //여기서 실행해도 jquery는 안먹힘
    },
}
}
</script>

<style>

</style>