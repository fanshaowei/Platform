package cn.com.chengzi.framework.security.service;

import java.util.List;
import java.util.Map;

import cn.com.chengzi.framework.common.query.SimpleQueryCriteria;
import cn.com.chengzi.framework.security.model.SysUsers;

public interface SysUsersService {
	SysUsers findOneSysUsersByAccount(String userAccount);
	
	List<SysUsers> findSysUsersListByAccount(Map<String,Object> map);
	
    List<?> getUserFloder(SimpleQueryCriteria criteria);
    
    List<?> getMenuByParentId(int folderId,int userId);
}
