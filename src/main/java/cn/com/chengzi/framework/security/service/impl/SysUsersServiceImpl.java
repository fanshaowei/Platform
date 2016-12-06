package cn.com.chengzi.framework.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.chengzi.framework.common.query.SimpleQueryCriteria;
import cn.com.chengzi.framework.security.mapper.SysUsersMapper;
import cn.com.chengzi.framework.security.model.SysAuth;
import cn.com.chengzi.framework.security.model.SysRoles;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysAuthoritiesQueryCriteria;
import cn.com.chengzi.framework.security.query.SysUsersQureyCriteria;
import cn.com.chengzi.framework.security.service.SysUsersService;

@Service("sysUsersService")
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
	
	@Override
	public List<SysRoles> getSysRoles() {
		 
		return sysUsersMapper.getSysRoles();
	}

	@Override
	public SysAuth getAuthById(int authority_id) {
		 
		return sysUsersMapper.getAuthById(authority_id);
	}
	
	@Override
	public Integer[] getChildAuthIdById(int authority_id) {
		 
		return sysUsersMapper.getChildAuthIdById(authority_id);
	}
	
	@Override
	public List<SysUsers> getUsersById(SysUsersQureyCriteria sysUsersQureyCriteria) {
		 
		return sysUsersMapper.getUsersById(sysUsersQureyCriteria);
	}
	
	@Override
	public int getUsersCnt(SysUsersQureyCriteria sysUsersQureyCriteria){
		return sysUsersMapper.getUsersCnt(sysUsersQureyCriteria);
	}

	@Override
	public List<SysAuth> getChildAuthById(int role_id,int authority_id) {
		 
		return sysUsersMapper.getChildAuthById(role_id,authority_id);
	}

	@Override
	public List<SysAuth> getAuth() {
		 
		return sysUsersMapper.getAuth();
	}

	@Override
	public void updateRoleById(SysRoles sysRoles) {
		 
		 sysUsersMapper.updateRoleById(sysRoles);
	}

	@Override
	public void insertsysRoles(SysRoles sysRoles) {
		 
		sysUsersMapper.insertsysRoles(sysRoles);
	}

	@Override
	public void deleteRoleById(int role_id) {
		 
		sysUsersMapper.deleteRoleById(role_id);
	}

	@Override
	public Integer[] getAuthIdById(int role_id) {
		Integer[] arr=sysUsersMapper.getAuthIdById(role_id);
		return arr;
	}

	@Override
	public void insertAuthRole(int role_id, int authority_id) {
		sysUsersMapper.insertAuthRole(role_id, authority_id);
	}

	@Override
	public void deleteAuthRole(int role_id) {
		sysUsersMapper.deleteAuthRole(role_id);
	}

	@Override
	public List<SysUsers> sysUsersListByRole(
			SysUsersQureyCriteria sysUsersQureyCriteria) {
		 
		return sysUsersMapper.sysUsersListByRole(sysUsersQureyCriteria);
	}

	@Override
	public int findSysUsersListCnt(SysUsersQureyCriteria sysUsersQureyCriteria) {
		 
		return sysUsersMapper.findSysUsersListCnt(sysUsersQureyCriteria);
	}

	@Override
	public Integer[] getChildAuthIdByRoleId(int role_id, int authority_id) {
		 
		return sysUsersMapper.getChildAuthIdByRoleId(role_id, authority_id);
	}
}
