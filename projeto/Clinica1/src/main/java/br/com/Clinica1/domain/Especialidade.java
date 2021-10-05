package br.com.Clinica1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class Especialidade extends GenericDomain{

	@Column(length = 50, nullable = false)
	private int codigoCRM;
	
	@Column(length = 45, nullable = false)
	private String nomeEspecialidade;
	
	
	
	public int getCodigoCRM() {
		return codigoCRM;
	}

	public void setCodigoCRM(int codigoCRM) {
		this.codigoCRM = codigoCRM;
	}

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}

	
	

}
