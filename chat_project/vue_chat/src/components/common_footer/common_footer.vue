<template>
  <footer
    class="card-footer tab-card-header"
    style="position: absolute; bottom: 0; width: 100%"
  >
    <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
      <li class="nav-item">
        <div
          class="nav-link"
          id="one-tab"
          data-toggle="tab"
          role="tab"
          aria-controls="One"
          aria-selected="true"
        >
          <router-link to="friendsList">친구목록</router-link>
        </div>
      </li>
      <li class="nav-item">
        <div
          class="nav-link"
          id="two-tab"
          data-toggle="tab"
          role="tab"
          aria-controls="Two"
          aria-selected="false"
        >
          <router-link to="chatRoom">대화목록</router-link>
        </div>
      </li>
      <li class="nav-item">
        <div
          class="nav-link"
          id="three-tab"
          data-toggle="tab"
          role="tab"
          aria-controls="Three"
          aria-selected="false"
        >
          <router-link to="setting">친구설정</router-link>
        </div>
      </li>
      <li class="nav-item">
        <div
          class="nav-link"
          id="four-tab"
          data-toggle="tab"
          role="tab"
          aria-controls="Four"
          aria-selected="false"
        >
          <router-link to="setting">로그아웃</router-link>
        </div>
      </li>
    </ul>
  </footer>
</template>

<script>
export default {
  name: "common-footer-page",
  components: {},
};
</script>
