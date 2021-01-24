<template>
	<div>
		<el-form :ref="form" :model="form" label-width="120px" :inline="true" style="width:80%">

			<el-form-item label="学生姓名" >
				<el-input v-model="form.name" style="width:160px" ></el-input>
			</el-form-item>

			<el-form-item label="学生学号" >
				<el-input v-model="form.number" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="性别" >
				<el-select v-model="form.sex" placeholder="请选择学生性别" style="width: 160px">
					<el-option label="男" value="男"></el-option>
					<el-option label="女" value="女"></el-option>
				</el-select>
			</el-form-item>

			<el-form-item label="年龄">
				<el-input v-model="form.age" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="出生日期">
				<el-col :span="11">
					<el-date-picker type="date" placeholder="选择日期" v-model="form.birthday" style="width: 160px" value-format="yyyy-MM-dd"></el-date-picker>
				</el-col>
			</el-form-item>

			<el-form-item label="手机号码">
				<el-input v-model="form.tel" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="家庭住址" >
				<el-input v-model="form.address" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="电子邮箱">
				<el-input v-model="form.mail" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="专业" >
				<el-select v-model="form.major" placeholder="请选择学生专业" style="width: 160px">
					
					<el-option v-for="item in tableData" :label="item.name" :value="item.name" ></el-option>
					
				</el-select>
			</el-form-item>

			<el-form-item style="margin-left: 36%">
				<el-button type="primary" @click="onSubmit(form)">提交</el-button>
				<el-button @click="resetForm(form)">重置</el-button>
			</el-form-item>
		</el-form>

	</div>
</template>
<script>
	export default {
		data() {
			return {
				form: {
					id:null,
					name: null,
					number: null,
					sex: null,
					age: null,
					birthday: null,
					tel: null,
					address: null,
					mail: null,
					major: null,
				},
				fileList: [{
						id: 0,
						name: ''
					}
				
				],
				
				tableData: []	

			};

		},
		methods: {
			
			// onSubmit(formName) {
			// 	const _this = this
			// 	this.$refs[formName].validate((valid) => {
			// 		if (valid) {
			// 			axios.post('http://localhost:8181/student/search', _this.form).then(function(resp) {
			// 				console.log(resp)
							
			// 				 _this.$router.push({
			// 				   path: '/list',
			// 				   query: {
			// 				     data: resp.data
			// 				   },
							   
			// 				 })
			// 			})
			// 		}
			// 	});
			// },
			
			onSubmit(){
				this.$router.push({
					path:'/list',
					query:{
						data:this.form
					}
				})
			},
			
			resetForm(formName) {
				this.$refs[formName].resetFields();
			}
		
		},
		
		created() {
			const _this=this
			axios.get('http://localhost:8181/major/findAll').then(function(resp) {
				console.log(resp)
				_this.tableData = resp.data
			})
		}
		
	}
</script>
