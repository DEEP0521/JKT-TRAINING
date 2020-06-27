package com.jkt.reimbursement.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "type")
	String type;
	
	@Column(name = "month")
	String month;
	
	@Column(name = "remark")
	String remark;
	
	@Lob
	@Column(name = "file")
	byte[] file;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private Users user;
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", type=" + type + ", month=" + month + ", remark=" + remark + ", file="
				+ Arrays.toString(file) + ", user=" + user + "]";
	}

}
