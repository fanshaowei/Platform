<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>运营平台</title>
	<%@include file="../../common/common.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index/index.js"></script>	
	<style type="text/css">
	    html,body {
	        padding:0;
	        margin:0;
	        width:100%;
	        height:100%;
	        font-family: "Microsoft YaHei"!important;	       	       
        }  
        ul{
            padding: 0px;
    		margin: 0px;     
            list-style-type: none;
        }
        li{           
           padding-top:10px;
           padding-bottom:10px;
           padding-left:15px;
        }     
                
        .left_menu{
			position: relative;
			padding: 3px 8px 3px 60px;
			color:#4f6273;
		}
		
		.left_menu_over{
			background: #e2e2e2;
			font-weight:bold;
			color:#2f4a7b;
		}
        .left_menu_selected {
		    background: #0092DC;
		    color: #fff;
		}     
		.left_menu .title {
		    height: 26px;
		    line-height: 26px;
		    cursor: pointer;
		    background: transparent;
		    white-space: nowrap;
		    word-wrap: normal;
		    overflow: hidden;
		}                
	</style>
	<script type="text/javascript">	  
	    $(document).ready(function(){
	    	//frame.token = $("meta[name='_csrf']").attr("content");
	    	//frame.header = $("meta[name='_csrf_header']").attr("content");
	    	
	    	frame.init(); 	    	
	    });
	</script>
</head>
<body class="easyui-layout" border="false";>
    <!-- <div id="layoutdiv"  style="width:100%;height:100%; border:false;"> -->
        <div data-options="region:'north'" style="height:70px;background-color:#6083C0;"><center><h1>运营平台</h2></center></div>
        
        <div data-options="region:'south',split:true" style="height:50px;margin:0;padding:0;">
            <center>版权所有：********</center>
        </div>              
        
        <div id="frame_west" data-options="region:'west',split:true" title="管理后台" style="width:200px;">
            <div id="left_menu" >
            </div>            
        </div>
                
        <div id="frame_center" data-options="region:'center'">
            <div id="center_tabs" class="easyui-tabs" data-options="tools:'#tab-tools',fit:true,border:false,plain:true,split:true" style="width:100%;height:100%;"></div>
            <div id="tab-tools" style="margin-top:1px;border-top-color:Transparent;border-right-color:Transparent;">
                <a id="mainmenu" href="#" iconCls="icon-menu">菜单</a>
            </div> 
            <div id="mm-mainmenu" style="width:100px;">
				<div id="mm-memupwd" iconCls="icon-edit">修改密码</div>
				<div id="mm-menuexit" iconCls="icon-exit">退出</div>
		    </div> 
		     
		    <form id="formLogout" action= "${pageContext.request.contextPath}/j_spring_security_logout" method="post">           
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    </form>                                
        </div>                                                                          
</body>
</html>