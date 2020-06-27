
package com.jkt.reimbursement.entity;

import java.sql.Timestamp;
//import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "users")
public class Users {

	@Id

	@Column(name = "username")
	private String id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "enabled")
	private char enabled;

	@Column(name = "updated_by")
	private String updated_by;

	@Column(name = "updated_date")
	private Timestamp updated_date;

	@OneToOne
	@JoinColumn(name = "department_id")
	private Department departmentId;

	@Column(name = "base_location")
	private String base_location;

	@Column(name = "emp_category")
	private String emp_category;

	private String lineManager;

	@Column(name = "workingstatus")
	private String workingStatus;

	@Column(name = "isLineManager")
	private int isLineManager;

	
	//@Column(name = "skillset_email_reminder")
	//private byte skillset_email_reminder;

	@Column(name = "defaulter_email_reminder")
	private int defaulter_email_reminder;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
    private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "joiningDate")
	//DateTimeFormatter joiningDate =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private Date joiningDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deactivatedDate")
	private Date deactivatedDate;

	@Column(name = "updatedCV_date")
	private Date updatedCV_date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastMailSent")
	private Date lastMailSent;

	@Column(name = "resume_status")
	private String resume_status;

	@Column(name = "manager_notes")
	private String manager_notes;

	@Column(name = "mobile_attendance")
	private String mobile_attendance;

	public Users() {

	}

	public Users(String id, String first_name, String last_name, String password, String email, char enabled,
			String updated_by, Timestamp updated_date, Department departmentId, String base_location,
			String emp_category, String lineManager, String workingStatus,
			 int defaulter_email_reminder,Date createdDate,Date lastMailSent,
			 Date updatedCV_date,int isLineManager,Date joiningDate,Date deactivatedDate,
			String resume_status, String manager_notes, String mobile_attendance) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.updated_by = updated_by;
		this.updated_date = updated_date;
		this.departmentId = departmentId;
		this.base_location = base_location;
		this.emp_category = emp_category;
		this.lineManager = lineManager;
		this.workingStatus = workingStatus;
		this.isLineManager = isLineManager;
		//this.skillset_email_reminder = skillset_email_reminder;
		this.defaulter_email_reminder = defaulter_email_reminder;
		this.createdDate = createdDate;
		this.joiningDate = joiningDate;
		this.deactivatedDate = deactivatedDate;
		this.updatedCV_date = updatedCV_date;
		this.lastMailSent = lastMailSent;
		this.resume_status = resume_status;
		this.manager_notes = manager_notes;
		this.mobile_attendance = mobile_attendance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getEnabled() {
		return enabled;
	}

	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public Timestamp getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentid(Department departmentId) {
		this.departmentId = departmentId;
	}

	public String getBase_location() {
		return base_location;
	}

	public void setBase_location(String base_location) {
		this.base_location = base_location;
	}

	public String getEmp_category() {
		return emp_category;
	}

	public void setEmp_category(String emp_category) {
		this.emp_category = emp_category;
	}

	public String getLineManager() {
		return lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}

	public String getWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(String workingStatus) {
		this.workingStatus = workingStatus;
	}

	public int getIsLineManager() {
		return isLineManager;
	}

	public void setIsLineManager(int isLineManager) {
		this.isLineManager = isLineManager;
	}

	//public byte getSkillset_email_reminder() {
		//return skillset_email_reminder;
	//}

	//public void setSkillset_email_reminder(byte skillset_email_reminder) {
		//this.skillset_email_reminder = skillset_email_reminder;
	//}

	public int getDefaulter_email_reminder() {
		return defaulter_email_reminder;
	}

	public void setDefaulter_email_reminder(int defaulter_email_reminder) {
		this.defaulter_email_reminder = defaulter_email_reminder;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.sql.Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate ) {
		this.joiningDate = joiningDate;
	}

	public Date getDeactivatedDate() {
		return deactivatedDate;
	}

	public void setDeactivatedDate(Date deactivatedDate) {
		this.deactivatedDate = deactivatedDate;
	}

	public Date getUpdatedCV_date() {
		return updatedCV_date;
	}

	public void setUpdatedCV_date(Date updatedCV_date) {
		this.updatedCV_date = updatedCV_date;
	}

	public Date getLastMailSent() {
		return lastMailSent;
	}

	//public void setLastMailSent(Date lastMailSent) {
		//this.lastMailSent = lastMailSent;
	//}

	public String getResume_status() {
		return resume_status;
	}

	public void setResume_status(String resume_status) {
		this.resume_status = resume_status;
	}

	public String getManager_notes() {
		return manager_notes;
	}

	public void setManager_notes(String manager_notes) {
		this.manager_notes = manager_notes;
	}

	public String getMobile_attendance() {
		return mobile_attendance;
	}

	public void setMobile_attendance(String mobile_attendance) {
		this.mobile_attendance = mobile_attendance;
	}
	
}
