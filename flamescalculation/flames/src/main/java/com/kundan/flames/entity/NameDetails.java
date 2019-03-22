package com.kundan.flames.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class NameDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "num", updatable = false, nullable = false)
int num;
String emailid;
String name1;
String name2;
String flamedata;
public NameDetails() {}
public void setFlamedata(String flamedata) {
	this.flamedata = flamedata;
}
public String getFlamedata() {
	return flamedata;
}
@Override
public String toString() {
	return "NameDetails [num=" + num + ", emailid=" + emailid + ", name1=" + name1 + ", name2=" + name2 + ", flamedata="
			+ flamedata + "]";
}

public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getName1() {
	return name1;
}
public void setName1(String name1) {
	this.name1 = name1;
}
public String getName2() {
	return name2;
}
public void setName2(String name2) {
	this.name2 = name2;
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

	
}
