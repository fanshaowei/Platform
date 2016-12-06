package cn.com.chengzi.framework.security.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.chengzi.framework.common.query.SimpleQueryCriteria;
import cn.com.chengzi.framework.security.model.SysAuth;
import cn.com.chengzi.framework.security.model.SysRoles;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysAuthoritiesQueryCriteria;
import cn.com.chengzi.framework.security.query.SysUsersQureyCriteria;

public interface SysUsersMapper {
	List<SysUsers> findSysUsersListByAccount(Map<String,Object> map);
	
	List<Map<String,Object>> getSysUserFolder(SimpleQueryCriteria criteria);//获取用户最上级菜单
	
	List<?> getMenuByParentId(SysAuthoritiesQueryCriteria criteria);
	
	List<SysRoles> getSysRoles();
	
	void updateRoleById(SysRoles sysRoles);
	
	void insertsysRoles(SysRoles sysRoles);
	
	void deleteRoleById(int role_id);

	List<SysAuth> getAuth();
	
	//获取权限信息
	SysAuth getAuthById(int authority_id);
	Integer[] getChildAuthIdById(int authority_id);
	
	//获取角色对应的权限ID
	Integer[] getAuthIdById(int role_id);
	
	Integer[] getChildAuthIdByRoleId(@Param("role_id") int role_id, @Param("authority_id") int authority_id);
	void insertAuthRole(@Param("role_id") int role_id, @Param("authority_id") int authority_id);
	
	void deleteAuthRole(int role_id);
	
	List<SysAuth> getChildAuthById(@Param("role_id") int role_id, @Param("authority_id") int authority_id);
	
	
	List<SysUsers> getUsersById(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	int getUsersCnt(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	List<SysUsers> sysUsersListByRole(SysUsersQureyCriteria sysUsersQureyCriteria);
	
	int findSysUsersListCnt(SysUsersQureyCriteria sysUsersQureyCriteria);
}
