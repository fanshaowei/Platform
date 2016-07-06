package cn.com.chengzi.framework.security.service;

import java.util.List;
import java.util.Map;

import cn.com.chengzi.framework.security.model.SysAuthorities;
import cn.com.chengzi.framework.security.query.SysAuthoritiesQueryCriteria;

public interface SysAuthoritiesService {
	
    public List<SysAuthorities> findSysAuthoritiesList();
    
    public List<SysAuthorities> findSysAuthoritiesListByName(SysAuthoritiesQueryCriteria authoritySecurityQueryCriteria);
    
    public List<Map<?,?>> findSysRolesAuthorities();
    
    public List<Map<?,?>> findUserAuthoritiesByUseraccount(String userAccount); 
}
