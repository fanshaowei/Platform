package cn.com.chengzi.framework.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.service.SysUsersService;

/**
 * 获取登陆用户信息
 * @author fanshaowei
 *
 */
public class SecurityUserHolder {
	@Autowired
	private  SysUsersService sysUsersService;
	
    public SysUsers getCurrentUser(){
    	SysUsers sysUsers = null;
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	Object principal = authentication.getPrincipal();
    	if((authentication == null) || ("anonymousUser".equals(principal))){
    		return null;
    	}
    	UserDetails us= (UserDetails) principal;
    	String userName = us.getUsername();
    	sysUsers = sysUsersService.findOneSysUsersByAccount(userName);	
    	
    	return sysUsers; 
    }
}
