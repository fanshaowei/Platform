<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户管理</title>
	<%@include file="/../../../common/common.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/framework/views/security/sys_org/js/sys_org.js"></script>
	<style type="text/css">	
	    html,body{
	        width:100%;
	        height:100%;
	    } 
        
        #editOrgUsersDiv{
        	width: 100%;
			height: 100%;
			position: absolute;
			display: none;
			z-index:40;	
        }
        .editOrgUsers{
        	width: 100%;
			height: 100%;
        }
        
	</style>
	<script type="text/javascript">
	  
	  $(function(){
		  //$("#search").accordion('getSelected').panel('collapse');
		  usersEdit.init();    		    	
	  });
	</script>
</head>
<body>

	<div id="cc" class="easyui-layout" style="width:100%;height:90%;margin-top: 8px;">  

	   	<div  id="east" data-options="region:'east',split:false" style="padding:5px;width:40%" >		
        
    	</div>
    	
	    <div data-options="region:'west',split:false" style="padding:5px;width: 23%">
			<div class="easyui-panel" title="组织架构" data-options="fit:true,border:false">  
	       			<table id="ulTool" border="0"></table>
	       			<br/>
		          <ul id="org" class="easyui-tree" ></ul>
		    </div>
		</div>
	    
	    <div id="userList" data-options="region:'center'" style="padding:5px;background:#eee">
	    	<div class="easyui-panel" title="用户列表" data-options="fit:true,border:false"> 
		    	<div title="用户管理" style="padding:0px;" 
				data-options="closable:true" style="height: 90%;">
					 
					<div class="easyui-accordion" id="search" style="margin-bottom: 1px;width:100%" >
						<div title="查询"  data-options="iconCls:'icon-search'" >
							<table id="searchTab" style="margin: 1px 0;">
								<tr>
									<td>用户id:<input id="user_id"
										class="easyui-textbox" style="width: 30px; height: 22px;"></td>
									<td>用户名:<input id="user_name"
										class="easyui-textbox" style="width: 70px; height: 22px;"></td>
									<td>用户账户:<input id="user_account"
										class="easyui-textbox" style="width: 70px; height: 22px;"></td>
									<td>&nbsp;<a id="search_button"
										class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a></td>
								</tr>
							</table>
						</div>
					</div>
					<div style="height: 85%; width: 100%; position: absolute;">
						<table id="usersListGrid" style="height: 100%; width: 100%;">
							
						</table>
					</div>	
						
				</div>
			</div>
	    </div>
	    <div id="editOrgUsersDiv">
			<iframe id="editOrgUsers" class="editOrgUsers" scrolling="no"
				marginwidth="0" marginheight="0" frameborder="0">	
			</iframe> 
		</div>
	</div>
	
		
</body>
</html>