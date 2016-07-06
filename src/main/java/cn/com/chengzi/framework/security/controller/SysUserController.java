package cn.com.chengzi.framework.security.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.chengzi.framework.common.query.PageCalculate;
import cn.com.chengzi.framework.security.model.SysUser;
import cn.com.chengzi.framework.security.query.SysUserQureyCriteria;
import cn.com.chengzi.framework.security.service.SysUserService;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    
	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("/sysUserList")
	public HashMap<String,Object> findSysUserList(SysUserQureyCriteria sysUserQureyCriteria){			
		Map<String,Object> map = new HashMap<String,Object>();
		
		int totalCount = sysUserService.findSysUserListCnt(sysUserQureyCriteria);//用户列表总数
		int pageSize = Integer.valueOf(sysUserQureyCriteria.getPageSize());
		int pageNumber = Integer.valueOf(sysUserQureyCriteria.getPageNumber());
		
		PageCalculate pageCalculate = new PageCalculate(totalCount,pageSize,pageNumber);
		sysUserQureyCriteria.setIndex(pageCalculate.getIndex());
		
		List<SysUser> sysUserList = sysUserService.findSysUserList(sysUserQureyCriteria);//分页记录
		map.put("rows", sysUserList);
		map.put("total", totalCount);	
		
		return (HashMap<String, Object>) map;
	}
	
	@RequestMapping("/updateSysUserById")
	public  HashMap<String,Object> updateSysUserById(@RequestBody SysUser sysUser){
		Map<String,Object> returnMap = new HashMap<String,Object>(); 
		
		int userId = sysUser.getUserId();		
		int cnt = sysUserService.findSysUserCntById(userId);
		if(cnt == 1){
			int cnt1 = sysUserService.updateSysUserById(sysUser);
			returnMap.put("status", "1");
			returnMap.put("message", "更新成功");
		}else{
			returnMap.put("stauts", "-1");
			returnMap.put("message", "记录不存在");
		}					
		
		return (HashMap<String, Object>) returnMap;
	}
	
	@RequestMapping("/insertSysUser")
	public  HashMap<String,Object> insertSysUser(@RequestBody @Valid SysUser sysUser){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		
		System.out.println(StringUtils.isEmpty(sysUser.getUserName()));
		
		sysUserService.insertSysUser(sysUser);
		
		returnMap.put("status", "1");
		returnMap.put("message", "数据添加成功");
		
		return (HashMap<String, Object>) returnMap;
	}
	
	@RequestMapping("/deleteSysUser")
	public  HashMap<String,Object> deleteSysUser(@RequestBody SysUser sysUser){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		
		int userId = sysUser.getUserId();		
		sysUserService.deleteSysUserById(userId);
		
		returnMap.put("status", "1");
		returnMap.put("message", "数据删除成功");
		
		return (HashMap<String, Object>) returnMap;
	}
		
}
