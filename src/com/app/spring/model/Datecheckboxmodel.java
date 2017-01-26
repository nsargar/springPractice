package com.app.spring.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Datecheckboxmodel {
	
	
	boolean ispd;
	String aldate;
	
	public String getAldate() {
		return aldate;
	}
	public void setAldate(String aldate) {
		this.aldate = aldate;
	}
	@Override
	public String toString() {
		return "DateCheckbocModel [ispd=" + ispd + ", aldate=" + aldate + "]";
	}
	public boolean isIspd() {
		return ispd;
	}

	public void setIspd(boolean ispd) {
		this.ispd = ispd;
	}	public Datecheckboxmodel() {
		// TODO Auto-generated constructor stub
	}

}
