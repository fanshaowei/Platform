<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用戶管理</title>
<%@include file="/../../../common/common.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/framework/views/security/sys_auth/js/auth_list.js"></script> 
	
<style type="text/css"> 
html, body {
	width: 100%;
	height: 100%;
	overflow:hidden;
}
/*  .l{
	float: left;
	width:1px;
	height:100%;
	background: #000;
}
div.left{
	float: left;
	margin-top:100px;
	width: 30%;
	height:100%;
}
div.right,ul.center{
	margin-top:100px;
	float: left;
	width: 30%;
	height:100%;
}  */

table{
	margin: 0px;
	padding: 0px;
}
#roleiframe {
	width: 100%;
	height: 80%;
	position: absolute;
	display: none;
	z-index:40;
	
}

.roleiframe_edit {
	width: 100%;
	height: 100%;
	margin-left: -200px;
	
}

#editAuthDiv{
	width: 100%;
	height: 100%;
	position: absolute;
	display: none;
	z-index:40;	
}
.editAuth {
	width: 100%;
	height: 100%;
	margin-left: -200px;
	margin-top: -100px;
}

#editUsersDiv{
	width: 100%;
	height: 100%;
	position: absolute;
	display: none;
	z-index:40;	
	
}
.editUsers {
	width: 100%;
	height: 100%;
	margin-left: 500px;
	

}

</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<!-- 	<div id="sys_role" class="left">
		<table id="role_list" border="2">
		</table>
	</div>
	<div id="roleiframe">
			<iframe id="roleiframe_edit" class="iframe_edit" scrolling="no"
				marginwidth="0" marginheight="0" frameborder="0"></iframe>
	</div>
	<div class="l"></div>
	
	<ul id="auth_list" class="center"></ul> 
	
	<div class="l"></div>
	<div id="sys_users" class="right">
		<table id="users_list" border="1">
			
		</table>
	</div> --> 
	
	<div id="cc" class="easyui-layout" style="width:100%;height:100%;margin-top: 8px;" >  
    
    <div  id="east" data-options="region:'east',split:false" style="width:18%;" >				
		<div class="easyui-panel" title="角色用户管理" data-options="fit:true,border:false">              
            <table id="users_list"></table>
        </div>
    </div>

	<div data-options="region:'west',split:false" style="width: 12%;">
		<div class="easyui-panel" title="角色管理" data-options="fit:true,border:false">  	             
	    	<table id="role_list"></table>
	    </div>
	</div>

	<div data-options="region:'center',title:'权限管理'"  style="padding:5px;background:#eee;">
		<table id="ulTool" border="0"></table>
		<br/>
	    <ul id="auth_list" class="easyui-tree"></ul>
    </div> 
    
    <div id="roleiframe">    
			<iframe id="roleiframe_edit" class="roleiframe_edit" scrolling="no"
				marginwidth="0" marginheight="0" frameborder="0"></iframe>
	</div> 
	
	<div id="editAuthDiv">
		<iframe id="editAuth" class="editAuth" scrolling="no"
			marginwidth="0" marginheight="0" frameborder="0">	
		</iframe> 
	</div> 
	
	<div id="editUsersDiv">
			<iframe id="editUsers" class="editUsers" scrolling="no"
				marginwidth="0" marginheight="0" frameborder="0">	
			</iframe> 
	</div>

</body>
</html>