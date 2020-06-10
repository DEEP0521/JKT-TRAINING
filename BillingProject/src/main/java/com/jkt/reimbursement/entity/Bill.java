package com.jkt.reimbursement.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String type;
	String month;
	
	@Lob
	byte[] file;
	
	@ManyToOne
	private Users user;
	
	public Bill() {
		super();
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", type=" + type + ", month=" + month + ", file=" + Arrays.toString(file) + ", user="
				+ user + "]";
	}

}
