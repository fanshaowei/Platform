package cn.com.chengzi.framework.organizer.model;

import java.io.Serializable;
import java.sql.Date;

public class SysOrganizerInfo implements Serializable{
	private static final long serialVersionUID = -5254902716859366792L;
	
    private int organizer_id;
    private String organizer_name;
    private String organizer_memo;
    private String phone_number;
    private String is_valid;
    private int parent_org_id;
    private int organizer_type;
    private Date begindate;
    private Date enddate;
    private int status;
    
	public int getOrganizer_id() {
		return organizer_id;
	}
	public void setOrganizer_id(int organizer_id) {
		this.organizer_id = organizer_id;
	}
	public String getOrganizer_name() {
		return organizer_name;
	}
	public void setOrganizer_name(String organizer_name) {
		this.organizer_name = organizer_name;
	}
	public String getOrganizer_memo() {
		return organizer_memo;
	}
	public void setOrganizer_memo(String organizer_memo) {
		this.organizer_memo = organizer_memo;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}
	public int getParent_org_id() {
		return parent_org_id;
	}
	public void setParent_org_id(int parent_org_id) {
		this.parent_org_id = parent_org_id;
	}
	public int getOrganizer_type() {
		return organizer_type;
	}
	public void setOrganizer_type(int organizer_type) {
		this.organizer_type = organizer_type;
	}
	public Date getBegindate() {
		return begindate;
	}
	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
    
}
