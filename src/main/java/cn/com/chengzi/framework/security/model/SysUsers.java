package cn.com.chengzi.framework.security.model;

import java.io.Serializable;

public class SysUsers implements Serializable{  
	private static final long serialVersionUID = 2160300746098783904L;
	private int user_id;
	private String user_name;
	private String user_account;    
    private String user_password;
    private String is_valid;
    private int organizer_id;
    private String is_admin;
    private String mobile_number;
    private String phone_number;
    
    public SysUsers(){}
    
    public SysUsers(int user_id){
    	this.user_id = user_id;
    }        
    
	public SysUsers(int user_id, String user_name, String user_account,
			String user_password, String is_valid, int organizer_id,
			String is_admin, String mobile_number, String phone_number) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_account = user_account;
		this.user_password = user_password;
		this.is_valid = is_valid;
		this.organizer_id = organizer_id;
		this.is_admin = is_admin;
		this.mobile_number = mobile_number;
		this.phone_number = phone_number;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}
	public int getOrganizer_id() {
		return organizer_id;
	}
	public void setOrganizer_id(int organizer_id) {
		this.organizer_id = organizer_id;
	}
	public String getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}	
    
}
