<template>
  <div class="header_background">
    <!-- <font-awesome-icon :icon="['fab', 'discord']" />
    <div>test</div> -->
    <!-- <i class="fa-brands fa-discord"></i> -->
    <nav class="navbar navbar-expand-lg">
      <a class="navbar-brand" href="#" id="navtext">
        <font-awesome-icon icon="fa-brands fa-discord" />
        Discord
      </a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="nav navbar-nav">
          <!-- <li class="nav-item active"> -->
          <li class="nav-item">
            <!-- <a class="nav-link" v-on:click="LoadDownloadPage()" id="navtext"
              >Download
            </a> -->
            <a class="nav-link" v-on:click="LoadDownloadPage()" id="navtext"
              >Download
            </a>
          </li>
          <!-- <span class="sr-only">(current)</span> -->
          <li class="nav-item">
            <a class="nav-link" href="#" id="navtext">Nitro</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="navtext">Discover</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="navtext">Safety</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="navtext">Support</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="navtext">Blog</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="navtext">Careers</a>
          </li>
          <!-- <li class="nav-item">
            <div class="nav-link">{{ user_name }}님</div>
          </li> -->
          <!-- <img src = "@/assets/image1.jpg" /> -->
          <!-- <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li> -->
          <!-- <li class="nav-item">
        <a class="nav-link" href="#">login</a>
      </li> -->
        </ul>
        <!-- <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form> -->
      </div>
      <button
        type="button"
        class="btn"
        v-on:click="logout()"
        style="background-color: #ffffff; border-radius: 20px"
        v-show="KeyChecked"
      >
        Logout
      </button>
      <button
        type="button"
        class="btn"
        v-on:click="login()"
        style="background-color: #ffffff; border-radius: 20px"
      >
        Login
      </button>
      <!-- <button
        type="button"
        class="btn"
        v-on:click="signUp()"
        style="background-color: #ffffff; border-radius: 20px"
      >
        회원가입
      </button> -->

      <router-link
        to="manage_page"
        type="button"
        class="btn"
        style="background-color: #ffffff; border-radius: 20px"
        v-show="SYSTEMChecked"
        >관리자</router-link
      >
      <!-- <a
        href="/test_page"
        type="button"
        class="btn"
        style="background-color: #ffffff; border-radius: 20px"
      >
        테스트
      </a> -->
      <a
        href="/manage_page"
        type="button"
        class="btn"
        style="background-color: #ffffff; border-radius: 20px"
      >
        임시 권한 페이지
      </a>
    </nav>

    <!-- <navContent></navContent> -->
    <br />
    <br />
    <br />
    <br />
    <h1 id="maintext">이런 공간이 있다면 어떨까요...</h1>
    <br />
    <br />
    <div id="subtext">
      ...학교 동아리, 게임 그룹, 세계 예술 감상 커뮤니티에 소속되어 유대감을
      느낄 수 있는 공간. 소중한 단짝 친구들과 어울릴 수 있는 우리만의 공간. 더
      쉽게, 매일 어울리고 이야기할 수 있는 그런 공간 말이에요.
    </div>
    <br />
    <br />
    <button
      type="button"
      class="btn"
      style="background-color: #ffffff; border-radius: 20px; font-size: 20px"
    >
      Windows용 다운로드
    </button>
    <button
      type="button"
      class="btn"
      style="
        background-color: #000000;
        border-radius: 20px;
        color: white;
        font-size: 20px;
      "
    >
      웹브라우저에서 Discord 열기
    </button>
  </div>
</template>

<script>
export default {
  name: "header-content",
  data() {
    return {
      user_name: "",
      KeyChecked: false,
      SYSTEMChecked: false,
    };
  },
  mounted() {
    this.KeyChecked = this.$cookies.isKey("auth");
    if (this.$cookies.isKey("auth") === true) {
      const user = this.$cookies.get("auth"); //eslint-disable-line no-unused-vars
      this.user_name = user.username;

      if (this.$cookies.get("auth") == "SYSTEM_ADMIN") {
        this.SYSTEMChecked = true;
      }
    }
  },
  methods: {
    login() {
      console.log("header-content login method 실행");
      // this.$("#login_page_link").Click(); //this가 없으면 빌드하는데 오류남. this.가 있으면 제이쿼리가 안먹힘...vue 사이에선 사용할 수 없는가범
      // this.$emit("loginClick"); //app.vue와 부모자식의 관계가 아님..
      this.$router.push("/login_page"); //router-view가 어느 컴포넌트에 있든지 간에 상관없이 표시되는 것 같음
    },
    signUp() {
      console.log("header-contetn sign up method 실행");
      this.$router.push("/signup_page");
    },
    logout() {
      //두번 실행되는 원인 찾기(F12창과 같이 뜨면 두번실행됨....ㅎㅎ)
      console.log("header-content logout method 실행");

      this.axios(
        {
          method: "post",
          url: "/api/logout",
          // data: loginData,
          // Headers: {
          //   "Context-Type": "multipart/form-data",
          // },
        },
        { withCredentials: true }
      )
        .then((response) => {
          console.log("response.data = ", response.data);

          if (response.status == 200) {
            console.log("Logout Success");

            //쿠키 삭제
            this.$cookies.remove("auth");
            //로그아웃 확인 경고창
            if (this.$cookies.isKey("auth") === false) {
              alert("Logout Success");
            }
            //홈화면으로 전환
            this.$router.go(0);
          } else {
            console.log("Logout Failed");
          }
        })
        .finally(() => {
          console.log("/api/logout 실행");
        });
    },
    LoadDownloadPage() {
      console.log("header-content LoadDownloadPage method 실행");

      this.axios(
        {
          method: "post",
          url: "/access/download_page",
        },
        { withCredentials: true }
      )
        .then((response) => {
          console.log("response.data = ", response.data);

          if (response.status == 200) {
            console.log("download_page access Success");

            //다운로트 페이지 화면 들어가기
            this.$router.push("/access/download_page");
          } else {
            console.log("download_page access failed");
          }
        })
        .finally(() => {
          console.log("/access/download_page 실행");
        });
    },
  },
};
</script>

<style>
.header_background {
  background-color: #5882fa; /*nav의 스타일 때문인지 백그라운드 컬러 적용안됨*/
  color: white;
  background-image: url("@/assets/image1.jpg");
  height: 500px;
  text-align: center;
}
#navtext {
  color: white;
  /* font-size: 25px; */
}
#maintext {
  color: white;
  font-weight: 600;
  font-size: 45px;
}
#subtext {
  width: 70%;
  margin-left: 15%;
  font-size: 25px;
}

@font-face {
  font-family: "Jalnan";
  src: url("../../assets/font/_Jalnan2TTF.ttf") format("truetype");
  font-weight: 400;
}
.header_background {
  font-family: "Jalnan";
}
</style>
