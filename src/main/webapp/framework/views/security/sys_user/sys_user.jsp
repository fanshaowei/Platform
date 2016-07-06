<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用戶管理</title>
	<%@include file="/../../../common/common.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/framework/views/security/sys_user/js/sys_user.js"></script>
	<style type="text/css">	
	    html,body{
	        width:100%;
	        height:100%;
	    } 
	    
	    #diviframe{
	        width:100%;
	        height:80%;
	        position:absolute;	 
	        display: none;	       
	        z-index: 10;       	        
	    }
	       
	    .iframe_edit{
            width: 100%;
            height: 100%;      
        }         
	</style>
	<script type="text/javascript">
	  $(function(){		  
		  sysUser.init();
	   });	  	   	   
	</script>
</head>
<body>
     <div title="用户管理" style="padding:5px 0px;" data-options="closable:true" style="height:100%;">				   
	    <div class="easyui-accordion" style="margin-bottom:3px;">
	    <div title="查询" data-options="iconCls:'icon-search'" ><table style="margin:4px 0;">
	        <tr>
	            <td>&nbsp;&nbsp;用户名:<input id="userName" class="easyui-textbox" style="width:120px;height:28px;"></td>
	            <td>&nbsp;&nbsp;真实名:<input id="trueName" class="easyui-textbox" style="width:120px;height:28px;"></td>
	            <td>&nbsp;&nbsp;地址:<a class="">&nbsp;省份</a><input id="province" class="easyui-combobox" style="width:100px;height:28px;"></select>
	                    <a class="">&nbsp;&nbsp;市</a><select id="city" class="easyui-combobox" style="width:100px;height:28px;"></select>
	                    <a class="">&nbsp;&nbsp;区</a><select id="district" class="easyui-combobox" style="width:100px;height:28px;"></select>
	                    <a class="">&nbsp;&nbsp;小区名:</a><select id="neighborhood" class="easyui-combobox" style="width:100px;height:28px;"></select>
	            </td>
	            <td>&nbsp;&nbsp;<a id="search_button" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a></td>
	        </tr>
	    </table></div>
	    </div>
	    
	    <div style="height:89%;width:100%;position:absolute;">
		<table id="userListGrid" style="height:100%;width:100%;">
			<thead>
				<tr>
				    <th data-options="field:'userId',align:'center'" width="80" height="90" hidden=true>用户ID</th>
					<th data-options="field:'userName',align:'center'" width="80">用户名</th>
					<th data-options="field:'trueName',align:'center'" width="80">真实名</th>
					<th data-options="field:'role',align:'center'" width="80">角色</th>
					<th data-options="field:'province',align:'center'" width="80">省</th>
					<th data-options="field:'city',align:'center'" width="80">市</th>
					<th data-options="field:'district',align:'center'" width="80">区县</th>
					<th data-options="field:'neighborhood',align:'center'" width="100">小区名</th>
					<th data-options="field:'enabled',align:'center'" width=100">状态</th>
					<th data-options="field:'reset',align:'center'" width="100">重置密码</th>								
				</tr>
			</thead>
		</table>
		</div>		
		
		<div id="diviframe">
	         <iframe id="iframe_edit" class="iframe_edit" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" ></iframe>
	    </div>					          							
	 </div>
	 	 
</body>
</html>