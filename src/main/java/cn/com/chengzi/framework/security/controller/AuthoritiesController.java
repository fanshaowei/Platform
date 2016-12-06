package cn.com.chengzi.framework.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.chengzi.framework.security.model.SysAuthUser;
import cn.com.chengzi.framework.security.model.SysAuthorities;
import cn.com.chengzi.framework.security.service.SysAuthoritiesService;
import cn.com.chengzi.framework.security.service.SysUsersService;
import cn.com.chengzi.framework.security.service.impl.SecurityUserHolder;

@Controller
public class AuthoritiesController {

	@Autowired
	SysUsersService sysUsersService;
	
	@Autowired
	private SecurityUserHolder securityUserHolderService;
	
	@Autowired
	SysAuthoritiesService sysAuthoritiesService;
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
	
	@RequestMapping("/sysAuthList")
	public List<SysAuthUser> findSysAuthById(int user_id){			
		
		return sysAuthoritiesService.findAuthoritiesById(user_id);
	}
		
	@RequestMapping(path = "/getAuthList")	
	public @ResponseBody ModelAndView authList(){
		List<SysAuthorities> sysAuthorities=sysAuthoritiesService.findAllAuthorities();
		for (SysAuthorities sysAuth : sysAuthorities) {
			String auth_name = sysAuth.getAuthority_name();
			int auth_type = sysAuth.getAuthority_type();
			System.out.println(auth_name+"----"+auth_type);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sysAuthorities",sysAuthorities);
		modelAndView.setViewName("/framework/views/security/sys_auth/auth_list");
		return modelAndView;	
    }
}
