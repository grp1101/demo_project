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
{
path: "/content",
name: "content",
component: () => import("../../content.vue"),
children: [
{
path: "/friendsList",
name: "friendsList",
component: () => import("../components/content/friendsList_content.vue"),
meta: { transition: 'slide-left' },
},
{
path: "/chatRoom",
name: "chatRoom",
component: () => import("../components/content/chatRoom_content.vue"),
meta: { transition: 'slide-left' },
},
{
path: "/chat",
name: "chat",
component: () => import("../components/content/chat_content.vue"),
meta: { transition: 'slide-left' },
},
{
path: "/setting",
name: "setting",
component: () => import("../components/content/setting_content.vue"),
meta: { transition: 'slide-left' },
},
]
},
];

const router = createRouter({
history: createWebHistory(process.env.BASE_URL),
routes,
});

export default router;