package br.com.Clinica1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class Pacientes extends GenericDomain{
	
	@Column(length = 50, nullable = false)
	private int cpf;
	
	@Column(length = 200, nullable = false)
	private String nome;
	
	@Column(length = 14, nullable = false)
	private String telefone;
	
	@Column(length = 200, nullable = false)
	private String endereco;
	
	@Column(length = 14, nullable = false)
	private String dataNascimento;
	
	@Column(length = 50, nullable = false)
	private String profissao;
	
	
	
	public int getCpf() {
		return cpf;
	}

	public void setCodigo(int codigo) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}



}
