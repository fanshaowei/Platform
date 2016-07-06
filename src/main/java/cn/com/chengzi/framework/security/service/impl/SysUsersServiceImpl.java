package cn.com.chengzi.framework.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.chengzi.framework.common.query.SimpleQueryCriteria;
import cn.com.chengzi.framework.security.mapper.SysUsersMapper;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysAuthoritiesQueryCriteria;
import cn.com.chengzi.framework.security.service.SysUsersService;

public class SysUsersServiceImpl implements SysUsersService {

	@Autowired	
	private SysUsersMapper sysUsersMapper;
	
	@Override
	public List<SysUsers> findSysUsersListByAccount(Map<String,Object> map) {
		return sysUsersMapper.findSysUsersListByAccount(map);
	}
	
	@Override
	public SysUsers findOneSysUsersByAccount(String userAccount) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userAccount", userAccount);		
		List<SysUsers> sysUsersList = sysUsersMapper.findSysUsersListByAccount(paramMap);
		if (sysUsersList==null) 
			return null;
		
		SysUsers sysUser = sysUsersList.get(0);
		return sysUser;
	}		
    
	@Override
	public List<?> getUserFloder(SimpleQueryCriteria criteria){
		if(criteria == null) return null;
		return sysUsersMapper.getSysUserFolder(criteria);		
	}

	@Override
	public List<?> getMenuByParentId(int folderId,int userId) {
	    SysAuthoritiesQueryCriteria criteria = new SysAuthoritiesQueryCriteria();
	    criteria.setParentAuthorityId(folderId);
	    criteria.setUserId(userId);
	    List<?> list = sysUsersMapper.getMenuByParentId(criteria);
	    
		return list;
	}
	
}
