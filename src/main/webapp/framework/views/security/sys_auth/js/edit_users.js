var usersEdit={
	 //编辑参数
    returnData : {}, //编辑数据后返回的信息 currentPage
    queryParams:{
    	role_id:{},
    	organizer_id : {},
    	pageSize : 10,
    	pageNumber : 1
    }
	
   
};

//初始化
usersEdit.init = function(){
	
	
	usersEdit.dialogInit();
	
};
usersEdit.dialogInit=function(){
	var flag=parent.sysUsers.param["flag"];
	
	if(flag=="add"){
		
		usersEdit.getDialog();
	}else if(flag=="del"){
		usersEdit.delUsers();
		parent.sysUsers.reloadDataGrid();
		parent.sysUsers.showReturnData();
	}
}
usersEdit.delUsers=function(){
	var delData=parent.sysUsers.param["usersData"];
	$.ajax({
		url: top.Client.CONST_PATH +"/deleteUsersById",
		type:"post",
		async:false,
		data: {
			role_id:parent.sysUsers.param["role_id"],
			user_id:delData.user_id
		},
		success:function(data){		
			parent.sysUsers.returnData = {"message":"操作成功"}; //		
		},
		error:function(){
	    	parent.sysUsers.returnData = {"message":"操作失败"}
	    }
	});
}

usersEdit.getDialog = function(){
	
	usersEdit.queryParams.role_id=parent.sysUsers.param["role_id"];
	
	usersEdit.loadOrgTree();
	
	$("#users").dialog({
	  
  	  title:"添加用户",
  	  width: 400,
  	  height:680,
  	  closable:false, 	
  	  iconCls:"icon-edit",	    	  
  	  buttons: [{
				text:'确定',
				iconCls:'icon-ok',
				handler:function(){
					//判断是编辑还是新增数据并获取，提交到后台，保存成功重新刷新表格，并显示成功提示
					
					usersEdit.addUsers();

					$('#usersEdit').dialog('close');
					window.parent.document.getElementById("editUsersDiv").style.display = "none";
					parent.sysUsers.reloadDataGrid();
					parent.sysUsers.showReturnData();
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){	
					$('#users').dialog('close');
					window.parent.document.getElementById("editUsersDiv").style.display = "none";					
				}
			}]	
    });
}

//初始化组织架构
usersEdit.loadOrgTree=function(){
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
	
	$('#searchTab').bind('click',function(){
		var organizer_id=$("#organizer_id").textbox("getValue");		
		var node=$("#org").tree("find",organizer_id);
		if(node!=null){
			$("#org").tree("expandTo",node.target);
			$("#org").tree("select",node.target);
			$('#org').tree('expand',node.target);
		}
		
		var user_id=$("#user_id").textbox("getValue");
		if(user_id!=""){
			var node=$("#org").tree("find",user_id+0+0);
			if(node!=null){
				$("#org").tree("expandTo",node.target);
				$("#org").tree("select",node.target);
			}else{
				$.messager.alert("Warning","用户已添加或没有该用户");
				$("#user_id").textbox("setValue","");
				
			}
		}
	});
}



usersEdit.addUsers=function(){
	
	var array=new Array();
	var j=0;
	var arr=$("#org").tree('getChecked');
	
	if(arr!=null){
		for(var i=0;i<arr.length;i++){
			array[j++]=arr[i].id;
		}

		$.ajax({
			type:"POST",
			async:false,
			url:top.Client.CONST_PATH+'/insertUsers',
			data:{
				role_id:usersEdit.queryParams.role_id,
				array:array},
			//dataType:"jsonp",
			success:function(){		
				parent.sysUsers.returnData = {"message":"操作成功"}; //		
			},
			error:function(){
		    	parent.sysUsers.returnData = {"message":"操作失败"}
		    }
			
		});
	}
	
		
}



