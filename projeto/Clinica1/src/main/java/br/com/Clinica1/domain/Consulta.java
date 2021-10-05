package br.com.Clinica1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@SuppressWarnings("serial")
@Entity

public class Consulta  extends GenericDomain{
	
	@Column(length = 50, nullable = false)
	private int codConsulta;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Medicos medicos;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pacientes pacientes;

	@ManyToOne
	@JoinColumn(nullable = false)
	private PlanoSaude planosaude;
	
	@Column(length = 20, nullable = false)
	private String dataHorario;
	
	@Column(length = 500, nullable = false)
	private String QueixaPaciente;
	
	@Column(length = 500, nullable = false)
	private String Tratamentos;
	
	@Column(length = 500, nullable = false)
	private String Resultados;
	
	public int getCodConsulta() {
		return codConsulta;
	}

	public void setCodConsulta(int codConsulta) {
		this.codConsulta = codConsulta;
	}

	public Medicos getMedicos() {
		return medicos;
	}

	public void setMedicos(Medicos medicos) {
		this.medicos = medicos;
	}

	public Pacientes getPacientes() {
		return pacientes;
	}

	public void setPacientes(Pacientes pacientes) {
		this.pacientes = pacientes;
	}

	public PlanoSaude getPlanosaude() {
		return planosaude;
	}

	public void setPlanosaude(PlanoSaude planosaude) {
		this.planosaude = planosaude;
	}

	public String getDataHorario() {
		return dataHorario;
	}

	public void setDataHorario(String dataHorario) {
		this.dataHorario = dataHorario;
	}

	public String getQueixaPaciente() {
		return QueixaPaciente;
	}

	public void setQueixaPaciente(String queixaPaciente) {
		QueixaPaciente = queixaPaciente;
	}

	public String getTratamentos() {
		return Tratamentos;
	}

	public void setTratamentos(String tratamentos) {
		Tratamentos = tratamentos;
	}

	public String getResultados() {
		return Resultados;
	}

	public void setResultados(String resultados) {
		Resultados = resultados;
	}

	
	

}
