package cn.com.chengzi.framework.security.service;

import java.util.List;
import java.util.Map;

import cn.com.chengzi.framework.common.query.SimpleQueryCriteria;
import cn.com.chengzi.framework.security.model.SysAuth;
import cn.com.chengzi.framework.security.model.SysRoles;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysUsersQureyCriteria;

public interface SysUsersService {
	SysUsers findOneSysUsersByAccount(String userAccount);
	
	List<SysUsers> findSysUsersListByAccount(Map<String,Object> map);
	
    List<?> getUserFloder(SimpleQueryCriteria criteria);
    
    List<?> getMenuByParentId(int folderId,int userId);
    
    List<SysRoles> getSysRoles();
    
    void updateRoleById(SysRoles sysRoles);
    
    void insertsysRoles(SysRoles sysRoles);
    
    void deleteRoleById(int role_id);  
    
    List<SysAuth> getAuth();

    SysAuth getAuthById(int authority_id);
    
	Integer[] getChildAuthIdById(int authority_id);
    
    Integer[] getAuthIdById(int role_id);
    
    Integer[] getChildAuthIdByRoleId(int role_id,int authority_id);
    
    void insertAuthRole(int role_id,int authority_id);
    
    void deleteAuthRole(int role_id);
    
    List<SysAuth> getChildAuthById(int role_id,int authority_id);
	
	List<SysUsers> getUsersById(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	int getUsersCnt(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	List<SysUsers> sysUsersListByRole(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	int findSysUsersListCnt(SysUsersQureyCriteria sysUsersQureyCriteria);
}
