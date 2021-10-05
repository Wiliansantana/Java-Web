package br.com.Clinica1.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import br.com.Clinica1.DAO.MedicosDAO;
import br.com.Clinica1.domain.Medicos;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MedicosBean implements Serializable {
	private Medicos medicos;
	private List<Medicos> medico;

	public Medicos getMedicos() {
		return medicos;
	}

	public void setMedicos(Medicos medicos) {
		this.medicos = medicos;
	}

	public List<Medicos> getMedico() {
		return medico;
	}

	public void setMedico(List<Medicos> Medico) {
		this.medico = medico;
	}

	@PostConstruct
	public void listar() {
		try {
			MedicosDAO medicosDAO = new MedicosDAO();
			medico = medicosDAO.listar();
		} catch (RuntimeException erro) {
			Messages.
			addGlobalError("Ocorreu um erro ao tentar listar os Medicos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		medicos = new Medicos();
	}

	public void salvar() {
		try {
			MedicosDAO medicosDAO = new MedicosDAO();
			medicosDAO.merge(medicos);

			medicos = new Medicos();
			medico = medicosDAO.listar();

			Messages.addGlobalInfo("Medicos salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar  Medicos");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			medicos = (Medicos) evento.getComponent().
					getAttributes().get("medicosSelecionado");

			MedicosDAO medicosDAO = new MedicosDAO();
			medicosDAO.excluir(medicos);
			
			medico = medicosDAO.listar();

			Messages.addGlobalInfo("Medicos removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.
			addFlashGlobalError("Ocorreu um erro ao tentar remover medicos");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		medicos = (Medicos) evento.
				getComponent().
				getAttributes().get("medicosSelecionado");
	}

}