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
path: "/about",
name: "about",
component: () => import("../views/AboutView.vue"),
},
{
path: "/login_page",
name: "login",
component: () => import("../login-page.vue"),
},
{
path: "/signup_page",
name: "signup",
component: () => import("../signup-page.vue"),
},
{
path: "/access/download_page",
name: "download",
component: () => import("../components/nav/download-page.vue"),
},
];

const router = createRouter({
history: createWebHistory(process.env.BASE_URL),
routes,
});

export default router;