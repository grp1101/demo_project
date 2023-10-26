<template>
  <div class="signupForm_content_background">
    <div class="text-center"><h3>계정 만들기</h3></div>
    <div id="signupForm_content_detail_style">
      <form>
        <!-- Email input -->
        <div class="form-outline mb-4">
          <label class="form-label" for="email">email</label>
          <input type="text" v-model="email" class="form-control" />
        </div>
        <!-- username input -->
        <div class="form-outline mb-4">
          <label class="form-label" for="username">name</label>
          <input type="text" v-model="username" class="form-control" />
        </div>
        <!-- id input -->
        <div class="form-outline mb-4">
          <label class="form-label" for="id">id</label>
          <input type="text" v-model="id" class="form-control" />
        </div>
        <!-- Password input -->
        <div class="form-outline mb-4">
          <label class="form-label" for="password">password</label>
          <input type="password" v-model="password" class="form-control" />
        </div>
        <!-- address input -->
        <!-- <div class="form-outline mb-4">
          <label class="form-label" for="address">address</label>
          <input type="text" v-model="address" class="form-control" />
        </div> -->
        <!-- phone input -->
        <!-- <div class="form-outline mb-4">
          <label class="form-label" for="phone">phone</label>
          <input type="text" v-model="phone" class="form-control" />
        </div> -->
        <!-- website input -->
        <!-- <div class="form-outline mb-4">
          <label class="form-label" for="website">website</label>
          <input type="text" v-model="website" class="form-control" />
        </div> -->
        <!-- company input -->
        <!-- <div class="form-outline mb-4">
          <label class="form-label" for="company">company</label>
          <input type="text" v-model="company" class="form-control" />
        </div> -->

        <!-- Submit button -->
        <button
          type="button"
          class="btn btn-primary btn-block mb-4"
          v-on:click="sign_up_input()"
        >
          계속하기
        </button>
      </form>

      <p><a href="/login_page_content">이미 계정이 있으신가요?</a></p>
    </div>
  </div>
</template>

<script>
export default {
  name: "signUp",
  components: {},
  data() {
    return {
      id: "",
      username: "",
      email: "",
      password: "",
      address: "",
      phone: "",
      website: "",
      company: "",
    };
  },
  methods: {
    sign_up_input() {
      if (this.username == "" || this.email == "" || this.password == "") {
        alert("필수항목을 입력하세요");
        return;
      }

      // api용 post 함수
      this.axios(
        {
          method: "post",
          url: "/api/signup",
          data: {
            id: this.id,
            username: this.username,
            email: this.email,
            password: this.password,
            address: this.address,
            phone: this.phone,
            website: this.website,
            company: this.company,
          },
        },
        { withCredentials: true }
      )
        .then((response) => {
          console.log("response.data = ", response.data);

          //api_ver1
          if (response.data.result == 1) {
            alert(response.data.username + "님 회원가입에 성공하셨습니다.");
            this.$router.push("/login_page");
          } else {
            alert("회원가입에 실패하셨습니다.");
          }
        })
        .catch((err) => alert(err))
        .finally(() => {
          console.log("/api/signup 실행");
        });
    },
  },
};
</script>

<style>
.signupForm_content_background {
  /* https://hianna.tistory.com/675 가운데로 보내는 방법 */
  background-color: #33393a;
  width: 30%;
  margin-left: 35%;
  padding-top: 2%;
  height: 80%;
  font-size: 15px;
  color: #7e8f93;
  /* align-items: center; */
}
#signupForm_content_detail_style {
  width: 400px;
  margin-left: 5%;
  margin-right: 5%;
  float: left;
}
h3 {
  color: white;
}
</style>
