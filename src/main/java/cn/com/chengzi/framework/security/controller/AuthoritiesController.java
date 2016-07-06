package cn.com.chengzi.framework.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.chengzi.framework.security.service.SysUsersService;
import cn.com.chengzi.framework.security.service.impl.SecurityUserHolder;

@Controller
public class AuthoritiesController {

	@Autowired
	SysUsersService sysUsersService;
	
	@Autowired
	private SecurityUserHolder securityUserHolderService;
	
	/**
	 * 查找一组菜单下的子菜单
	 * @param folderId
	 * @return
	 */
	@RequestMapping(path = "/getAuthMenuTree" ,method = RequestMethod.POST)
	public @ResponseBody List<?> getAuthMenuTree(@RequestParam("folderId") int folderId){
		int userId = securityUserHolderService.getCurrentUser().getUser_id();
		List<?> list = sysUsersService.getMenuByParentId(folderId, userId);
		
		return list;	
    }
}
