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
    <div class="row">
      <ul class="list-unstyled mb-0">
        <li
          class="p-2 border-bottom"
          v-for="(friend, index) in friends"
          v-bind:key="index"
        >
          <div class="d-flex flex-row">
            <img
              src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg"
              alt="avatar"
              class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
              width="60"
            />
            <div class="pt-1">
              <p class="fw-bold mb-0">{{ friend.username }}</p>
            </div>
            <div class="pt-3 float-right">
              <span v-on:click="friend_add(friend.user_seq)"
                ><font-awesome-icon icon="user-plus"
              /></span>
            </div>
          </div>
        </li>
      </ul>
      <!-- <ul class="list-unstyled mb-0">
        <li class="p-2 border-bottom">
          <div class="d-flex flex-row">
            <img
              src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-1.webp"
              alt="avatar"
              class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
              width="60"
            />
            <div class="pt-1">
              <p class="fw-bold mb-0"></p>
            </div>
          </div>
        </li>
        <li class="p-2 border-bottom">
          <div class="d-flex flex-row">
            <img
              src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-3.webp"
              alt="avatar"
              class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
              width="60"
            />
            <div class="pt-1">
              <p class="fw-bold mb-0">Ashley Olsen</p>
            </div>
          </div>
        </li>
      </ul> -->
    </div>
  </div>
</template>
<script>
export default {
  name: "setting_content",
  data() {
    return {
      email: "",
      // friends: [{ username: "Danny Smith" }, { username: "Ashley Olsen" }],
      friends: [],
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
    friend_add() {
      this.axios(
        {
          method: "post",
          url: "api/setting/friend_add",
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
          console.log("api/setting/friend_add 응답");
          console.log("response.data = ", response.data);

          if (response.data != null) {
            alert("search successed.");
            this.friends = response.data;

            console.log("friends = ", this.friends);
          } else {
            alert("검색된 내역이 없습니다");
          }
        })
        .finally(() => {
          console.log("api/setting/friend_add 실행");
        });
    },
  },
};
</script>
