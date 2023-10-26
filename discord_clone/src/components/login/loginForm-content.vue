<template>
  <!-- <div class="board"> -->
  <div class="loginForm_content_background">
    <!-- 회원가입 없는 로그인 버전 -->
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
    <div id="loginForm_content_detail_style">
      <h3>돌아오신 것을 환영해요!</h3>
      <p>다시 만나다니 너무 반가워요!</p>

      <form>
        <!-- Email input -->
        <div class="form-outline mb-4">
          <label class="form-label" for="email">이메일</label>
          <input type="email" v-model="email" class="form-control" />
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
          <label class="form-label" for="password">비밀번호</label>
          <input type="password" v-model="password" class="form-control" />
        </div>

        <div class="col">
          <!-- Simple link -->
          <a href="#!">비밀번호를 잊으셨나요?</a>
        </div>

        <!-- Submit button -->
        <button
          type="button"
          class="btn btn-primary btn-block mb-4"
          v-on:click="login(email, password)"
        >
          로그인
        </button>

        <!-- Register buttons -->
        <div class="text-center">
          <p>계정이 필요한가요? <a href="/signup_page_content">가입하기</a></p>
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
      </form>
    </div>

    <div id="QR_style" class="text-center">
      <img
        :src="
          (value =
            'https://chart.googleapis.com/chart?chs=400x400&cht=qr&chl=http://naver.com&choe=UTF-8')
        "
      />
      <h3>QR코드로 로그인</h3>
      <p>DISCORD 모바일앱으로 스캔해 바로 로그인하세요.</p>
    </div>
  </div>
  <!-- </div> -->
</template>

<script>
export default {
  name: "loginForm-content",
  data() {
    return {
      loginSuccess: false,
      loginError: false,
      user: "",
      email: "",
      password: "",
      error: false,
    };
  },
  components: {},
  mounted() {
    console.log("loginForm-content mounted 실행됨");
  },
  methods: {
    async login(email, password) {
      //formData형태로 시큐리티에 파라미터 넘기기
      const loginData = new FormData();
      loginData.append("email", email);
      loginData.append("password", password);

      this.axios(
        {
          method: "post",
          url: "/api/login",
          data: loginData,
          Headers: {
            "Context-Type": "multipart/form-data",
          },
        },
        { withCredentials: true }
      )
        .then((response) => {
          console.log("response.data = ", response.data);

          if (response.data.email != null) {
            console.log("/api/login 로그인 성공");

            // this.$cookies.set("auth", response.data);
            console.log("cookie 생성여부 : ", this.$cookies.isKey("auth"));
            console.log("cookie 내용 : ", this.$cookies.get("auth"));

            if (this.$cookies.isKey("auth") === true) {
              this.$cookies.set("auth", "9876"); //백엔드 쿠키값을 변경
            }

            //변경된 쿠키 value
            console.log("변경된 cookie 내용 : ", this.$cookies.get("auth"));

            alert("Login Success");
            this.$router.push("/");
          } else {
            alert("Login Failed");
          }
        })
        .finally(() => {
          console.log("/api/login 실행");
        });
    },
  },
};
</script>

<style>
/* https://hianna.tistory.com/675 가운데로 보내는 방법 */
.loginForm_content_background {
  background-color: #33393a;
  width: 60%;
  height: 70%;
  margin-left: 20%;
  padding-top: 2%;
  font-size: 15px;
  color: #7e8f93;
}
#loginForm_content_detail_style {
  width: 300px;
  margin-left: 5%;
  margin-right: 5%;
  float: left;
}
h3 {
  color: white;
}
</style>
