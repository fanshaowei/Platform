var sysUser={	
    param : {}, //编辑参数
    returnData : {}, //编辑数据后返回的信息 currentPage
    queryParams:{
    	pageSize : 10,
    	pageNumber : 1
    }
};

sysUser.init=function(){
	sysUser.initUserDataGrid();
	
	$("#search_button").bind("click",function(){
		sysUser.queryPage();
	});
};

//初始化表格
sysUser.initUserDataGrid = function(){
	$("#userListGrid").datagrid({
		width:"500",
		height:"600",	    		
		url: top.Client.CONST_PATH + "/sysUser/sysUserList",	  
		queryParams:sysUser.queryParams,
		method:"post",
		singleSelect:true,
		fit:true,	
		rownumbers:true,
		pagination:true,
		pageSize:sysUser.queryParams.pageSize,
		pageNumber:sysUser.queryParams.pageNumber,
		toolbar:[{
			iconCls: "icon-edit",
			text:"编辑",
			handler: function(){
				sysUser.dataOption("edit");
			}
		},'-',{iconCls: "icon-add",
			   text:"添加",
			   handler: function(){
				   sysUser.dataOption("add");
			   }
		},'-',{iconCls: "icon-no",
			   text:"删除",
			   handler: function(){
				   sysUser.dataOption("del");
			   }
		}],	 		
		onBeforeLoad:function(){
			//sysUser.dataGridPagin();
		}		
	});
	sysUser.dataGridPagin();	
};

//表格数据分页
sysUser.dataGridPagin=function(){
	var pager = $("#userListGrid").datagrid("getPager").pagination({
		showPageList:false,
		showRefresh:false,				
		onSelectPage:function(pageNumber,pageSize){
			sysUser.queryParams.pageNumber = pageNumber;
			sysUser.queryPage();
		}
	});
};

//编辑数据
sysUser.dataOption = function(flag){			
	var rowData = $('#userListGrid').datagrid('getSelected');		
	if(rowData == null && (flag == "del"||flag == "edit")){
		$.messager.confirm("提示","请选择一行数据再进行编辑");
		return false;
	}		    		
	
	sysUser.param.rowData = rowData;//选中的表格数据
	sysUser.param.flag = flag;
	var strParam = JSON.stringify(sysUser.param);
	
	if(flag == "del"){
		 $.messager.confirm("提示","确定要删除选中的数据吗？",function(r){
	          if(!r) {				 
				  return false;
			  }else{
				  document.getElementById("iframe_edit").src= 
						top.Client.CONST_PATH + "/framework/views/security/sys_user/sys_user_edit.jsp";	
			  }
		  });	
	}
	
	if(flag == "add" || flag == "edit"){
		document.getElementById("diviframe").style.display = "block";
		document.getElementById("iframe_edit").src= 
			top.Client.CONST_PATH + "/framework/views/security/sys_user/sys_user_edit.jsp";
	}
				
};

//重新刷新表格
sysUser.reloadDataGrid = function(){
	$("#userListGrid").datagrid("reload");
}

//显示提示信息
sysUser.showReturnData = function(){
	$.messager.alert("提示",this.returnData.message);
}

//分页查询
sysUser.queryPage = function(){		
	this.queryParams.userName = $("#userName").textbox("getValue");
	this.queryParams.trueName = $("#trueName").textbox("getValue");
	this.queryParams.province = $("#province").combobox("getValue");
	this.queryParams.city = $("#city").combobox("getValue");
	this.queryParams.district = $("#district").combobox("getValue");
	this.queryParams.neighborhood = $("#neighborhood").combobox("getValue");
	
	$("#userListGrid").datagrid("reload");
	
};
