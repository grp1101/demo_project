<template>
<div class='loginForm_content_background'>

      <!-- <div class="protected" v-if="loginSuccess">
          <h1>
              <b-badge variant="success">보안 사이트에 대한 액세스가 허용되었습니다</b-badge>
          </h1>
          <h5>로그인 성공!</h5>
      </div>
      <div class="unprotected" v-else-if="loginError">
          <h1>
              <b-badge variant="danger">이 페이지에 대한 접근 권한이 없습니다.</b-badge>
          </h1>
          <h5>로그인 실패!</h5>
      </div>
      <div class="unprotected" v-else>
          <h1>
              <b-badge variant="info">로그인해주세요</b-badge>
          </h1>
          <h5>로그인 하지 않았습니다. 로그인을 해주세요</h5>

          <form @submit.prevent="login()">
              <label>
                  <input type="text" placeholder="username" v-model="user">
              </label>
              <label>
                  <input type="password" placeholder="password" v-model="password">
              </label>
              <b-btn variant="success" type="submit" v-on:click="login_example2(user ,password)">Login</b-btn>
              <p v-if="error" class="error">Bad login information</p>
          </form>
      </div> -->




<!-- 나중에 밑에 코드로 바꾸기 -->
<div id='loginForm_content_detail'>
<form>
  
  <!-- Email input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="email">이메일 또는 전화번호</label>
    <input type="email" v-model="email" class="form-control" />
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="password">비밀번호</label>
    <input type="password" v-model="password" class="form-control" />
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
  <button type="button" class="btn btn-primary btn-block mb-4" v-on:click="login(email ,password)">로그인</button>

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
                  loginSuccess: false,
                  loginError: false,
                  user: '',
                  email: '',
                  password: '',
                  error: false
    }
  },
  components: {

  },
  methods: {
        async login(email ,password ){
          this.axios({
          method: 'post',
          url: '/api/login',
          data: {
                              email: email,
                              password: password
          },
  }, { withCredentials : true })
        .then((response) => {
          console.log("response.data = " , response.data);
          console.log("/api/login 로그인 성공");
        })
        .finally(() => {
          console.log("/api/login 실행");
        }); 
  },
    async login_example2(user ,password ){
                  try {
                      const result = await this.axios.get('/api/login', {
                          auth: {
                              username: user,
                              password: password
                          }
                      });
                      if (result.status === 200) {
                          this.loginSuccess = true
                      }
                  } catch (err) {
                      this.loginError = true;
                      console.log("err내용 : "+err);
                      // throw new Error(err)
                  }



  //     // api용 post 함수
  //         this.axios({
  //         method: 'get',
  //         url: '/api/login',
  //         auth: {
  //                             username: this.user,
  //                             password: this.password
  //         },
  // }, { withCredentials : true })
  //       .then((response) => {
  //         console.log("response.data = " , response.data);
  //         this.loginSuccess = true
  //       })
  //       .catch(err => {
  //       this.loginError = true;
  //       throw new Error(err)
  //       })
  //       .finally(() => {
  //         console.log("/api/login 실행");
  //       }); 
  },
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