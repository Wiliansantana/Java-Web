package br.com.Clinica1.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@SuppressWarnings("serial")
@Entity

public class Atendimentos extends GenericDomain {
	@Column(length = 50, nullable = false)
	private int codigos;
	
	@Column(length = 45, nullable = false)
	private String diaSemana;
	
	@Column(length = 5, nullable = false)
	private String horarioInicio;
	
	@Column(length = 5, nullable = false)
	private String horarioFinal;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Medicos medicos;
	
	
	
	public int getCodigos() {
		return codigos;
	}

	public void setCodigo(int codigo) {
		this.codigos = codigo;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public Medicos getMedicos() {
		return medicos;
	}

	public void setMedicos(Medicos medicos) {
		this.medicos = medicos;
	}

	

}
