package com.jai.springboot.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {

	public Address() {
	}

	@Id
	private String id;
	
	private String line1;
	private String line2;
	private String postCode;
	private String city;
	private String country;
	
	
	
	/**
	 * @param id
	 * @param line1
	 * @param line2
	 * @param postCode
	 * @param city
	 * @param country
	 */
	public Address(String id, String line1, String line2, String postCode, String city, String country) {
		super();
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getLine1() {
		return line1;
	}



	public void setLine1(String line1) {
		this.line1 = line1;
	}



	public String getLine2() {
		return line2;
	}



	public void setLine2(String line2) {
		this.line2 = line2;
	}



	public String getPostCode() {
		return postCode;
	}



	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", postCode=" + postCode + ", city=" + city + ", country=" + country
				+ "]";
	}

	

}
