<template>
  <div>
    <el-table
        :data="tableData"
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
          <el-button @click="recover(scope.row)" type="primary" size="mini" >恢复</el-button>
		  <el-button @click="delete(scope.row)" type="danger" size="mini">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
        background
        layout="prev, pager, next"
        :page-size="pageSize"
        :total="total"
        @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  methods: {
    delete(row) {
      const _this = this
      axios.delete('http://localhost:8181/dustbin/deleteById/' + row.id).then(function (resp) {
        _this.$alert('删除成功！', '消息', {
          confirmButtonText: '确定',
          callback: action => {
            window.location.reload()
          }
        })
      })
    },

    recover(row) {
      const _this=this
	  axios.get('http://localhost:8181/dustbin/recover/' + row.id).then(function (resp) {
		  
	    if (resp.data == 'success') {
	    	_this.$alert('恢复成功！', '消息', {
	    		confirmButtonText: '确定',
	    		callback: action => {
	    			_this.$router.push('/StudentManage')
	    		}
	    	})
	    } else {
	    	alert('恢复失败！')
	    	return false;
	    }
		
	  })
    },

    page(currentPage) {
      const _this = this
      axios.get('http://localhost:8181/dustbin/findAll/' + (currentPage - 1) + '/10').then(function (resp) {
        console.log(resp)
        _this.tableData = resp.data.content
        _this.pageSize = resp.data.size
        _this.total = resp.data.totalElements
      })
    }
  },

  data() {
    return {
      pageSize: 0,
      total: 0,
      tableData: []
    }
  },

  created() {
    const _this = this
    axios.get('http://localhost:8181/dustbin/findAll/0/10').then(function (resp) {
      console.log(resp)
      _this.tableData = resp.data.content
      _this.pageSize = resp.data.size
      _this.total = resp.data.totalElements
    })
  }
}
</script>