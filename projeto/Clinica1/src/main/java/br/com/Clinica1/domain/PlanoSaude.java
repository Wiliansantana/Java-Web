package br.com.Clinica1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity


public class PlanoSaude extends GenericDomain {
	
	public String getCodigo1() {
		return codigo1;
	}

	public void setCodigo1(String codigo1) {
		this.codigo1 = codigo1;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(length = 50, nullable = false)
	private String codigo1;
	
	@Column(length = 45, nullable = false)
	private String CNPJ;
	
	@Column(length = 200, nullable = false)
	private String RazaoSocial;
	
	@Column(length = 200, nullable = false)
	private String endereco;
	
	@Column(length = 14, nullable = false)
	private String telefone;
	
	
	

}
