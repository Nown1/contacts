import Vue from 'vue'
import VueRouter from 'vue-router'
import StudentManage from '../views/StudentManage'
import AddStudent from '../views/AddStudent'
import Index from '../views/Index'
import StudentUpdate from '../views/StudentUpdate'
import StudentSearch from '../views/StudentSearch.vue'
import List from '../views/List.vue'
import Dustbin from '../views/Dustbin.vue'
import Fuzzy from '../views/Fuzzy.vue'
 
Vue.use(VueRouter)

const routes = [
	{
		path: "/",
		name: "通信录",
		component: Index,
		redirect: "/StudentManage",
	},
	{
		path: "/StudentManage",
		name: "信息查询",
		component: StudentManage
	},
	{
		path: "/AddStudent",
		name: "添加信息",
		component: AddStudent
	},
	{
		path: "/StudentSearch",
		name: "查找",
		component: StudentSearch
	},
	{
		path: '/update',
		component: StudentUpdate
	},
	{
		path: '/list',
		component: List
	},
	{
		path:'/dustbin',
		component:Dustbin
	},
	{
		path:'/Fuzzy',
		component:Fuzzy
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})



export default router
