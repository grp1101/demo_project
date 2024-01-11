<template>
  <div class="container mt-5">
    <div class="row d-flex justify-content-center">
      <div class="col-md-6">
        <div class="card px-5 py-5" id="form1">
          <div class="form-data" v-if="!submitted">
            <div class="forms-inputs mb-4">
              <span>Email</span>
              <input
                autocomplete="off"
                type="text"
                v-model="email"
                v-bind:class="{ 'form-control': true }"
                v-on:blur="emailBlured = true"
              />
              <div class="invalid-feedback">A valid email is required!</div>
            </div>
            <div class="forms-inputs mb-4">
              <span>Password</span>
              <input
                autocomplete="off"
                type="password"
                v-model="password"
                v-bind:class="{ 'form-control': true }"
                v-on:blur="emailBlured = true"
              />
              <div class="invalid-feedback">Password must be 8 character!</div>
            </div>
            <div class="mb-3">
              <button
                v-on:click="login(email, password)"
                class="btn btn-dark w-100"
              >
                Login
              </button>
            </div>
          </div>
          <div class="success-data" v-else>
            <div class="text-center d-flex flex-column">
              <i class="bx bxs-badge-check"></i>
              <span class="text-center fs-1"
                >You have been logged in <br />
                Successfully</span
              >
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "login_content",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  components: {},
  mounted() {
    console.log("loginForm_content mounted 실행됨");
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
            console.log("Login Successed");
            // this.$router.push("/");
          } else {
            alert("Login Failed");
          }
        })
        .finally(() => {
          console.log("/api/login 종료");
        });
    },
  },
};
</script>
