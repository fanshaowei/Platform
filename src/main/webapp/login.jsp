<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
    <title>登陆</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">    
    <%@include file="common/common.jsp"%>
    <script type="text/javascript">
		/* if($.browser.msie){
			if($.browser.version=="6.0" || $.browser.version=="7.0"){
				alert("系统无法支持IE8.0以下的版本的浏览器，请安装IE8.0及以上版本");
				//window.location.href="Readme.html";
			}
	 	} */
    </script>
	<style type="text/css">
	   html,body{
	       width:100%;
	       height:100;
	       margin: 0;
	       padding: 0;
	       font-family:"Trebuchet MS", "Myriad Pro", Arial, sans-serif;
	       font-size:14px;
	   }	
	   h1{
			font-size:30px;
			margin:0 auto;				
		}
	   .wrapper{
			width:960px;
			margin:150px auto;
			min-height:550px;
		}
		.content{
		    margin-top:15px;
		}
	   	.form_wrapper{
	   	   background:#fff;
	   	   border:1px solid #ddd;
	   	   margin:0 auto;
	   	   width:350px;
	   	   font-size:16px;
	   	   -moz-box-shadow:2px 2px 10px #ccc;
		   -webkit-box-shadow:2px 2px 10px #ccc;
		   box-shadow:2px 2px 10px #ccc;
	   	}
	   	.form_wrapper h3{
	   	    padding:20px 30px 20px 30px;
	   	    margin: 0px;
	   	    background-color:#5297C1;
	   	    color:#fff;
	   	    font-size:25px;
	   	    border-bottom:1px solid #ddd; 
	   	}
	   	form.active{
	   	    display:block;
	   	}
	   	form.login{
	   	   width:350px;
	   	   margin:0px;
	   	}
	   	.form_wrapper a{
	   	    color:#777;
	   	    font-size:12px;
	   	}
	    
	    .form_wrapper label{
			display:block;
			padding:10px 30px 5px 30px;
			margin:15px 0px 0px 0px;
			font-weight: bold;
		}
	    
	    .form_wrapper input[type="text"],
	    .form_wrapper input[type="password"]{
	        border:solid 1px #E5E5E5;
	        margin:5px 30px 0px 30px;
	        padding:9px;
	        display:block;
	        font-size:16px;
	        font-weight: bold;
	        width:76%;
	        background:#FFFFFF;
	        background: 
				-webkit-gradient(
					linear, 
					left top, 
					left 25, 
					from(#FFFFFF), 
					color-stop(4%, #EEEEEE), 
					to(#FFFFFF)
				);
		    background: 
				-moz-linear-gradient(
					top, 
					#FFFFFF,
					#EEEEEE 1px, 
					#FFFFFF 25px
				); 
	         -moz-box-shadow: 0px 0px 10px #f0f0f0;
	         -webkit-box-shadow:0px 0px 10px #f0f0f0;
	         box-shadow:0px 0px 10px #f0f0f0;		               
	    }
	    
	   .form_wrapper input[type="text"]:focus,
		.form_wrapper input[type="password"]:focus{
			background:#feffef;
		}
	    
	    .form_wrapper .bottom{
	        background-color:#5297C1;
	        border-top:1px solid #ddd;
	        margin-top:40px;
	        clear:both;
	        color:#fff;
	    }
	    
	     .form_wrapper .bottom a{
	        display:none;
	        clear:both;
	        padding:5px 30px 10px 30px;
	        color:#ffa800;		        
	    }
	     
	    .form_wrapper div.remember{
	        float:left;
	        width:35%;
	        margin:15px 0px 15px 30px;
	        font-size:17px;
	    }
	    
	    .form_wrapper div.remember input{
	        float:left;
	        margin:2px 5px 0px 0px;		        
	    }
	    
	    .form_wrapper input[type="submit"]{
	        background:#e3e3e3;
	        border:1px solid #ccc;
	        color:#333;
	        font-size:16px;
	        font-weight:bold;
	        padding:8px 0 9px;
	        text-align:center;
	        width:80%;
	        cursor:pointer;		      
	        margin:20px 0px 20px 0px;
	        text-shadow:0 1px 0 #fff;
	        -moz-border-radius:5px;
	        -webkit-border-radius:5px;
	        border-radius:5px;
	        -moz-box-shadow:0px 0px 2px #fff inset;
	        -webkit-box-shadow:0px 0px 2px #fff inset;
	        box-shadow:0px 0px 2px #fff inset;
	    }
	    .form_wrapper input[type="submit"]:hover{
	        background:#d9d9d9;
	        -moz-box-shadow:0px 0px 2px #fff inset;
	        -webkit-box-shadow:0px 0px 2px #fff inset;
	        box-shadow:0px 0px 2px #fff inset;
	        color:#222;
	    }		    
	</style>
	<script type="text/javascript">		
	    $(document).ready(function(){
	    	var flag = <%= request.getParameter("error") %>;
	    	if(flag!=null){
	    		$(".form_wrapper .bottom a").css("display","block");
	    	}		    	
	    });
	</script>
</head>
<body>        
    <div class="wrapper">
        <h1></h1>
	    <div class="content">
	        <div id="form_wrapper" class="form_wrapper">
	            <form class="login active" name="loginForm" action="j_spring_security_check" method="post">
	                <h3><center>安居宝后台管理</center></h3>
	                <div>
	                     <label>用户名:</label>
	                     <input type="text" name="j_username">
	                </div>
	                <div>
	                    <label>密 码:</label>
	                    <input type="password" name="j_password">	                    
	                </div>
	                <div class="remember">
	                    <input type="checkbox" style="width: 18px;height: 18px;"><span>记住登陆</span> 
	                </div>
	                <div class="bottom">	                    
	                    <center><input type="submit" value="登陆" class="btn"></center>
	                    <center><a>用户名或密码不正确!</a></center>
	                </div>
	                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	            </form>
	        </div>
	    </div>
	  </div>  
</body>
</html>