package com.jkt.reimbursement.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name="sbu")
public class Sbu {

	@Id
	@Column(name="sbu_id")
	private int sbuId;
	
	@Column(name="sbu_code")
	private String sbuCode;
	
	@Column(name="sbu_name")
	private String sbuName;
}
