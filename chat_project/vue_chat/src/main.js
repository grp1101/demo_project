import { createApp } from 'vue';
import App from './App.vue';
import router from './routers'
import BootstrapVue from 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';

//fort-awesome
import { library } from '@fortawesome/fontawesome-svg-core'
import { faDiscord } from '@fortawesome/free-brands-svg-icons';
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons'
import { faUserPlus } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

const vue = createApp(App);

vue.use(BootstrapVue);
vue.use(router);

//전역설정
vue.config.globalProperties.axios=axios;

//font-awosome
library.add(faDiscord);
library.add(faMagnifyingGlass);
library.add(faUserPlus);
vue.component('font-awesome-icon', FontAwesomeIcon);
vue.config.productionTip = false;

vue.mount('#app');
