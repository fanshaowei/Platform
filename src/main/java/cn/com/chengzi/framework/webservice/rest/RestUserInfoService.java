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

/**
 * CXF restful 接口例子，访问路径如下：http://localhost:8080/WechatApp/webservice/rest/userInfo/userCnt
 * @author fanshaowei
 *
 */
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
