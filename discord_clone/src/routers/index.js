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
path: "/login",
name: "login",
component: () => import("../login-page.vue"),
},
];

const router = createRouter({
history: createWebHistory(process.env.BASE_URL),
routes,
});

export default router;