<template>
  <div>
    <section style="background-color: white">
      <div class="container py-5">
        <div class="row d-flex justify-content-center">
          <div class="col-md-8 col-lg-6 col-xl-4">
            <div class="card" id="chat1" style="border-radius: 15px">
              <!-- header -->
              <div
                class="card-header d-flex justify-content-between align-items-center p-3 text-black border-bottom-0"
                style="
                  border-top-left-radius: 15px;
                  border-top-right-radius: 15px;
                "
              >
                <!-- 뒤로가기 아이콘 -->
                <i class="fas fa-angle-left"></i>
                <p class="mb-0 fw-bold">Live chat</p>
                <!-- 닫기 아이콘 -->
                <i class="fas fa-times"></i>
              </div>
              <!-- 채팅내용 -->
              <div class="card-body">
                <div class="d-flex flex-row justify-content-start mb-4">
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                    alt="avatar 1"
                    style="width: 45px; height: 100%"
                  />
                  <div
                    class="p-3 ms-3"
                    style="
                      border-radius: 15px;
                      background-color: rgba(57, 192, 237, 0.2);
                    "
                  >
                    <p class="small mb-0">
                      Hello and thank you for visiting MDBootstrap. Please click
                      the video below.
                    </p>
                  </div>
                </div>

                <div class="d-flex flex-row justify-content-end mb-4">
                  <div
                    class="p-3 me-3 border"
                    style="border-radius: 15px; background-color: #fbfbfb"
                  >
                    <p class="small mb-0">
                      Thank you, I really like your product.
                    </p>
                  </div>
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                    alt="avatar 1"
                    style="width: 45px; height: 100%"
                  />
                </div>

                <div class="d-flex flex-row justify-content-start mb-4">
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                    alt="avatar 1"
                    style="width: 45px; height: 100%"
                  />
                  <div class="ms-3" style="border-radius: 15px">
                    <div class="bg-image">
                      <img
                        src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/screenshot1.webp"
                        style="border-radius: 15px"
                        alt="video"
                      />
                      <a href="#!">
                        <div class="mask"></div>
                      </a>
                    </div>
                  </div>
                </div>

                <div class="d-flex flex-row justify-content-start mb-4">
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                    alt="avatar 1"
                    style="width: 45px; height: 100%"
                  />
                  <div
                    class="p-3 ms-3"
                    style="
                      border-radius: 15px;
                      background-color: rgba(57, 192, 237, 0.2);
                    "
                  >
                    <p class="small mb-0">...</p>
                  </div>
                </div>

                <div class="form-outline">
                  <textarea
                    class="form-control"
                    v-bind="send_message"
                    rows="4"
                  ></textarea>
                  <label class="form-label" for="textAreaExample"
                    >Type your message</label
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
export default {
  name: "chat_content",
  data() {
    return {
      send_message: "",
    };
  },
};
</script>
