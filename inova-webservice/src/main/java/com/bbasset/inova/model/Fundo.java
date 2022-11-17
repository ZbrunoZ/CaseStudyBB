package com.bbasset.inova.model;

public class Fundo {
	
	private Long codigo;
	
	private String nome;
	
	private String cnpj;
	
	private String dataAbertura;
	
	private String dataEncerramento;
	
	private String risco;
	
	
	public Fundo(Long codigo, String nome, String cnpj, String dataAbertura, String dataEncerramento, String risco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataEncerramento;
		this.risco = risco;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(String dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

	@Override
	public String toString() {
		return "Fundo [codigo=" + codigo + ", nome=" + nome + ", cnpj=" + cnpj + ", dataAbertura=" + dataAbertura
				+ ", dataEncerramento=" + dataEncerramento + ", risco=" + risco + "]";
	}
	
	
	


}
