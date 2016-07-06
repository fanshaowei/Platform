package cn.com.chengzi.framework.security.model;

import java.io.Serializable;

public class SysAuthorities implements Serializable{
	private static final long serialVersionUID = -5915721986540815414L;
	
	private int authority_id;
	private int parent_authority_id;
    private String authority_name;
    private int authority_type;
    private String authority_url;
    private String authority_flag;
    private int authority_level;
    private int disp_order;
    private String is_valid;
    private String is_show;
    
	public int getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(int authority_id) {
		this.authority_id = authority_id;
	}
	public int getParent_authority_id() {
		return parent_authority_id;
	}
	public void setParent_authority_id(int parent_authority_id) {
		this.parent_authority_id = parent_authority_id;
	}
	public String getAuthority_name() {
		return authority_name;
	}
	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}
	public int getAuthority_type() {
		return authority_type;
	}
	public void setAuthority_type(int authority_type) {
		this.authority_type = authority_type;
	}
	public String getAuthority_url() {
		return authority_url;
	}
	public void setAuthority_url(String authority_url) {
		this.authority_url = authority_url;
	}
	public String getAuthority_flag() {
		return authority_flag;
	}
	public void setAuthority_flag(String authority_flag) {
		this.authority_flag = authority_flag;
	}
	public int getAuthority_level() {
		return authority_level;
	}
	public void setAuthority_level(int authority_level) {
		this.authority_level = authority_level;
	}
	public int getDisp_order() {
		return disp_order;
	}
	public void setDisp_order(int disp_order) {
		this.disp_order = disp_order;
	}
	public String getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}
	public String getIs_show() {
		return is_show;
	}
	public void setIs_show(String is_show) {
		this.is_show = is_show;
	}       
    
}
