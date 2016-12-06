var sysRoles={
		param : {}, //编辑参数
	    returnData : {}, //编辑数据后返回的信息 currentPage
	    queryParams:{
	    	
	    }
}
var sysAuth={
		param : {}, //编辑参数
	    returnData : {}, //编辑数据后返回的信息 currentPage
	    queryParams:{
	    	
	    }
}
var sysUsers={
		param:{},
		returnData:{},
		queryParams:{
			role_id : {},
			pageSize : 10,
	    	pageNumber : 1
		}
}


$(document).ready(function(){

	$("#role_list").datagrid({			    	
		url: top.Client.CONST_PATH + "/getSysRoles",	  
		//queryParams:sysRoles.queryParams,
		method:"post",
		singleSelect:true,
		fit:true,	
		rownumbers:true,
		columns:[[   
		          {field:'role_id',title:'角色ID',width:50},   
		          {field:'role_name',title:'角色名',width:100}/*,
		          {field:'role_desc',title:'角色描述',width:150},
		          {field:'is_valid',title:'是否生效',width:80},
		          {field:'is_admin',title:'是否管理员',width:80},
		          {field:'organizer_id',title:'组织ID',width:80}*/
		      ]],
        toolbar:[{
			iconCls: "icon-edit",
			text:"编辑",
			handler: function(){
				
				sysRoles.dataOption("edit");
			}
		},'-',{iconCls: "icon-add",
			   text:"添加",
			   handler: function(){
				   sysRoles.dataOption("add");
			   }
		},'-',{iconCls: "icon-no",
			   text:"删除",
			   handler: function(){
				   sysRoles.dataOption("del");
			   }
		}]
	});
	
	//sysRoles.getAuthUsers(1);
	
	
	$('#role_list').datagrid({
		onClickRow: function(rowIndex,rowData){

			sysRoles.getAuthUsers(rowData.role_id);
			
			sysUsers.dataGridPagin();
			}
	});
	
	
	sysRoles.reloadDataGrid();
	$('#east').resizable('disable');
	
});

	

sysRoles.getAuthUsers=function(role_id){

	
	$('#ulTool').datagrid({
		toolbar: [{
			iconCls: "icon-edit",
			text:"编辑角色权限",
			handler: function(){
				
				sysAuth.editAuth();
			}
		}]
	});


	/*$('#auth_list').tree({
		url:top.Client.CONST_PATH+'/getAuth'
		
	});	
	$('#auth_list').tree({
		onClick: function(node){
			  // alert node text property when clicked
			$.post(top.Client.CONST_PATH+'/getChildAuthById',
					{role_id:role_id,
				authority_id:node.id},
					function(data){
						
						var childNode=$('#auth_list').tree('getChildren',node.target);
						
						if(childNode==""){
							$('#auth_list').tree('append', {
								parent: node.target,
								data:data
							})
						}
					}
			);
			
		}
	});*/

	$.post(top.Client.CONST_PATH+'/getAllAuthByRoleId',
			{
				role_id:role_id,
				authority_id:1
			},
				function(data){
					//console.log(data);
					$('#auth_list').tree({
						data:data
					});
				}	
			);
	
	sysUsers.queryParams.role_id=role_id;		
	$("#users_list").datagrid({	    		
		url: top.Client.CONST_PATH + "/getUsersById",	  
		queryParams:sysUsers.queryParams,
		method:"post",
		singleSelect:true,
		fit:true,	
		rownumbers:true,
		pagination:true,
		pageSize:sysUsers.queryParams.pageSize,
		pageNumber:sysUsers.queryParams.pageNumber,
		columns:[[  
		          {field:'user_id',title:'用户id',width:100},   
		          /*{field:'user_name',title:'用户名',width:150},*/
		          {field:'user_account',title:'用户账户',width:150}
		          /*{field:'organizer_id',title:'组织ID',width:150}*/     
		      ]],
        toolbar:[{iconCls: "icon-add",
			   text:"添加角色用户",
			   handler: function(){
				   sysUsers.dataOption("add");
			   }
		 },'-',{iconCls: "icon-no",
			   text:"删除角色用户",
			   handler: function(){
				   sysUsers.dataOption("del");
			   }
		}]
	});
	


};


//表格数据分页
sysUsers.dataGridPagin=function(){
	var pager = $("#users_list").datagrid("getPager").pagination({
		showPageList:false,
		showRefresh:false,				
		onSelectPage:function(pageNumber,pageSize){
			
			sysUsers.queryParams.pageNumber = pageNumber;
			$("#users_list").datagrid("reload");
		}
	});
};

sysRoles.dataOption = function(flag){			
	var rowData = $('#role_list').datagrid('getSelected');		
	if(rowData == null && (flag == "del"||flag == "edit")){
		$.messager.confirm("提示","请选择一行数据再进行编辑");
		
		return false;
	}		    		
	
	sysRoles.param.rowData = rowData;//选中的表格数据
	sysRoles.param.flag = flag;
	
	var strParam = JSON.stringify(sysRoles.param);
	
	if(flag == "del"){
		 $.messager.confirm("提示 ","确定要删除选中的数据吗？会将关联关系全部删除",function(r){
	          if(!r) {	
	        	  
				  return false;
			  }else{
				  document.getElementById("roleiframe_edit").src= 
						top.Client.CONST_PATH + "/framework/views/security/sys_auth/edit_role.jsp";	
			  }         
		  });	
	}	
	if(flag == "add" || flag == "edit"){
		
		document.getElementById("roleiframe").style.display = "block";
		
		document.getElementById("roleiframe_edit").src= 
			top.Client.CONST_PATH + "/framework/views/security/sys_auth/edit_role.jsp";
	}
};
sysAuth.editAuth = function(){
	var rowData = $('#role_list').datagrid('getSelected');	
	sysAuth.param.role_id=rowData.role_id;
	document.getElementById("editAuthDiv").style.display = "block";
	
	document.getElementById("editAuth").src= 
		top.Client.CONST_PATH + "/framework/views/security/sys_auth/edit_auth.jsp";
}
sysUsers.dataOption=function(flag){
	
	sysUsers.param.flag = flag;
	var rowData = $('#role_list').datagrid('getSelected');
	sysUsers.param.role_id=rowData.role_id;
	if(flag=="add"){
		
		document.getElementById("editUsersDiv").style.display = "block";
		document.getElementById("editUsers").src= 
			top.Client.CONST_PATH + "/framework/views/security/sys_auth/edit_users.jsp";
	}else if(flag=="del"){
		var usersData = $('#users_list').datagrid('getSelected');	
		if(rowData == null){
			$.messager.confirm("提示","请选择一行数据再进行编辑");
			return false;
		}	
		$.messager.confirm("提示","确定要删除选中的数据吗？",function(r){
	          if(!r) {	
	        	  
				  return false;
			  }else{
				  sysUsers.param.usersData = usersData;
				  sysRoles.param.flag = "del";
				  
				  document.getElementById("editUsers").src= 
						top.Client.CONST_PATH + "/framework/views/security/sys_auth/edit_users.jsp";	
			  }
	          
		  });	
		return false;
	}
		
}

//重新刷新表格
sysRoles.reloadDataGrid = function(){
	$("#role_list").datagrid("reload");
}
sysRoles.showReturnData = function(){
	$.messager.alert("提示",this.returnData.message);
}

sysUsers.reloadDataGrid=function(){
	$("#users_list").datagrid("reload");
}
sysUsers.showReturnData=function(){
	$.messager.alert("提示",this.returnData.message);
}

sysAuth.reloadDataGrid = function(role_id){
	sysRoles.getAuthUsers(role_id);
}
sysAuth.showReturnData = function(){
	$.messager.alert("提示",this.returnData.message);
}