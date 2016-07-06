package cn.com.chengzi.framework.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.chengzi.framework.security.mapper.SysUserMapper;
import cn.com.chengzi.framework.security.model.SysUser;
import cn.com.chengzi.framework.security.query.SysUserQureyCriteria;
import cn.com.chengzi.framework.security.service.SysUserService;

public class SysUserServiceImpl implements SysUserService {

	@Autowired
	SysUserMapper sysUserMapper;	
	
	@Override
	public List<SysUser> findSysUserList(SysUserQureyCriteria sysUserQureyCriteria) {
		List<SysUser> sysUserList = sysUserMapper.findSysUserList(sysUserQureyCriteria);
		
		return sysUserList;
	}
	
	@Override
	public int findSysUserListCnt(SysUserQureyCriteria sysUserQureyCriteria) {
        int cnt = sysUserMapper.findSysUserListCnt(sysUserQureyCriteria);
		
		return cnt;
	}

	@Override
	public int findSysUserCntById(int userId) {
		int cnt = sysUserMapper.findSysUserCntById(userId);
		
		return cnt;
	}

	@Override
	public int updateSysUserById(SysUser sysUser) {
		int cnt = sysUserMapper.updateSysUserById(sysUser);
		return cnt;
	}

	@Override
	public void insertSysUser(SysUser sysUser) {
		sysUserMapper.insertSysUser(sysUser);		
	}

	@Override
	public void deleteSysUserById(int userId) {
	    sysUserMapper.deleteSysUserById(userId);
		
	}
    		
}
