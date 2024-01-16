import { createApp } from 'vue';
import App from './App.vue';
import router from './routers'
import BootstrapVue from 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';


const vue = createApp(App);

vue.use(BootstrapVue);
vue.use(router);

//전역설정
vue.config.globalProperties.axios=axios;

vue.use(SocketPlugin);

vue.mount('#app');
