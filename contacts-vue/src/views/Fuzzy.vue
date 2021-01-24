<template>
	<div>
		<div>
			<el-form :ref="forml" :model="forml" label-width="120px" :inline="true" style="width:80%">
				<el-form-item label="学生姓名" >
					<el-input v-model="forml.name" style="width:200px" placeholder="请输入关键字"></el-input>
				</el-form-item>
					<el-button type="primary" icon="el-icon-search" @click="queryStudents">搜索</el-button>
				<el-form-item>
					
				</el-form-item>
			</el-form>
		</div>
		<div >
			<el-table
			    :data="datas"
			    border
			    style="width: 100%">
			  <el-table-column
			      prop="id"
			      label="序号"
			      width="50">
			  </el-table-column>
			  <el-table-column
			      prop="number"
			      label="学号"
			      width="90">
			  </el-table-column>
			  <el-table-column
			      prop="name"
			      label="姓名"
			      width="90">
			  </el-table-column>
			
			
			  <el-table-column
			      prop="sex"
			      label="性别"
			      width="50">
			  </el-table-column>
			  <el-table-column
			      prop="age"
			      label="年龄"
			      width="50">
			  </el-table-column>
			  <el-table-column
			      prop="birthday"
			      label="出生日期"
			      width="100">
			  </el-table-column>
			  <el-table-column
			      prop="tel"
			      label="手机号"
			      width="140">
			  </el-table-column>
			  <el-table-column
			      prop="address"
			      label="家庭住址"
			      width="160">
			  </el-table-column>
			
			  <el-table-column
			      prop="mail"
			      label="邮箱"
			      width="180">
			  </el-table-column>
			
			  <el-table-column
			      prop="major"
			      label="专业"
			      width="180">
			  </el-table-column>
			
			  <el-table-column
			      fixed="right"
			      label="操作"
			      width="180">
			    <template slot-scope="scope">
			      <el-button @click="editStudent(scope.row)" type="primary" size="mini" >修改</el-button>
				  <el-button @click="deleteStudent(scope.row)" type="danger" size="mini">删除</el-button>
			    </template>
			  </el-table-column>
			</el-table>
		</div>
	</div>
	
	
</template>

<script>
	export default{
		methods:{
			deleteStudent(row) {
			  const _this = this
			  axios.delete('http://localhost:8181/student/deleteById/' + row.id).then(function (resp) {
				  
			    _this.$alert('删除成功！', '消息', {
			      confirmButtonText: '确定',
			      callback: action => {
			        window.location.reload()
			      }
			    })
				
			  })
			},
			
			editStudent(row) {
			  this.$router.push({
			    path: '/update',
			    query: {
			      id: row.id
			    }
			  })
			},
			
			queryStudents(){
				const _this=this
				axios.get('http://localhost:8181/student/findLike/'+_this.forml.name).then(function(resp){
					console.log(resp)
					_this.datas = resp.data
				})
			}
		},
		
		data(){
			return{
				forml:{
					name:''
				},
				datas:[]
			}
		}
	}
	
</script>

<style>
</style>
