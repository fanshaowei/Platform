<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>权限管理</title>
	<%@include file="/../../../common/common.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/framework/views/security/sys_auth/js/edit_auth.js"></script>
	<style type="text/css">	
	    html,body{
	        width:100%;
	        height:100%;
	    }
	    	    
           
	</style>
	<script type="text/javascript">
	  $(function(){	 	  
		  authEdit.init();    		    	
	  });
	</script>
</head>
<body>
	
	<div id="auth" class="auth" style="width:350px;height:380px;padding:10px">
		<ul id="tt" class="easyui-tree" checkbox="true" >

		</ul>
	</div>
	
</body>
</html>