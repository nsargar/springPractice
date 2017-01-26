package com.app.spring.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the servicetype database table.
 * 
 */
@Entity
//@NamedQuery(name="Servicetype.findAll", query="SELECT s FROM Servicetype s")
public class Servicetype implements Serializable {
	@Override
	public String toString() {
		return "Servicetype [id=" + id + ", price=" + price + ", requesttype="
				+ requesttype + "]";
	}

	private static final long serialVersionUID = 1L;
	private int id;
	private String price;
	private String requesttype;

	public Servicetype() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public String getRequesttype() {
		return this.requesttype;
	}

	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}

}