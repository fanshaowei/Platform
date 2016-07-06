var frame={
	token:"",
	header:"",
	menu:{
		menuId:'',
		menuUrl:'',
		menuTitle:''	
	},
	lastSelectTabIdx:-1,
	loadFolderIdList:",",
	lastSelectMenuId:"",
	iframe_count:0
};

frame.init = function(){
	$("body").layout("resize");	
	
	frame.loadUserFolder();//获取一级菜单
	frame.initSystemMenu();
	frame.initTabs();//初始化tab
};

frame.initSystemMenu=function(){
	//初始化菜单
	$('#mainmenu').menubutton({   
		menu: '#mm-mainmenu',
		plain:true
	});
	
	$("#mm-mainmenu").menu({
		onClick:function(item){
			switch(item.id){
			case 'mm-memupwd':
				$.messager.alert("修改密码");
				break;
			case 'mm-menuexit':
				$.messager.confirm('系统信息', '确定退出系统吗?', function(r){
					if (r==true){											
					 	$("#formLogout").submit();
					}
				});
				break;
			 default:
				break;
			}
		}
	})
}

/**
 * 绑定tab事件
 */
frame.initTabs=function(){
	//菜单关联事件
	$("#center_tabs").tabs({
		onSelect:function(title){
			var menu=$("#left_menu").find("div[name=_menu_"+title+"]");
			if(frame.lastSelectMenuId == menu.attr("id")) 
				return;
			$(".left_menu_selected").removeClass("left_menu_selected");
			frame.lastSelectMenuId = menu.attr("id");
			menu.addClass("left_menu_selected");
			if(frame.lastSelectTabIdx != menu.parent().attr("index")){
				$("#left_menu").accordion("select",menu.parent().attr("name").substr(8));
			}
		}
	});
}

/**
 * 找开菜单
 * tabTitle：菜单名
 * urlStr：菜单地址
 * menu: 一级菜单权限ID
 * func:子菜单ID
 * funcflag:子菜单标识
 */
frame.frameAddTab = function(tabTitle, urlStr , menu, func , funcflag){		
	if(!$("#center_tabs").tabs("exists",tabTitle)){
		var _url = top.Client.CONST_PATH + urlStr;
		var frameId = funcflag==null||undefined?frame.iframe_count:funcflag;
		var content = '<input type="hidden" name="menu" value="' + menu + '" />'
			+'<input type="hidden" name="func" value="' + func + '" />'
			+'<iframe id="_framemodule_' + frameId + '"' + 'name="_frmmodule_' + frameId + '"'
			+'scrolling="auto" marginwidth="0" marginheight="0" frameborder="0" width="100%" height="100%" ;margin:0px;padding:0px; src="'
			+ _url +
		    '"></iframe>';
		
		$("#center_tabs").tabs("add",{
			title:tabTitle,
			content:content,
	        closable:true,
	        cache:false
		});
		frame.iframe_count = frame.iframe_count+1; 
	}else{
		$("#center_tabs").tabs("select",tabTitle);
	}
}

/**
 *初始化左边菜单 手风琴
 */
frame.initAccordion = function(){
	$("#left_menu").accordion({
		fit:true,
		border:false,
		onBeforeSelect:function(title,idx){
			frame.lastSelectTabIdx=idx;
		},
	    onBeforeCollapse:function(title,idx){
	    	if(frame.lastSelectTabIdx==idx){
	    		return false;
	    	}
	    },
		onSelect:function(title,idx){
			frame.lastSelectTabIdx=idx;
			var id = $(this).find("div[class*='accordion-header-selected']").next().attr("id");
			if($("#"+id).html()!="") return;
			id = id.substring(id.indexOf("_")+1,id.length);
			frame.loadAuthMenuTree(id,title);
		}
	});
}

/**
 * 加载一级菜单
 */
frame.loadUserFolder = function(){			
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		contentType:"application/json;charset=utf-8",
		url: top.Client.CONST_PATH + "/getSysUserFolder",
		/*beforeSend: function(request) {
            request.setRequestHeader(frame.header, frame.token);
        },*/ 
		success:function(data){		
			console.log(data);
			if(data == undefined || data == null || data.length == 0){
				frame.initAccordion();
				return;
			}
			$("#left_menu").empty();
			var bFirst = true;			
			$.each(data,function(idx,item){
				var str = "<div id=\"folder_"+item.authority_id+"\" name=\"_folder_"+item.authority_name+"\" " +
						"title=\""+item.authority_name+"\" iconCls=\"icon-"+item.authority_flag+"\" " +
						"selected=\""+bFirst+"\" index=\""+idx+"\"></div>";
				$("#left_menu").append(str);
				if(bFirst) bFirst = false;
			});
			frame.initAccordion();
		},
		error:function(){
			$.messager.alert("系统提示","菜单加载失败,请重新登陆","error");
	    }
	});	
}

/**
 * 加载权限树数据
 * authority_id:一级菜单权限id
 */
frame.loadAuthMenuTree = function(authority_id,title){
	if(frame.loadFolderIdList.indexOf(","+authority_id+",")>=0) return;
	
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		data:{folderId : authority_id},
		url: top.Client.CONST_PATH + "/getAuthMenuTree",
		/*beforeSend: function(request) {
            request.setRequestHeader(frame.header, frame.token);
        },*/ 
		success:function(data){		
			console.log(data); 	
			frame.initFolderAuth(authority_id,data);
		},
		error:function(){
			$.messager.alert("系统提示","权限加载失败，请重新登陆","error");
	    }
	});	
}

/**
 * 初始化左边树型菜单
 */
frame.initFolderAuth = function(authority_id,data){
	if(data==null || data==undefined || data.length<=0) return;
	var authorityHtml="";
	for(var i=0;i<data.length;i++){
		authorityHtml+="<div id=\"_menu_"+data[i].authority_id + "\" name=\"_menu_"+data[i].authority_name+ "\" class=\"left_menu\">" +
				      "<div class=\"icon icon-menu icon-"+data[i].authority_flag+"\"></div>" +					 
				      "<div class=\"title\" id=\"_func_"+data[i].authority_flag+"\" url=\""+data[i].authority_url+"\">"+data[i].authority_name+"</div></div>";				
	}
	$("#folder_"+authority_id).empty().html(authorityHtml);
	$("#folder_"+authority_id).find("div[id^=_menu_]").bind({
		mouseover:function(){
			$(this).addClass("left_menu_over");
		},
		mouseout:function(){
			$(this).removeClass("left_menu_over");
		}
	});
	
	$("#folder_"+authority_id).find("div[id^=_func_]").bind({
		click:function(){
			$(".left_menu_selected").removeClass("left_menu_selected");
			$(this).parent().addClass("left_menu_selected");
			frame.lastSelectMenuId=$(this).parent().attr("id");
			frame.frameAddTab($(this).html(), $(this).attr("url"), authority_id, $(this).parent().attr("id").substr(6),$(this).attr("id").substr(6));
		}
	});
}