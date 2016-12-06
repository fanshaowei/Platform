var authEdit={	
	editParam:"",
	editData:""	
};

//初始化
authEdit.init = function(){
	
	authEdit.getDialog();	
};



//初始化数据编辑框
authEdit.getDialog = function(){
	authEdit.editData=parent.sysAuth.param["role_id"];
	//alert("选择id为："+authEdit.editData);
	authEdit.loadTree(authEdit.editData);
	
	$("#auth").dialog({
	  
  	  title:" 编辑角色权限 ",	    	  
  	  closable:false,
  	  iconCls:"icon-edit",	    	  
  	  buttons: [{
				text:'确定',
				iconCls:'icon-ok',
				handler:function(){
					//判断是编辑还是新增数据并获取，提交到后台，保存成功重新刷新表格，并显示成功提示
					
					authEdit.saveDialog(authEdit.editData);
					parent.sysAuth.reloadDataGrid(authEdit.editData);
					$('#auth').dialog('close');
					window.parent.document.getElementById("editAuthDiv").style.display = "none";					
					parent.sysAuth.showReturnData(); 
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){	
					$('#auth').dialog('close');
					window.parent.document.getElementById("editAuthDiv").style.display = "none";					
				}
			}]	
    });
}

authEdit.loadTree=function(role_id){
	
	$('#tt').tree({
		url:top.Client.CONST_PATH+'/getAllAuth',
		onLoadSuccess:function(){
			$.post(top.Client.CONST_PATH+'/getAuthIdById',
					{role_id: role_id},
					function(data){	
						for(var i=0;i<data.length;i++){	
								var node=$('#tt').tree('find',data[i]);	
								var childrenCount = $('#tt').tree('getChildren',node.target).length;
								if(childrenCount == 0)
								    $('#tt').tree('check', node.target);																
			
						}
					}
				)
			}
			
	});
	
	
}

authEdit.saveDialog=function(role_id){
	
	var array=new Array();
	var j=0;
	var arr=$("#tt").tree('getChecked');
	
	for(var i=0;i<arr.length;i++){
		if(arr[i].id!=1){
			var node=$("#tt").tree('getParent',arr[i].target);
			array[j++]=node.id;
			array[j++]=arr[i].id;
		}
	}
	
	 //去重函数
	  function unique(arr) {
		    var result = [], hash = {};
		    for (var i = 0, elem; (elem = arr[i]) != null; i++) {
		        if (!hash[elem]) {
		            result.push(elem);
		            hash[elem] = true;
		        }
		    }
		   return result;
	
	}
	array=unique(array);
	
	$.ajax({
		type:"POST",
		async:false,
		url:top.Client.CONST_PATH+'/deleteAuthRole',
		data:{role_id:role_id},
		//dataType:"jsonp",
		success: function(msg){
			$.ajax({
				type:"POST",
				async:false,
				url:top.Client.CONST_PATH+'/insertAuthRole',
				data:{
					role_id:role_id,
					array:array},
				//dataType:"jsonp",
				success: function(){
					parent.sysAuth.returnData = {"message":"操作成功"};
				   }
				
			});
		}		
	});
		
	
	console.log(parent.sysAuth.returnData);
}