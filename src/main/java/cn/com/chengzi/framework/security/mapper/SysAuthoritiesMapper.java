package cn.com.chengzi.framework.security.mapper;

import java.util.List;
import java.util.Map;

import cn.com.chengzi.framework.security.model.SysAuthUser;
import cn.com.chengzi.framework.security.model.SysAuthorities;
import cn.com.chengzi.framework.security.query.SysAuthoritiesQueryCriteria;

public interface SysAuthoritiesMapper {
    public List<SysAuthorities> findSysAuthoritiesList();
    
    public List<SysAuthorities> findSysAuthoritiesListByName(SysAuthoritiesQueryCriteria sysAuthoritiesQueryCriteria);
    
    public List<Map<?,?>> findSysRolesAuthorities();
    
    public List<Map<?,?>> findUserAuthoritiesByUseraccount(Map<String,Object> map);
    
    public List<SysAuthorities> findAllAuthorities();
    
    public List<SysAuthUser> findAuthoritiesById(int user_id);
    
    public int findAuthUserListCnt();
    
    
    
}
