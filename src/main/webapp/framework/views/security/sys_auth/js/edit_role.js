var sysRoleEdit={	
	editParam:"",
	editData:"",
	flag:""	,
	submitData:{},
	returnData:{}
};

//初始化
sysRoleEdit.init = function(){
	
	sysRoleEdit.dialogInit();	
};

//判断数据编辑类型
sysRoleEdit.dialogInit = function(){
	
	  sysRoleEdit.editData = parent.sysRoles.param["rowData"];
	  //console.log(sysRoleEdit.editData);
	  sysRoleEdit.flag = parent.sysRoles.param["flag"];	
	  
	  if(sysRoleEdit.flag == "edit"){//修改数据
		  sysRoleEdit.setTableData(sysRoleEdit.editData);
		  sysRoleEdit.getDialog();		  
	  }else if(sysRoleEdit.flag == "add"){//添加数据
		  sysRoleEdit.getDialog();
	  }else if(sysRoleEdit.flag == "del"){//删除数据
		  console.log(sysRoleEdit.flag);
		  sysRoleEdit.deleteChosedData(sysRoleEdit.editData.role_id);
		  parent.sysRoles.reloadDataGrid();
		  parent.sysRoles.showReturnData();
	  }
		 	  
};

//初始化数据编辑框
sysRoleEdit.getDialog = function(){
	$("#dal").dialog({
	  
  	  title:" 编辑角色",	    	  
  	  closable:false,
  	  iconCls:"icon-edit",	    	  
  	  buttons: [{
				text:'确定',
				iconCls:'icon-ok',
				handler:function(){
					//判断是编辑还是新增数据并获取，提交到后台，保存成功重新刷新表格，并显示成功提示
					sysRoleEdit.getDialogTabData();
					console.log(sysRoleEdit.submitData);
					if(sysRoleEdit.flag == "edit"){						
						sysRoleEdit.saveEditData();
						
					}else if(sysRoleEdit.flag == "add"){						
						sysRoleEdit.addNewData();						
					}
					
					parent.sysRoles.reloadDataGrid();
					$('#dal').dialog('close');
					window.parent.document.getElementById("roleiframe").style.display = "none";					
					parent.sysRoles.showReturnData(); 
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
			
					$('#dal').dialog('close');
					window.parent.document.getElementById("roleiframe").style.display = "none";					
				}
			}]	
    });
}

//获取上层选中要修改的数据，在编辑框中显示
sysRoleEdit.setTableData=function(data){	
	$("#role_id").textbox("setValue",data.role_id);
	$("#role_name").textbox("setValue",data.role_name);
	$("#role_desc").textbox("setValue",data.role_desc);
	$("#is_valid").combobox("setValue",data.is_valid);
	$("#is_admin").combobox("setValue",data.is_admin);
	$("#organizer_id").combobox("setValue",data.organizer_id);
	
}

//获取表格数据
sysRoleEdit.getDialogTabData = function(){
	sysRoleEdit.submitData = {};
	
	if(sysRoleEdit.flag == "edit")
	    sysRoleEdit.submitData.role_id = $("#role_id").textbox("getValue");			
		
	sysRoleEdit.submitData.role_name = $("#role_name").textbox("getValue");
	sysRoleEdit.submitData.role_desc = $("#role_desc").textbox("getValue");
	sysRoleEdit.submitData.is_valid = $("#is_valid").combobox("getText");	 
	sysRoleEdit.submitData.is_admin = $("#is_admin").combobox("getText");
	sysRoleEdit.submitData.organizer_id = $("#organizer_id").combobox("getText");
	
	
}

//提交编辑更新数据
sysRoleEdit.saveEditData = function(){		
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		contentType:"application/json;charset=utf-8",
		data: JSON.stringify(sysRoleEdit.submitData),
		url: top.Client.CONST_PATH + "/updateRoleById",
		success:function(data){		
			parent.sysRoles.returnData = data; //将修改返回的信息赋给变量		
		},
	    error:function(){
	    	parent.sysRoles.returnData = {"message":"操作失败"}
	    }
	});
};

//添加数据
sysRoleEdit.addNewData = function(){
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		contentType:"application/json;charset=utf-8",
		data: JSON.stringify(sysRoleEdit.submitData),
		url: top.Client.CONST_PATH + "/insertsysRoles",
		success:function(data){		
			parent.sysRoles.returnData = data; //		
		},
		error:function(){
	    	parent.sysRoles.returnData = {"message":"操作失败"}
	    }
	});
}

//删除数据
sysRoleEdit.deleteChosedData = function(role_id){
	
	console.log(role_id);
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		data: {role_id:role_id},
		url: top.Client.CONST_PATH +"/deleteRoleById",
		success:function(data){		
			parent.sysRoles.returnData = data; //		
		},
		error:function(){
	    	parent.sysRoles.returnData = {"message":"操作失败"}
	    }
	});
};