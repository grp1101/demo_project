import { createApp } from 'vue';
import App from './parent-list.vue';
// import router from './routes'
import axios from 'axios';

const app =createApp(App);
// axios.defaults.baseURL='http://localhost:3000';

// 전역으로 사용하기 위한 설정
app.config.globalProperties.axios   = axios;
app.mount('#app');

// const promise = fetch("http://localhost:3000/movies")
// .then(response => console.log(response));


// createApp(App).mount('#app');

//git test용
//https://dololak.tistory.com/304
//add 할때 해당 경로까지 가야 add되면서 git status가 초록색 표시로 뜸