package com.bbasset.inova.model;

import java.math.BigDecimal;

public class Cota {
	
	private Fundo fundo;
	
	//TODO: Mudar para Date ou LocalDateTime
	private String data;
	
	private BigDecimal valor;
	
	
	public Cota(String data, Fundo fundo, BigDecimal valor) {
		super();
		this.data = data;
		this.fundo = fundo;
		this.valor = valor;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setCota(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
