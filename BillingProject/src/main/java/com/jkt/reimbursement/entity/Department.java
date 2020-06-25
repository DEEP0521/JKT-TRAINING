
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

}
