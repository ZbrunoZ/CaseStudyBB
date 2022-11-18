package com.bbasset.inova.model;

import java.math.BigDecimal;

public class Cota {
	
	private Fundo fundo;
	
	private String data;
	
	private BigDecimal cota;
	
	
	public Cota(String data, Fundo fundo, BigDecimal cota) {
		super();
		this.data = data;
		this.fundo = fundo;
		this.cota = cota;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Fundo getFundo() {
		return fundo;
	}

	public void setFundo(Fundo fundo) {
		this.fundo = fundo;
	}

	public BigDecimal getCota() {
		return cota;
	}

	public void setCota(BigDecimal cota) {
		this.cota = cota;
	}
	
	
}
