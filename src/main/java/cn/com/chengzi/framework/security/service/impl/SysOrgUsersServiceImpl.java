package cn.com.chengzi.framework.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.chengzi.framework.security.mapper.SysOrgUsersMapper;
import cn.com.chengzi.framework.security.model.SysOrganizer;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysUsersQureyCriteria;
import cn.com.chengzi.framework.security.service.SysOrgUsersService;

@Service("sysOrgUsersService")
public class SysOrgUsersServiceImpl implements SysOrgUsersService{
	
	@Autowired
	private SysOrgUsersMapper sysOrgUsersMapper;

	@Override
	public SysOrganizer getOrgById(int organizer_id) {
		// TODO Auto-generated method stub
		return sysOrgUsersMapper.getOrgById(organizer_id);
	}

	@Override
	public Integer[] getChildOrgIdById(int organizer_id) {
		// TODO Auto-generated method stub
		return sysOrgUsersMapper.getChildOrgIdById(organizer_id);
	}


	@Override
	public void insertUsersToRole(int user_id, int role_id) {
		// TODO Auto-generated method stub
		sysOrgUsersMapper.insertUsersToRole(user_id, role_id);
	}

	@Override
	public List<SysUsers> sysUsersListByOrg(int role_id, int organizer_id) {
		// TODO Auto-generated method stub
		return sysOrgUsersMapper.sysUsersListByOrg(role_id, organizer_id);
	}

	@Override
	public void deleteUsersById(int role_id, int user_id) {
		// TODO Auto-generated method stub
		sysOrgUsersMapper.deleteUsersById(role_id, user_id);
	}

	@Override
	public List<SysUsers> getAllUsersByOrg(
			SysUsersQureyCriteria sysUsersQureyCriteria) {
		// TODO Auto-generated method stub
		return sysOrgUsersMapper.getAllUsersByOrg(sysUsersQureyCriteria);
	}

	@Override
	public int findSysUsersCntByOrg(SysUsersQureyCriteria sysUsersQureyCriteria) {
		// TODO Auto-generated method stub
		return sysOrgUsersMapper.findSysUsersCntByOrg(sysUsersQureyCriteria);
	}

	@Override
	public void updateOrgUsersById(SysUsers sysUsers) {
		// TODO Auto-generated method stub
		sysOrgUsersMapper.updateOrgUsersById(sysUsers);
	}

	@Override
	public void insertOrgUsers(SysUsers sysUsers) {
		// TODO Auto-generated method stub
		sysOrgUsersMapper.insertOrgUsers(sysUsers);
	}

	@Override
	public void deleteOrgUsersById(int user_id) {
		// TODO Auto-generated method stub
		sysOrgUsersMapper.deleteOrgUsersById(user_id);
	}
}
