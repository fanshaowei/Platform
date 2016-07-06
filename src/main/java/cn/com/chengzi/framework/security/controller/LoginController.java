package cn.com.chengzi.framework.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.chengzi.framework.security.service.SysAuthoritiesService;

@Controller
@RequestMapping("/login")
public class LoginController {  	
	
	@Autowired
	private SysAuthoritiesService authoritySecurityService;
	
	
	@RequestMapping("/index")
	public String index(Model model){				
		return "index";
	}
	
}
