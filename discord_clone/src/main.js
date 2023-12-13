
import { createApp } from 'vue';
import App from './App.vue';
import router from './routers'
import { library } from '@fortawesome/fontawesome-svg-core';
import VueQRCodeComponent from 'vue-qrcode-component';
import axios from 'axios';
import Vuex from 'vuex';
import VueCookies from "vue-cookies";

/* import specific icons  원하는 아이콘을 하나씩 import 해야함..*/
import { faDiscord } from '@fortawesome/free-brands-svg-icons';
/* import font awesome 컴포넌트 */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

/*부트스트랩*/
import BootstrapVue from 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css';

import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-alpine.css";
import { AgGridVue } from "ag-grid-vue3";

//컴포넌트 전역 등록
import navContent from './components/main/nav-content.vue';
import footerContent from './components/main/footer-content.vue'
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';

//bootstrap-vue 용
// import 'bootstrap/dist/css/bootstrap.min.css';
// import 'bootstrap-vue/dist/bootstrap-vue.css';
// import "@/fontAwesomeIcon.js";

const vue = createApp(App);

/*아이콘 하나씩 import해서 일일히 add해줘야 함*/
library.add(faDiscord);
library.add(faMagnifyingGlass);
vue.component('font-awesome-icon', FontAwesomeIcon);
vue.config.productionTip = false;

vue.component('VueDatePicker', VueDatePicker);

vue.component('qr-code', VueQRCodeComponent);


vue.use(BootstrapVue);

//https://luji.tistory.com/84  각 컴포넌트가 공유하는 상태 데이터는 전역에서 저장소(store)객체를 통해서 관리
const store = new Vuex.Store({
  state: {
        userId: '',
        userEmail: '',
        userName: '',
        token: ''
  },
  mutations: {
    login (payload) {
            this.userId = payload.userId
            this.userEmail = payload.userEmail
            this.userName = payload.userName
            this.token = payload.token
        },
  }
})


//router 전용으로 사용하는 건줄 알았는데 아니었음...
// import { useRouter } from "vue-router";
// const router1 = useRouter();
// vue.config.globalProperties.$router1 = router1;

//ag그리드
vue.component('AgGridVue', AgGridVue);
// vue.use(AgGridVue);

//axios 전역 설정
vue.config.globalProperties.axios   = axios;

vue.use(Vuex);
vue.use(store);
vue.use(router).mount('#app');

//쿠키 만료일은 7일
//https://kyounghwan01.github.io/blog/Vue/vue/vue-cookies/
vue.use(VueCookies);
// vue.$cookies.config("5m");

vue.component('navContent', navContent);
vue.component('footerContent', footerContent);