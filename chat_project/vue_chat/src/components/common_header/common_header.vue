<template>
  <div class="header_background">
    <nav class="navbar navbar-expand-lg">
      <a class="navbar-brand" href="#" id="navtext"> </a>
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
          <li class="nav-item">
            <a class="nav-link" id="navtext">chat</a>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: "common-header-page",
  data() {
    return {};
  },
};
</script>
