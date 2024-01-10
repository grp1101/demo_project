<template>
  <div id="container">
    <div id="loginBox">
      <div id="loginBoxTitle">Login</div>
      <div id="inputBox">
        <div class="input-form-box">
          <span>아이디 </span
          ><input type="text" name="uid" class="form-control" />
        </div>
        <div class="input-form-box">
          <span>비밀번호 </span
          ><input type="password" name="upw" class="form-control" />
        </div>
        <div class="button-login-box">
          <button
            type="button"
            class="btn btn-primary btn-xs"
            style="width: 100%"
          >
            로그인
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "login_content",
  components: {},
};
</script>
