package br.com.Clinica1.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import br.com.Clinica1.DAO.AtendimentosDAO;
import br.com.Clinica1.domain.Atendimentos;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AtendimentosBean implements Serializable {
	private Atendimentos atendimentos;
	private List<Atendimentos> at;

	public Atendimentos getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(Atendimentos atendimentos) {
		this.atendimentos = atendimentos;
	}

	public List<Atendimentos> getAt() {
		return at;
	}

	public void setAt(List<Atendimentos> at) {
		this.at = at;
	}

	@PostConstruct
	public void listar() {
		try {
			AtendimentosDAO atendimentosDAO = new AtendimentosDAO();
			at = atendimentosDAO.listar();
		} catch (RuntimeException erro) {
			Messages.
			addGlobalError("Ocorreu um erro ao tentar listar os atendimentos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		atendimentos = new Atendimentos();
	}

	public void salvar() {
		try {
			AtendimentosDAO atendimentosDAO = new AtendimentosDAO();
			atendimentosDAO.merge(atendimentos);

			atendimentos = new Atendimentos();
			at= atendimentosDAO.listar();

			Messages.addGlobalInfo("At salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o at");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			atendimentos = (Atendimentos) evento.getComponent().
					getAttributes().get("atendimentosSelecionado");

			AtendimentosDAO atendimentosDAO = new AtendimentosDAO();
			atendimentosDAO.excluir(atendimentos);
			
			at = atendimentosDAO.listar();

			Messages.addGlobalInfo("At removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.
			addFlashGlobalError("Ocorreu um erro ao tentar remover o at");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		atendimentos = (Atendimentos) evento.
				getComponent().
				getAttributes().get("atendimentosSelecionado");
	}

}