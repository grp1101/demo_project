import { createApp } from 'vue';
import App from './App.vue';
import router from './routers'
import BootstrapVue from 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

const vue = createApp(App);

vue.use(BootstrapVue);
vue.use(router);

vue.mount('#app');
