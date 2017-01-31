package com.app.spring.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the servicerequest database table.
 * 
 */
@Entity
//@NamedQuery(name="Servicerequest.findAll", query="SELECT s FROM Servicerequest s")
public class Servicerequest implements Serializable {
	public Servicerequest(Timestamp allottdate, int cid,
			int ispickdrop, int isprocessed, Timestamp reqdate, int spid) {
		super();
		
		this.allottdate = allottdate;
		this.cid = cid;
		this.ispickdrop = ispickdrop;
		this.isprocessed = isprocessed;
		this.reqdate = reqdate;
		this.spid = spid;
	}


	@Override
	public String toString() {
		return "Servicerequest [id=" + id + ", allottdate=" + allottdate
				+ ", cid=" + cid + ", ispickdrop=" + ispickdrop
				+ ", isprocessed=" + isprocessed + ", reqdate=" + reqdate
				+ ", spid=" + spid + "]";
	}

	private static final long serialVersionUID = 1L;
	private int id;
	private Timestamp allottdate;
	private int cid;
	private int ispickdrop;
	private int isprocessed;
	private Timestamp reqdate;
	private int spid;

	public Servicerequest() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Timestamp getAllottdate() {
		return this.allottdate;
	}

	public void setAllottdate(Timestamp allottdate) {
		this.allottdate = allottdate;
	}


	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getIspickdrop() {
		return this.ispickdrop;
	}

	public void setIspickdrop(int ispickdrop) {
		this.ispickdrop = ispickdrop;
	}


	public int getIsprocessed() {
		return this.isprocessed;
	}

	public void setIsprocessed(int isprocessed) {
		this.isprocessed = isprocessed;
	}


	public Timestamp getReqdate() {
		return this.reqdate;
	}

	public void setReqdate(Timestamp reqdate) {
		this.reqdate = reqdate;
	}


	public int getSpid() {
		return this.spid;
	}

	public void setSpid(int spid) {
		this.spid = spid;
	}

}