// @/router/index.js

import { createRouter, createWebHistory } from "vue-router";
// import HomeView from "../views/HomeView.vue";
import mainPage from "../main-page.vue";

const routes = [
{
path: "/",
name: "mainPage",
component: mainPage,
},
{
path: "/login_page",
name: "login",
component: () => import("../login-page.vue"),
children: [
{
path: "/signup_page_content",
name: "signupcontent",
component: () => import("../components/signup/signupForm-content.vue"),
meta: { transition: 'slide-left' },
},
{
path: "/login_page_content",
name: "logincontent",
component: () => import("../components/login/loginForm-content.vue"),
meta: { transition: 'slide-left' },
},
]
},
{
path: "/signup_page",
name: "signup",
component: () => import("../signup-page.vue"),
},

//페이지별 권한
{
path: "/access/download_page",
name: "download",
component: () => import("../components/nav/download-page.vue"),
},

//라우터 테스트
{
path: "/test_page",
name: "test",
component: () => import("../components/router-test/test.vue"),
},
{
path: "/router_test",
name: "testcontent",
component: () => import("../components/router-test/test2.vue"),
},
];

const router = createRouter({
history: createWebHistory(process.env.BASE_URL),
routes,
});

export default router;