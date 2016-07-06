package cn.com.chengzi.framework.security.service;

import java.util.List;

import cn.com.chengzi.framework.security.model.SysUser;
import cn.com.chengzi.framework.security.query.SysUserQureyCriteria;

public interface SysUserService {
    public List<SysUser> findSysUserList(SysUserQureyCriteria SysUserQureyCriteria);
    
    public int findSysUserListCnt(SysUserQureyCriteria SysUserQureyCriteria);
    
    public int findSysUserCntById(int userId);
    
    public int updateSysUserById(SysUser sysUser);
    
    public void insertSysUser(SysUser sysUser);
    
    public void deleteSysUserById(int userId);
}
