var usersEdit={
	 //编辑参数
	param: {},
    returnData : {}, //编辑数据后返回的信息 currentPage
    queryParams:{
    	role_id:0,
    	organizer_id : {},
    	pageSize : 10,
    	pageNumber : 1
    }
	
   
};

//初始化
usersEdit.init = function(){
	
	usersEdit.loadOrgTree();
	usersEdit.loadTable();
	
};

usersEdit.loadTable=function(){
	$("#org").tree({
		onSelect:function(node){
				usersEdit.initUsersDataGrid(node.id);
				$("#usersListGrid").datagrid("reload");
			
		}
	});
	
	
	$("#search_button").bind("click",function(){
		//$("#search").accordion('getSelected').panel('collapse');
		usersEdit.queryPage();
		
	});
};
//初始化组织架构
usersEdit.loadOrgTree=function(){
	$('#ulTool').datagrid({
		toolbar: [{
			iconCls: "icon-edit",
			text:"编辑",
			handler: function(){
				
				sysAuth.editAuth();
			}
		}]
	});
	$.post(top.Client.CONST_PATH+'/getAllOrg',{role_id:usersEdit.queryParams.role_id},
				function(data){
					$('#org').tree({
						data:data	
					});
				}	
			);
	$('#org').tree({
		onClick:function(node){
			if(node.state=="closed")
				$('#org').tree('expand',node.target);
			else
				$('#org').tree('collapse',node.target);			
		}
	});
}
	//初始化表格
usersEdit.initUsersDataGrid = function(organizer_id){
	usersEdit.queryParams.organizer_id=organizer_id;
	
	$("#usersListGrid").datagrid({
			    		
		url: top.Client.CONST_PATH + "/getAllUsersByOrg",	  
		queryParams:usersEdit.queryParams,
		method:"post",
		singleSelect:true,
		fit:true,	
		rownumbers:true,
		pagination:true,
		pageSize:usersEdit.queryParams.pageSize,
		pageNumber:usersEdit.queryParams.pageNumber,
		columns:[[   
		          {field:'user_id',title:'用户id',width:80},   
		          {field:'user_name',title:'用户名',width:100},
		          {field:'user_account',title:'用户账户',width:100},
		          {field:'organizer_id',title:'组织ID',width:80},

		      ]],
		      toolbar:[{
					iconCls: "icon-edit",
					text:"编辑",
					handler: function(){
						usersEdit.dataOption("edit");
					}
				},'-',{iconCls: "icon-add",
					   text:"添加",
					   handler: function(){
						   usersEdit.dataOption("add");
					   }
				},'-',{iconCls: "icon-no",
					   text:"删除",
					   handler: function(){
						   usersEdit.dataOption("del");
					   }
				}]
	});

	usersEdit.dataGridPagin();	
};

//表格数据分页
usersEdit.dataGridPagin=function(){
	var pager = $("#usersListGrid").datagrid("getPager").pagination({
		showPageList:false,
		showRefresh:false,				
		onSelectPage:function(pageNumber,pageSize){
			usersEdit.queryParams.pageNumber = pageNumber;
			usersEdit.queryPage();
		}
	});
};

//重新刷新表格
usersEdit.reloadDataGrid = function(){
	$("#usersListGrid").datagrid("reload");
}


//分页查询
usersEdit.queryPage = function(){		
	this.queryParams.user_id = $("#user_id").textbox("getValue");
	this.queryParams.user_name = $("#user_name").textbox("getValue");
	this.queryParams.user_account = $("#user_account").textbox("getValue");
	//console.log(this.queryParams);
	$("#usersListGrid").datagrid("reload");
	
};
usersEdit.dataOption=function(flag){
	var rowData = $('#usersListGrid').datagrid('getSelected');		
	if(rowData == null && (flag == "del"||flag == "edit")){
		$.messager.alert("提示","请选择一行数据再进行编辑");
		
		return false;
	}		    		
	
	usersEdit.param.rowData = rowData;//选中的表格数据
	usersEdit.param.flag = flag;
	
	var strParam = JSON.stringify(usersEdit.param);
	
	if(flag == "del"){
		 $.messager.confirm("提示","确定要删除选中的数据吗？",function(r){
	          if(!r) {	
				  return false;
			  }else{
				 
				  document.getElementById("editOrgUsers").src= 
						top.Client.CONST_PATH + "/framework/views/security/sys_org/edit_org_users.jsp";	
			  }
	          
		  });	
	}
	
	if(flag == "add" || flag == "edit"){
		
		document.getElementById("editOrgUsersDiv").style.display = "block";
		
		document.getElementById("editOrgUsers").src= 
			top.Client.CONST_PATH + "/framework/views/security/sys_org/edit_org_users.jsp";
		

	}
}
usersEdit.showReturnData=function(){
	$.messager.alert("提示",this.returnData.message);
}

