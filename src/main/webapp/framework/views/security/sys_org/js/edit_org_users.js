var sysOrgUsersEdit={	
	organizer_id:"",
	editParam:"",
	editData:"",
	flag:""	,
	submitData:{},
	returnData:{}
};

//初始化
sysOrgUsersEdit.init = function(){
	
	sysOrgUsersEdit.dialogInit();	
};

//判断数据编辑类型
sysOrgUsersEdit.dialogInit = function(){
	
	sysOrgUsersEdit.editData = parent.usersEdit.param["rowData"];
	//console.log(sysOrgUsersEdit.editData);
	sysOrgUsersEdit.flag = parent.usersEdit.param["flag"];	
  
		if(sysOrgUsersEdit.flag == "edit"){//修改数据
		sysOrgUsersEdit.setTableData(sysOrgUsersEdit.editData);
		sysOrgUsersEdit.getDialog();		  
	}else if(sysOrgUsersEdit.flag == "add"){//添加数据
	  	sysOrgUsersEdit.getDialog();
	}else if(sysOrgUsersEdit.flag == "del"){//删除数据
	  	sysOrgUsersEdit.deleteChosedData();
	  	parent.usersEdit.reloadDataGrid();
	  	parent.usersEdit.showReturnData();
	}
		 	  
};

//初始化数据编辑框
sysOrgUsersEdit.getDialog = function(){
	$("#org_users").dialog({
	  
  	  title:" 编 辑 ",	    	  
  	  closable:false,
  	  iconCls:"icon-edit",	    	  
  	  buttons: [{
				text:'确定',
				iconCls:'icon-ok',
				handler:function(){
					//判断是编辑还是新增数据并获取，提交到后台，保存成功重新刷新表格，并显示成功提示
					sysOrgUsersEdit.getDialogTabData();
					if(sysOrgUsersEdit.flag == "edit"){						
						sysOrgUsersEdit.saveEditData();
						
					}else if(sysOrgUsersEdit.flag == "add"){						
						sysOrgUsersEdit.addNewData();						
					}
					
					parent.usersEdit.reloadDataGrid();
					$('#org_users').dialog('close');
					window.parent.document.getElementById("editOrgUsersDiv").style.display = "none";					
					parent.usersEdit.showReturnData(); 
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
			
					$('#org_users').dialog('close');
					window.parent.document.getElementById("editOrgUsersDiv").style.display = "none";					
				}
			}]	
    });
}

//获取上层选中要修改的数据，在编辑框中显示
sysOrgUsersEdit.setTableData=function(data){	
	$("#user_id").textbox("setValue",data.user_id);
	$("#user_name").textbox("setValue",data.user_name);
	$("#user_account").textbox("setValue",data.user_account);
	$("#is_valid").combobox("setValue",data.is_valid);
	$("#is_admin").combobox("setValue",data.is_admin);
	$("#organizer_id").combobox("setValue",data.organizer_id);
	$("#mobile_number").textbox("setValue",data.mobile_number);
	$("#phone_number").textbox("setValue",data.phone_number);
}

//获取表格数据
sysOrgUsersEdit.getDialogTabData = function(){
	
	if(sysOrgUsersEdit.flag == "edit")
	    sysOrgUsersEdit.submitData.user_id = $("#user_id").textbox("getValue");			
		
	sysOrgUsersEdit.submitData.user_name = $("#user_name").textbox("getValue");
	sysOrgUsersEdit.submitData.user_account = $("#user_account").textbox("getValue");
	sysOrgUsersEdit.submitData.is_valid = $("#is_valid").combobox("getText");	 
	sysOrgUsersEdit.submitData.is_admin = $("#is_admin").combobox("getText");
	sysOrgUsersEdit.submitData.organizer_id = $("#organizer_id").combobox("getText");
	sysOrgUsersEdit.submitData.mobile_number = $("#mobile_number").textbox("getValue");
	sysOrgUsersEdit.submitData.phone_number = $("#phone_number").textbox("getValue");
	
}

//提交编辑更新数据
sysOrgUsersEdit.saveEditData = function(){
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		contentType:"application/json;charset=utf-8",
		data: JSON.stringify(sysOrgUsersEdit.submitData),
		url: top.Client.CONST_PATH + "/updateOrgUsersById",
		success:function(data){		
			parent.usersEdit.returnData = data ;//将修改返回的信息赋给变量		
		},
	    error:function(){
	    	parent.usersEdit.returnData = {"message":"操作失败"};
	    }
	});
};

//添加数据
sysOrgUsersEdit.addNewData = function(){
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		contentType:"application/json;charset=utf-8",
		data: JSON.stringify(sysOrgUsersEdit.submitData),
		url: top.Client.CONST_PATH + "/insertOrgUsers",
		success:function(data){		
			parent.usersEdit.returnData = data; //		
		},
		error:function(){
	    	parent.usersEdit.returnData = {"message":"操作失败"}
	    }
	});
}

//删除数据
sysOrgUsersEdit.deleteChosedData = function(){
	
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		data:{user_id:parent.usersEdit.param.rowData.user_id},
		url: top.Client.CONST_PATH +"/deleteOrgUsersById",
		success:function(data){		
			parent.usersEdit.returnData = data; //		
		},
		error:function(){
	    	parent.usersEdit.returnData = {"message":"操作失败"}
	    }
	});
};