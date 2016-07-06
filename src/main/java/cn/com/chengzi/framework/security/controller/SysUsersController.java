package cn.com.chengzi.framework.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.chengzi.framework.common.query.SimpleQueryCriteria;
import cn.com.chengzi.framework.security.service.SysUsersService;
import cn.com.chengzi.framework.security.service.impl.SecurityUserHolder;

//@RestController 使用rest风格，ajax
@Controller
public class SysUsersController {
	@Autowired
	private SysUsersService sysUsersService;
	
	@Autowired
	private SecurityUserHolder securityUserHolderService;
	
	private List<?> folderList;
	
	/**
	 * 根据登陆id获取用户一级菜单
	 * @param userId
	 * @return
	 */
    @RequestMapping(path = "/getSysUserFolder" , method = RequestMethod.POST)
	public @ResponseBody List<?> getSysUserFolder(){        	
    	SimpleQueryCriteria simpleQueryCriteria = new SimpleQueryCriteria();   
    	simpleQueryCriteria.setIntVal1(securityUserHolderService.getCurrentUser().getUser_id());
        
        this.folderList = sysUsersService.getUserFloder(simpleQueryCriteria);
    	return this.folderList;    	    	         
	}
    
    
}
