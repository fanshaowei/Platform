package cn.com.chengzi.framework.security.query;

import cn.com.chengzi.framework.common.query.PageQueryCriteria;

public class SysAuthoritiesQueryCriteria extends PageQueryCriteria{
    private int parentAuthorityId;
    private int userId;
	private String authorityName;
	
	public int getParentAuthorityId() {
		return parentAuthorityId;
	}
	public void setParentAuthorityId(int parentAuthorityId) {
		this.parentAuthorityId = parentAuthorityId;
	}
	
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
