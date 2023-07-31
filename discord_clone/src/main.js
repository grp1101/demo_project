
import { createApp } from 'vue';
import App from './App.vue';
import router from './routers'
import { library } from '@fortawesome/fontawesome-svg-core';
import VueQRCodeComponent from 'vue-qrcode-component'

/* import specific icons  원하는 아이콘을 하나씩 import 해야함..*/
import { faDiscord } from '@fortawesome/free-brands-svg-icons';
/* import font awesome 컴포넌트 */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

/*부트스트랩*/
import BootstrapVue from 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

//bootstrap-vue 용
// import 'bootstrap/dist/css/bootstrap.min.css';
// import 'bootstrap-vue/dist/bootstrap-vue.css';
// import "@/fontAwesomeIcon.js";

const vue = createApp(App);

/*아이콘 하나씩 import해서 일일히 add해줘야 함*/
library.add(faDiscord);
vue.component('font-awesome-icon', FontAwesomeIcon);
vue.config.productionTip = false;

vue.component('qr-code', VueQRCodeComponent);


vue.use(BootstrapVue);

//router 전용으로 사용하는 건줄 알았는데 아니었음...
// import { useRouter } from "vue-router";
// const router1 = useRouter();
// vue.config.globalProperties.$router1 = router1;

vue.use(router).mount('#app');





// const app =createApp(App);
// app.mount('#app');