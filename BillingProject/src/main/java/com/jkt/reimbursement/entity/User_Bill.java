package com.jkt.reimbursement.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User_Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String type,start_date,end_date;
	byte[] file;
	
	public User_Bill() {
		super();
	}
	
	public User_Bill(int id, String type, String start_date, String end_date, byte[] file) {
		super();
		this.id = id;
		this.type = type;
		this.start_date = start_date;
		this.end_date = end_date;
		this.file = file;
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

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", type=" + type + ", start_date=" + start_date + ", end_date=" + end_date + ", file="
				+ Arrays.toString(file) + "]";
	}

}
