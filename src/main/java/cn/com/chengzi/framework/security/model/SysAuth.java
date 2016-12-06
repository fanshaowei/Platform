package cn.com.chengzi.framework.security.model;

import java.util.List;

public class SysAuth extends SysAuthorities{
	private static final long serialVersionUID = -8945363599617709677L;
	
	private List<SysAuth> children;
	private int childrenCount=0;
	
	public List<SysAuth> getChildren() {
		return children;
	}

	public void setChildren(List<SysAuth> children) {
		this.children = children;
	}

	public int getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}
	
}
