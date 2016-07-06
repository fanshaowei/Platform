package cn.com.chengzi.framework.security.mapper;

import java.util.List;

import cn.com.chengzi.framework.security.model.SysUser;
import cn.com.chengzi.framework.security.query.SysUserQureyCriteria;

public interface SysUserMapper {
    public List<SysUser> findSysUserList(SysUserQureyCriteria sysUserQureyCriteria); 
    
    public int findSysUserListCnt(SysUserQureyCriteria sysUserQureyCriteria);
    
    public int findSysUserCntById(int userId);
    
    public int updateSysUserById(SysUser sysUser);
    
    public void insertSysUser(SysUser sysUser);
    
    public int deleteSysUserById(int userId);
}
