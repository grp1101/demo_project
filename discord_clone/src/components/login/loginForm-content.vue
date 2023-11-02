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
      <div class="text-center">
        <h4>돌아오신 것을 환영해요!</h4>
        <p>다시 만나다니 너무 반가워요!</p>
      </div>

      <form class="row g-3">
        <!-- Email input -->
        <div class="mb-0">
          <label class="form-label" for="text" style="font-size: 13px"
            >이메일 또는 전화번호</label
          >
          <input
            type="text"
            v-model="email"
            class="form-control bg-dark text-secondary border-0 rounded"
            required
          />
        </div>
        <!-- Password input -->
        <div class="mb-0">
          <label class="form-label" for="password" style="font-size: 13px"
            >비밀번호</label
          >
          <input
            type="password"
            v-model="password"
            class="form-control bg-dark text-secondary border-0 rounded"
            required
          />
          <a href="/">비밀번호를 잊으셨나요?</a>
        </div>

        <!-- Submit button -->
        <button
          type="button"
          class="btn btn-primary btn-block mb-4 border-0 rounded"
          style="background-color: #642efe"
          v-on:click="login(email, password)"
        >
          로그인
        </button>
        <!-- Register buttons -->
        <p>
          계정이 필요한가요?
          <router-link to="signup_page_content">가입하기</router-link>
        </p>
      </form>
    </div>

    <div id="QR_style" class="text-center">
      <img
        :src="
          (value =
            'https://chart.googleapis.com/chart?chs=400x400&cht=qr&chl=http://naver.com&choe=UTF-8')
        "
      />
      <h4>QR코드로 로그인</h4>
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
  width: 50%;
  height: 55%;
  margin-left: 25%;
  padding-top: 2%;
  font-size: 15px;
  color: #7e8f93;
}
#loginForm_content_detail_style {
  width: 420px;
  margin-left: 5%;
  margin-right: 5%;
  float: left;
}
h4 {
  color: white;
  font-weight: bold;
}
#header {
  align-items: center;
}
input {
  background-color: black;
}
#QR_style {
  margin-left: 5%;
  margin-right: 5%;
}
img {
  width: 180px;
  height: 180px;
  margin-top: 50px;
}
</style>
