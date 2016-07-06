package cn.com.chengzi.framework.webservice.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.chengzi.framework.security.model.SysUser;
import cn.com.chengzi.framework.security.query.SysUserQureyCriteria;
import cn.com.chengzi.framework.security.service.SysUserService;


@Path("/userInfo")
public class RestUserInfoService {
	@Autowired
	SysUserService sysUserService;
	
	@GET
	@Path("/userCnt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public List<SysUser> getUserCount(){
    	SysUserQureyCriteria sysUserQureyCriteria = new SysUserQureyCriteria();
    	//int total = sysUserService.findSysUserListCnt(sysUserQureyCriteria);
    	List<SysUser> sysUserList = sysUserService.findSysUserList(sysUserQureyCriteria);
    	
    	return sysUserList;
    }
}
