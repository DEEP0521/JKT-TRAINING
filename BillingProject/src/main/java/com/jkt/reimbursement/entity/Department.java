
package com.jkt.reimbursement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name = "department_id")
	private int departmentId;

	@Column(name = "department_code")
	private String departmentCode;

	@Column(name = "department_name")
	private String departmentName;

	@ManyToOne
	@JoinColumn(name = "sbu_id")
	private Sbu sbu_id;

	@Column(name = "direct_indirect")
	private String directIndirect;

	

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Sbu getSbu_id() {
		return sbu_id;
	}

	public void setSbu_id(Sbu sbu_id) {
		this.sbu_id = sbu_id;
	}

	public String getDirectIndirect() {
		return directIndirect;
	}

	public void setDirectIndirect(String directIndirect) {
		this.directIndirect = directIndirect;
	}
	
	
	
	

}
