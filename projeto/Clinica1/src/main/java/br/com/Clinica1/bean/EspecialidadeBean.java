package br.com.Clinica1.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import br.com.Clinica1.DAO.EspecialidadeDAO;
import br.com.Clinica1.domain.Especialidade;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EspecialidadeBean implements Serializable {
	private Especialidade especialidade;
	private List<Especialidade> especialidades;

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	@PostConstruct
	public void listar() {
		try {
			EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
			especialidades = especialidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.
			addGlobalError("Ocorreu um erro ao tentar listar os Especialidades");
			erro.printStackTrace();
		}
	}

	public void novo() {
		especialidade = new Especialidade();
	}

	public void salvar() {
		try {
			EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
			especialidadeDAO.merge(especialidade);

			especialidade = new Especialidade();
			especialidades = especialidadeDAO.listar();

			Messages.addGlobalInfo("Especialidades salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Especialidades");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			especialidade = (Especialidade) evento.getComponent().
					getAttributes().get("especialidadeSelecionado");

			EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
			especialidadeDAO.excluir(especialidade);
			
			especialidades = especialidadeDAO.listar();

			Messages.addGlobalInfo("Especialidade removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.
			addFlashGlobalError("Ocorreu um erro ao tentar remover o Especialidade");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		especialidade = (Especialidade) evento.
				getComponent().
				getAttributes().get("especialidadeSelecionado");
	}

}