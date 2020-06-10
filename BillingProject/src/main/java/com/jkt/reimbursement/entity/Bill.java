package com.jkt.reimbursement.entity;

import java.io.File;
import java.sql.Blob;
import java.util.Arrays;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String type,start_date,end_date;
	
	 @Lob
	  byte[] file;
	
	// @Lob
	 //private MultipartFile  file;
	
	
	@ManyToOne
	private Users user;
	
	
	
	
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Bill(String type, String start_date, String end_date, byte[]  file, Users user) {
		super();
		this.type = type;
		this.start_date = start_date;
		this.end_date = end_date;
		this.file = file;
		this.user = user;
	}

	public Bill() {
		super();
	}
	
	
	public Bill( String type, String start_date, String end_date,  byte[]  file) {
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

	public  byte[]  getFile() {
		return file;
	}

	public void setFile(  byte[]   file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", type=" + type + ", start_date=" + start_date + ", end_date=" + end_date + ", file="
				+ file + ", user=" + user + "]";
	}

	


}
