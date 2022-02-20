package com.ite.luis.modelo.entitybeans;

import java.io.Serializable;

public class Info implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int quedanPlazas;

	public Info() {
		super();
	}

	public int getQuedan_plazas() {
		return quedanPlazas;
	}

	public void setQuedan_plazas(int quedanPlazas) {
		this.quedanPlazas = quedanPlazas;
	}

}
