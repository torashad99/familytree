package com.familytree.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Person {
	
	@Id
	@GenericGenerator(name="seq_id", strategy="com.familytree.backend.model.StockCodeGenerator")
	@GeneratedValue(generator="seq_id")
	private String pID;
	
	private String pname;
	
	private String dob;
	
	private String lob;
	
	public Person(){}
	
	public Person(
			@JsonProperty("pid") String uID, 
			@JsonProperty("name") String name, 
			@JsonProperty("dob") String dob,
			@JsonProperty("lob") String lob) {
		pID = uID;
		this.pname = name;
		//System.out.println("From Person: " + name);
		this.dob = dob;
		this.lob = lob;
	}

	public String getPID() {
		return pID;
	}

	public String getPname() {
		return pname;
	}

	public String getDob() {
		return dob;
	}

	public String getLob() {
		return lob;
	}
	
	public void setPID(String pID) {
		this.pID = pID;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public void setLob(String lob) {
		this.lob = lob;
	}
}
