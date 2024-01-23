<template>
  <div style="padding: 5%">
    <div class="input-group rounded">
      <input
        type="search"
        v-model="email"
        class="form-control rounded"
        placeholder="Search"
        aria-label="Search"
        aria-describedby="search-addon"
      />
      <span
        class="input-group-text border-0"
        id="search-addon"
        v-on:click="search()"
      >
        <font-awesome-icon icon="magnifying-glass" />
      </span>
    </div>
  </div>
</template>
<script>
export default {
  name: "setting_content",
  data() {
    return {
      email: "",
    };
  },
  methods: {
    search() {
      //formData형태로 시큐리티에 파라미터 넘기기
      // const loginData = new FormData();
      // loginData.append("email", this.email);

      this.axios(
        {
          method: "post",
          url: "api/setting/search",
          data: {
            email: this.email,
          },
          Headers: {
            "Context-Type": "multipart/form-data",
          },
        },
        { withCredentials: true }
      )
        .then((response) => {
          console.log("api/setting/search 응답");
          console.log("response.data = ", response.data);

          // if (response.data != null) {
          // } else {
          //   alert("검색된 내역이 없습니다");
          // }
        })
        .finally(() => {
          console.log("api/setting/search 실행");
        });
    },
  },
};
</script>
