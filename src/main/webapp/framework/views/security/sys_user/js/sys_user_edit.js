var sysUserEdit={	
	editParam:"",
	editData:"",
	flag:""	,
	submitData:{},
	returnData:{}
};

//初始化
sysUserEdit.init = function(){
	sysUserEdit.dialogInit();	
};

//判断数据编辑类型
sysUserEdit.dialogInit = function(){
	  sysUserEdit.editData = parent.sysUser.param["rowData"];
	  sysUserEdit.flag = parent.sysUser.param["flag"];	  	 	 	  	 
	  
	  if(sysUserEdit.flag == "edit"){//修改数据		
		  sysUserEdit.setTableData(sysUserEdit.editData);
		  sysUserEdit.getDialog();		  
	  }else if(sysUserEdit.flag == "add"){//添加数据
		  sysUserEdit.getDialog();
	  }else if(sysUserEdit.flag == "del"){//删除数据
		  sysUserEdit.deleteChosedData();
		  parent.sysUser.reloadDataGrid();
		  parent.sysUser.showReturnData();
	  }
		 	  
};

//初始化数据编辑框
sysUserEdit.getDialog = function(){
	$("#dal").dialog({
  	  title:" 编 辑 ",	    	  
  	  closable:false,
  	  iconCls:"icon-edit",	    	  
  	  buttons: [{
				text:'确定',
				iconCls:'icon-ok',
				handler:function(){
					//判断是编辑还是新增数据并获取，提交到后台，保存成功重新刷新表格，并显示成功提示
					sysUserEdit.getDialogTabData();
					
					if(sysUserEdit.flag == "edit"){						
						sysUserEdit.saveEditData();												
					}else if(sysUserEdit.flag == "add"){						
						sysUserEdit.addNewData();						
					}
					
					parent.sysUser.reloadDataGrid();
					$('#dal').dialog('close');
					window.parent.document.getElementById("diviframe").style.display = "none";					
					parent.sysUser.showReturnData(); 
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
					$('#dal').dialog('close');
					window.parent.document.getElementById("diviframe").style.display = "none";					
				}
			}]	
    });
}

//获取上层选中要修改的数据，在编辑框中显示
sysUserEdit.setTableData=function(data){	
	$("#userId").textbox("setValue",data.userId);
	$("#userName").textbox("setValue",data.userName);
	$("#trueName").textbox("setValue",data.trueName);
	$("#role").combobox("setValue",data.role);	 
	$("#province").combobox("setValue",data.province);
	$("#city").combobox("setValue",data.city);
	$("#district").combobox("setValue",data.district);
	$("#neighborhood").combobox("setValue",data.neighborhood);
		
	if(data.enabled == "Y"){
		$("#enabled").attr("checked",true);	
	}else{
		$("#enabled").attr("checked",false);
	}	
}

//获取表格数据
sysUserEdit.getDialogTabData = function(){
	sysUserEdit.submitData = {};
	
	if(sysUserEdit.flag == "edit")
	    sysUserEdit.submitData.userId = $("#userId").textbox("getValue");			
		
	sysUserEdit.submitData.userName = $("#userName").textbox("getValue");
	sysUserEdit.submitData.trueName = $("#trueName").textbox("getValue");
	sysUserEdit.submitData.role = $("#role").combobox("getValue");	 
	sysUserEdit.submitData.province = $("#province").combobox("getValue");
	sysUserEdit.submitData.city = $("#city").combobox("getValue");
	sysUserEdit.submitData.district = $("#district").combobox("getValue");
	sysUserEdit.submitData.neighborhood = $("#neighborhood").combobox("getValue");
	
	if($("#enabled").is(':checked'))
	   sysUserEdit.submitData.enabled = "Y";
	else
	   sysUserEdit.submitData.enabled = "N";
}

//提交编辑更新数据
sysUserEdit.saveEditData = function(){		
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		contentType:"application/json;charset=utf-8",
		data: JSON.stringify(sysUserEdit.submitData),
		url: top.Client.CONST_PATH + "/sysUser/updateSysUserById",
		success:function(data){		
			parent.sysUser.returnData = data; //将修改返回的信息赋给变量		
		},
	    error:function(){
	    	parent.sysUser.returnData = {"messager":"操作失败"}
	    }
	});
};

//添加数据
sysUserEdit.addNewData = function(){
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		contentType:"application/json;charset=utf-8",
		data: JSON.stringify(sysUserEdit.submitData),
		url: top.Client.CONST_PATH + "/sysUser/insertSysUser",
		success:function(data){		
			parent.sysUser.returnData = data; //		
		},
		error:function(){
	    	parent.sysUser.returnData = {"messager":"操作失败"}
	    }
	});
}

//删除数据
sysUserEdit.deleteChosedData = function(){
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		contentType:"application/json;charset=utf-8",
		data: JSON.stringify(sysUserEdit.editData),
		url: top.Client.CONST_PATH + "/sysUser/deleteSysUser",
		success:function(data){		
			parent.sysUser.returnData = data; //		
		},
		error:function(){
	    	parent.sysUser.returnData = {"messager":"操作失败"}
	    }
	});
};