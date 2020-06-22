/* eslint-disable prettier/prettier */
import Vue from "vue";
import VueRouter from "vue-router";

import LogIn from "../views/LogIn.vue";
import FileSubmit from "../views/FileSubmit.vue";
import BillView from "../views/BillView.vue";
import AdminView from "../views/AdminView.vue";
import DepartBill from "../views/DepartBill.vue";

Vue.use(VueRouter);

const routes = [{
        path: "/",
        name: "VerifyLogin",
        component: LogIn
    },
    {
        path: "/file/:id",
        name: "FileSubmit",
        component: FileSubmit
    },
    {
        path: "/billview/:id",
        name: "BillView",
        component: BillView
    },
    {
        path: "/adminview/:departid",
        name: "AdminView",
        component: AdminView
    },
    {
        path: "/departlog/:id",
        name: "DepartBill",
        component: DepartBill
    }
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

export default router;