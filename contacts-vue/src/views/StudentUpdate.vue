<template>
	<div>
		<el-form :ref="form" :model="form" label-width="120px" :rules="rules" :inline="true" style="width:80%">

			<el-form-item label="学生姓名" prop="name">
				<el-input v-model="form.name" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="学生学号" prop="number" >
				<el-input v-model="form.number" style="width:160px" readOnly></el-input>
			</el-form-item>

			<el-form-item label="性别" prop="sex">
				<el-select v-model="form.sex" placeholder="请选择学生性别" style="width: 160px">
					<el-option label="男" value="男"></el-option>
					<el-option label="女" value="女"></el-option>
				</el-select>
			</el-form-item>

			<el-form-item label="年龄" prop="age">
				<el-input v-model="form.age" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="出生日期" prop="birthday">
				<el-col :span="11">
					<el-date-picker type="date" placeholder="选择日期" v-model="form.birthday" style="width: 160px" value-format="yyyy-MM-dd"></el-date-picker>
				</el-col>
			</el-form-item>

			<el-form-item label="手机号码" prop="tel">
				<el-input v-model="form.tel" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="家庭住址" prop="address">
				<el-input v-model="form.address" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="电子邮箱" prop="mail">
				<el-input v-model="form.mail" style="width:160px"></el-input>
			</el-form-item>

			<el-form-item label="专业" prop="major">
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
					name: '未访问后端',
					number: '',
					sex: '',
					age: '',
					birthday: '',
					tel: '',
					address: '',
					mail: '',
					major: '',
				},

				rules: {
					name: [{
						required: true,
						message: '学生姓名不能为空',
						trigger: 'blur'
					}],
					number: [{
						required: true,
						message: '学号不能为空',
						trigger: 'blur',
					}],
					sex: [{
						required: true,
						message: '性别不能为空',
						trigger: 'blur',
					}],
					age: [{
						required: true,
						message: '年龄不能为空',
						trigger: 'blur',
					}],
					birthday: [{
						required: true,
						message: '出生日期不能为空',
						trigger: 'blur',
					}],
					tel: [{
						required: true,
						message: '手机号码不能为空',
						trigger: 'blur',
					}],
					address: [{
						required: true,
						message: '家庭住址不能为空',
						trigger: 'blur',
					}],
					mail: [{
						required: true,
						message: '电子邮箱不能为空',
						trigger: 'blur',
					}],
					major: [{
						required: true,
						message: '专业不能为空',
						trigger: 'blur',
					}]
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
			onSubmit(formName) {
				const _this = this
				this.$refs[formName].validate((valid) => {
					if (valid) {
						axios.post('http://localhost:8181/student/update', _this.form).then(function(resp) {
							
							_this.$alert(resp.data, '消息', {
								confirmButtonText: '确定',
								callback: action => {
									_this.$router.push('/StudentManage')
								}
							})
							
						})
					}
				});
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			}

		},
		created() {
			const _this = this
			
			axios.get('http://localhost:8181/student/findById/' + this.$route.query.id).then(function(resp) {
				console.log(resp)
				_this.form = resp.data
			})
			// 	alert("this.id="+this.$route.query.id+";_this.id="+_this.$route.query.id)
			
			axios.get('http://localhost:8181/major/findAll').then(function(resp) {
				console.log(resp)
				_this.tableData = resp.data
			})
		}
	}
</script>
