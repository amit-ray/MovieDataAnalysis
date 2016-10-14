package com.amit.fragma.model;

public class User {
private int id;
private String gender;
private int age;
private int zipcode;
private String ocupation;
public String getOcupation() {
	return ocupation;
}
public void setOcupation(String ocupation) {
	this.ocupation = ocupation;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getZipcode() {
	return zipcode;
}
public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}
}
