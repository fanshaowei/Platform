package cn.com.chengzi.framework.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.chengzi.framework.security.mapper.SysAuthoritiesMapper;
import cn.com.chengzi.framework.security.model.SysAuthUser;
import cn.com.chengzi.framework.security.model.SysAuthorities;
import cn.com.chengzi.framework.security.query.SysAuthoritiesQueryCriteria;
import cn.com.chengzi.framework.security.service.SysAuthoritiesService;

@Service("sysAuthoritiesService")
public class SysAuthoritiesServiceImpl implements SysAuthoritiesService {

	@Autowired
	private SysAuthoritiesMapper sysAuthoritiesMapper;
	
    private	Map<String,Object> paramMap = null;
	
	@Override
	public List<SysAuthorities> findSysAuthoritiesList() {
		List<SysAuthorities> sysAuthoritiesList = sysAuthoritiesMapper.findSysAuthoritiesList();
		
		return sysAuthoritiesList;
	}

	@Override
	public List<SysAuthorities> findSysAuthoritiesListByName(SysAuthoritiesQueryCriteria sysAuthoritiesQueryCriteria) {		
		List<SysAuthorities> sysAuthoritiesList = sysAuthoritiesMapper.findSysAuthoritiesListByName(sysAuthoritiesQueryCriteria);
		
		return sysAuthoritiesList;
	}

	/**
	 * 查询角色权限
	 */
	@Override
	public List<Map<?, ?>> findSysRolesAuthorities() {		
		return sysAuthoritiesMapper.findSysRolesAuthorities();		
	}
    
	/**
	 * 根据用户帐号查询用户权限
	 */
	@Override
	public List<Map<?, ?>> findUserAuthoritiesByUseraccount(String userAccount) {	
		paramMap = new HashMap<String,Object>();
		paramMap.put("userAccount", userAccount);
		List<Map<?,?>> returnList = sysAuthoritiesMapper.findUserAuthoritiesByUseraccount(paramMap);
		if((returnList == null)||returnList.size()==0)
   		    return null;
		return returnList;
	}
	
	@Override
	public List<SysAuthorities> findAllAuthorities() {
		return (List<SysAuthorities>) sysAuthoritiesMapper.findAllAuthorities();
	}

	@Override
	public List<SysAuthUser> findAuthoritiesById(int user_id){
		return (List<SysAuthUser>) sysAuthoritiesMapper.findAuthoritiesById(user_id);
	}

	@Override
	public int findAuthUserListCnt() {
		return sysAuthoritiesMapper.findAuthUserListCnt();
	}
}
