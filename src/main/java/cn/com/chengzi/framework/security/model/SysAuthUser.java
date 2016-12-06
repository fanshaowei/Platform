package cn.com.chengzi.framework.security.model;

public class SysAuthUser extends SysUsers{
	
	private static final long serialVersionUID = -2733697532506718275L;
	private int role_id;

	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
}
