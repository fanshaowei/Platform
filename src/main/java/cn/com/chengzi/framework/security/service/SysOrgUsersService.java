package cn.com.chengzi.framework.security.service;

import java.util.List;

import cn.com.chengzi.framework.security.model.SysOrganizer;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysUsersQureyCriteria;

public interface SysOrgUsersService {
	
	SysOrganizer getOrgById(int organizer_id);
	
	Integer[] getChildOrgIdById(int organizer_id);
	
	List<SysUsers> sysUsersListByOrg(int role_id,int organizer_id);
	
	List<SysUsers> getAllUsersByOrg(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	int findSysUsersCntByOrg(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	void deleteUsersById(int role_id,int user_id);
	
	void insertUsersToRole(int user_id,int role_id);
	
	void updateOrgUsersById(SysUsers sysUsers);
	
	void insertOrgUsers(SysUsers sysUsers);
	
	void deleteOrgUsersById(int user_id);;
}
