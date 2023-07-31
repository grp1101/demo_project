<template>
<div class='loginForm_content_background'> 
  <div id='loginForm_content_detail'>
<form>
  <!-- Email input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example1">이메일 또는 전화번호</label>
    <input type="email" id="form2Example1" class="form-control" />
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example2">비밀번호</label>
    <input type="password" id="form2Example2" class="form-control" />
  </div>

  <!-- 2 column grid layout for inline styling -->
  <div class="row mb-4">
    
      <!-- Checkbox -->
    <!-- <div class="col d-flex justify-content-center">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
        <label class="form-check-label" for="form2Example31"> Remember me </label>
      </div>
    </div> -->

    <div class="col">
      <!-- Simple link -->
      <a href="#!">비밀번호를 잊으셨나요?</a>
    </div>
  </div>

  <!-- Submit button -->
  <button type="button" class="btn btn-primary btn-block mb-4">로그인</button>

  <!-- Register buttons -->
  <div class="text-center">
    <p>계정이 필요한가요? <a href="#!">가입하기</a></p>
    <!-- <p>or sign up with:</p> -->
    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-facebook-f"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-google"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-twitter"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-github"></i>
    </button>
  </div>

<!-- <qr-code text="login"></qr-code>  -->
<!-- 텍스트를 url로 만드는 QR임... -->
<!-- https://yoyostudy.tistory.com/53 -->
    <!-- <input placeholder="접속 URL 입력" v-model="site" v-on:focusin="value = ''">
    <div class="btn" v-on:click="value = 'https://chart.googleapis.com/chart?chs=400x400&cht=qr&chl='+site+'&choe=UTF-8'">생성</div>
    <img :src="value" v-if="this.value.length > 1"> -->

<div class="test">
    <img :src="value = 'https://chart.googleapis.com/chart?chs=400x400&cht=qr&chl=http://naver.com&choe=UTF-8'" >
    <div>QR코드로 로그인</div>
</div>

</form>

</div>
</div>
</template>

<script>

export default {
  name: 'loginForm-content',
  data(){
    return{
      site: '',
      value: ''
    }
  },
  components: {

  }
}
</script>

<style>
.loginForm_content_background{
  background-color: #2ECCFA;
    width: 60%;
    margin-left: 20%;
    height: 60%;
};
#loginForm_content_detail{
    width: 100px;
};
</style>