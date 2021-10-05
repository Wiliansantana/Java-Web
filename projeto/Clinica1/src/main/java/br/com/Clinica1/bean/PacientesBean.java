package br.com.Clinica1.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import br.com.Clinica1.DAO.PacientesDAO;
import br.com.Clinica1.domain.Pacientes;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PacientesBean implements Serializable {
	private Pacientes pacientes;
	private List<Pacientes> paciente;

	public Pacientes getPacientes() {
		return pacientes;
	}

	public void setPacientes(Pacientes pacientes) {
		this.pacientes = pacientes;
	}

	public List<Pacientes> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Pacientes> paciente) {
		this.paciente = paciente;
	}

	@PostConstruct
	public void listar() {
		try {
			PacientesDAO pacientesDAO = new PacientesDAO();
			paciente = pacientesDAO.listar();
		} catch (RuntimeException erro) {
			Messages.
			addGlobalError("Ocorreu um erro ao tentar listar os pacientes");
			erro.printStackTrace();
		}
	}

	public void novo() {
		pacientes = new Pacientes();
	}

	public void salvar() {
		try {
			PacientesDAO pacientesDAO = new PacientesDAO();
			pacientesDAO.merge(pacientes);

			pacientes = new Pacientes();
			paciente = pacientesDAO.listar();

			Messages.addGlobalInfo("Paciente salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o paciente");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			pacientes = (Pacientes) evento.getComponent().
					getAttributes().get("pacientesSelecionado");

			PacientesDAO pacientesDAO = new PacientesDAO();
			pacientesDAO.excluir(pacientes);
			
			paciente = pacientesDAO.listar();

			Messages.addGlobalInfo("Paciente removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.
			addFlashGlobalError("Ocorreu um erro ao tentar remover o paciente");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		pacientes = (Pacientes) evento.
				getComponent().
				getAttributes().get("pacientesSelecionado");
	}

}