// @/router/index.js
import { createRouter, createWebHistory } from "vue-router";
// import HomeView from "../views/HomeView.vue";
import App from "../App.vue";

const routes = [
{
path: "/",
name: "App",
component: App,
},
//로그인 페이지 요청
{
path: "/login_page",
name: "login_page",
component: () => import("../components/content/login_content.vue"),
},
// {
// path: "/login_page2",
// name: "login",
// component: () => import("../login-page.vue"),
// children: [
// {
// path: "/signup_page_content",
// name: "signupcontent",
// component: () => import("../components/signup/signupForm-content.vue"),
// meta: { transition: 'slide-left' },
// },
// {
// path: "/login_page_content",
// name: "logincontent",
// component: () => import("../components/login/loginForm-content.vue"),
// meta: { transition: 'slide-left' },
// },
// ]
// },
];

const router = createRouter({
history: createWebHistory(process.env.BASE_URL),
routes,
});

export default router;