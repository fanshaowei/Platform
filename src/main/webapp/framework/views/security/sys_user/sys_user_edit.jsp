<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用戶管理</title>
	<%@include file="/../../../common/common.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/framework/views/security/sys_user/js/sys_user_edit.js"></script>
	<style type="text/css">	
	    html,body{
	        width:100%;
	        height:100%;
	    }	    
	    .dal table tr td{
	        padding:5px 0px;
	    }
	    	  
	    .dal table tr td.descript{
	        width:60px;
	        text-align: center;
	        font-size: 600;
	        font-weight: bold;	        
	    }            
	</style>
	<script type="text/javascript">
	  $(function(){	 		     
		  sysUserEdit.init();	    		    	
	  });	  
	   	  
	</script>
</head>
<body>       
	<div id="dal" class="dal" style="width:520px;height:380px;padding:10px">
	    <div style="display:none;"><input id="userId" type="text" class="easyui-textbox"></div> 
		<table>
		    <tr>
		        <td class="descript">用户名:</td><td><input id="userName" type="text" class="easyui-textbox" style="width:150px;height:26px;"></td>
		        <td class="descript">真实名:</td><td><input id="trueName" type="text" class="easyui-textbox" style="width:150px;height:26px;"></td>
		    </tr>
		    <tr><td class="descript">角色:</td><td><select id="role" class="easyui-combobox" style="width:150px;height:26px;"></select></td>
		        <td class="descript">状态:</td><td><input id="enabled" type="checkbox" ><span>启用</span></td>
		    </tr>
		    <tr>
		        <td class="descript">地址:</td>
		        <td colspan="3">
		            <div style="margin-right: 20px;float: left;"><span>省&nbsp;</span><select id="province" class="easyui-combobox" style="width:95px;height:26px;"></select></div>		        
		            <div style="margin-right: 20px;float: left;"><span>市&nbsp;</span><select id="city" class="easyui-combobox" style="width:95px;height:26px;"></select></div>
		            <div style="margin-right: 20px;float: left;"><span>区&nbsp;</span><select id="district" class="easyui-combobox" style="width:95px;height:26px;"></select></div>
		        </td>
		    </tr>
		    <tr>
		        <td class="descript">小区:</td><td><select id="neighborhood" class="easyui-combobox" style="width:150px;height:26px;"></select></td>
		    </tr>
		    <tr>
		        <td class="descript">说明:</td><td colspan="3"><input id="descript" class="easyui-textbox" data-options="multiline:true" style="width:380px;height:100px;"></td>
		    </tr>            
		</table>
	</div>
</body>
</html>