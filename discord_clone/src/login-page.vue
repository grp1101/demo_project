<template>
<div class='loginPage_background'>
<login-form-content></login-form-content>
</div>
</template>

<script>
import loginFormContent from './components/login/loginForm-content.vue'

export default {
  name: 'login-page',
  components: {
loginFormContent
  },

}
</script>

<style>
.loginPage_background{
/* background-color: #5882FA ;  */
/*nav의 스타일 때문인지 백그라운드 컬러 적용안됨*/
/* color: white; */
background-image: url('@/assets/login-background.jpg');
height: 100%;
}
</style>