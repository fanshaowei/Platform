package cn.com.chengzi.framework.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.chengzi.framework.security.model.SysOrganizer;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysUsersQureyCriteria;


public interface SysOrgUsersMapper {
	
	SysOrganizer getOrgById(int organizer_id);
	
	Integer[] getChildOrgIdById(int organizer_id);
	
	List<SysUsers> sysUsersListByOrg(@Param("role_id") int role_id,@Param("organizer_id") int organizer_id);
	
	List<SysUsers> getAllUsersByOrg(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	int findSysUsersCntByOrg(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	void deleteUsersById(@Param("role_id") int role_id,@Param("user_id") int user_id);
	
	void insertUsersToRole(@Param("user_id") int user_id,@Param("role_id") int role_id);
	
	void updateOrgUsersById(SysUsers sysUsers);
	
	void insertOrgUsers(SysUsers sysUsers);
	
	void deleteOrgUsersById(int user_id);
}
