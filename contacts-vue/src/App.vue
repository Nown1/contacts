<template>
	<div id="app">
		<el-container style="height: 2000px; border: 1px solid #eee">

			<el-aside width="200px" style="background-color: rgb(238, 241, 246)">

				<el-menu router :default-openeds="['0']">
					<el-submenu index="0">
						<template slot="title"><i class="el-icon-notebook-1"></i>通信录</template>
						<el-menu-item index="StudentManage"><i class="el-icon-refresh"></i>信息查询</el-menu-item>
						<el-menu-item index="AddStudent"><i class="el-icon-edit"></i>添加信息</el-menu-item>
						<el-menu-item index="StudentSearch"><i class="el-icon-search"></i>查找</el-menu-item>
						<el-menu-item index="Fuzzy"><i class="el-icon-view"></i>模糊查询</el-menu-item>
						<el-menu-item index="Dustbin"><i class="el-icon-delete"></i>回收站</el-menu-item>
					</el-submenu>

					<el-submenu index="1">
						<template slot="title"><i class="el-icon-document"></i>文件</template>
						<el-menu-item @click="exportWord"><i class="el-icon-download"></i>下载文件</el-menu-item>
						<el-upload ref="upload" action :multiple="false" :auto-upload="false" :limit="1" :http-request="importWordConfirm">
							<el-button slot="trigger" size="small" type="primary" style="margin-bottom: 10px;" plain>选取文件</el-button>
							<el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload" plain>上传文件</el-button>
						</el-upload>
					</el-submenu>

					<el-submenu index="2">
						<template slot="title"><i class="el-icon-folder-opened"></i>分类</template>
						<el-menu-item v-for="item in majors" @click="jump(item.name)"><i class="el-icon-collection-tag"></i>{{item.name}}</el-menu-item>
					</el-submenu>

				</el-menu>

			</el-aside>

			<el-main>
				<router-view></router-view>
			</el-main>

		</el-container>
	</div>
</template>

<style>
	.el-header {
		background-color: #B3C0D1;
		color: #333;
		line-height: 60px;
	}

	.el-aside {
		color: #333;
	}
</style>

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
					}],
				majors:[]
			};
		},

		methods: {
			exportWord() {
				this.$axios.get('http://localhost:8181/file/download', {
					responseType: 'blob'
				}).then(res => {
					let blob = new Blob([res.data], {
						type: 'application/ms-excel;charset=utf-8'
					});
					let downloadElement = document.createElement('a');
					let href = window.URL.createObjectURL(blob); //创建下载的链接
					downloadElement.href = href;
					downloadElement.download = '学生信息.xlsx'; //下载后文件名
					document.body.appendChild(downloadElement);
					downloadElement.click(); //点击下载
					document.body.removeChild(downloadElement); //下载完成移除元素
					window.URL.revokeObjectURL(href); //释放掉blob对象
				})
			},

			submitUpload() {
				this.$refs.upload.submit();
			},
			importWordConfirm(item) {
				const _this=this;
				const fileObj = item.file
				const formData = new FormData()
				formData.append('file', fileObj)
				this.$axios.post('http://localhost:8181/file/upload/', formData, {
					headers: {
						'Content-Type': 'multipart/form-data'
					}
				}).then(res => {
					_this.$alert('上传成功！', '消息', {
					  confirmButtonText: '确定',
					  callback: action => {
					    _this.$router.push({
							path:"/StudentManage"
						})
					  }
					})
					
				})
			},
			
			jump(x){
				const _this=this;
				this.form.major=x
				this.$router.push({
						path:'/list',
						query:{
							data:_this.form
						}
					})
			}
			
		},
		
		created() {
			const _this = this
			axios.get('http://localhost:8181/major/findAll').then(function(resp) {
				console.log(resp)
				_this.majors = resp.data
			})
		}
	};
</script>
