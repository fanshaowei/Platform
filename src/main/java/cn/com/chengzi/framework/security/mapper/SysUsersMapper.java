package cn.com.chengzi.framework.security.mapper;

import java.util.List;
import java.util.Map;

import cn.com.chengzi.framework.common.query.SimpleQueryCriteria;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysAuthoritiesQueryCriteria;

public interface SysUsersMapper {
	List<SysUsers> findSysUsersListByAccount(Map<String,Object> map);
	
	List<Map<String,Object>> getSysUserFolder(SimpleQueryCriteria criteria);//获取用户最上级菜单
	
	List<?> getMenuByParentId(SysAuthoritiesQueryCriteria criteria);
}
