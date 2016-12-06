<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户管理</title>
	<%@include file="/../../../common/common.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/framework/views/security/sys_org/js/edit_org_users.js"></script>
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
		  sysOrgUsersEdit.init();	    		    	
	  });	  
	   	  
	</script>
</head>
<body>
	<div id="org_users" class="dal" style="width:350px;height:380px;padding:10px">
	    <div style="display:none;"><input id="user_id" type="text" class="easyui-textbox"></div> 
		<table>
		    <tr>
		        <td class="descript">用户名:</td><td><input id="user_name" type="text" class="easyui-textbox" style="width:150px;height:26px;" /></td>
		    </tr>
		    <tr>
		        <td class="descript">用户账户:</td><td><input id="user_account" type="text" class="easyui-textbox" style="width:150px;height:26px;" /></td>
		    </tr>
		    <tr>
		    	<td class="descript">是否生效:</td><td><select id="is_valid" class="easyui-combobox" style="width:100px;height:26px;">
		    		<option>Y</option><option>N</option> 
		    	</select></td>
		    </tr>
		    <tr>
		        <td class="descript">是否管理员:</td><td><select id="is_admin" class="easyui-combobox" style="width:100px;height:26px;">
		        	<option>Y</option><option>N</option>
		        </select></td>
		    </tr>
		    <tr>
		        <td class="descript">组织ID:</td><td><select id="organizer_id" type="text" class="easyui-combobox" style="width:100px;height:26px;">
		        	<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>
		        </select></td>
		    </tr>
		     <tr>
		        <td class="descript">手机:</td><td><input id="mobile_number" type="text" class="easyui-textbox" style="width:100px;height:26px;" /></td>
		    </tr> 
		    <tr>
		        <td class="descript">电话:</td><td><input id="phone_number" type="text" class="easyui-textbox" style="width:100px;height:26px;" /></td>
		    </tr>      
		</table>
	</div>
</body>
</html>