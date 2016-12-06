<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户管理</title>
	<%@include file="/../../../common/common.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/framework/views/security/sys_auth/js/edit_users.js"></script>
	<style type="text/css">	
	    html,body{
	        width:100%;
	        height:100%;
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
	
<div id=users>
	<div class="easyui-accordion" id="search" style="margin-bottom: 1px;width:100%" >
		<div title="查询"  data-options="iconCls:'icon-search'" >
			<table id="searchTab" style="margin: 1px 0;">
				<tr>
					<td>用户id:<input id="user_id"
						class="easyui-textbox" style="width: 30px; height: 22px;"></td>
					<!-- <td>用户名:<input id="user_name"
						class="easyui-textbox" style="width: 70px; height: 22px;"></td> -->
					<td>组织ID:<input id="organizer_id"
						class="easyui-textbox" style="width: 30px; height: 22px;"></td>
						<td>&nbsp;<a id="search_button"
							class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a></td>
					</tr>
				</table>
			</div>
		
	</div>
	
	<ul id="org" class="easyui-tree" checkbox="true" onlyLeafCheck="true"></ul>
		
		
</div>
	       
    
	
	
	
		
</body>
</html>