package br.com.Clinica1.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import br.com.Clinica1.DAO.PlanoSaudeDAO;
import br.com.Clinica1.domain.PlanoSaude;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PlanoSaudeBean implements Serializable {
	private PlanoSaude planosaude;
	private List<PlanoSaude> planoss;

	public PlanoSaude getPlanoSaude() {
		return planosaude;
	}

	public void setPlanoSaude(PlanoSaude planosaude) {
		this.planosaude = planosaude;
	}

	public List<PlanoSaude> getPlanoss() {
		return planoss;
	}

	public void setPlanoss(List<PlanoSaude> planoss) {
		this.planoss = planoss;
	}

	@PostConstruct
	public void listar() {
		try {
			PlanoSaudeDAO planosaudeDAO = new PlanoSaudeDAO();
			planoss = planosaudeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.
			addGlobalError("Ocorreu um erro ao tentar listar os planoss");
			erro.printStackTrace();
		}
	}

	public void novo() {
		planosaude = new PlanoSaude();
	}

	public void salvar() {
		try {
			PlanoSaudeDAO planosaudeDAO = new PlanoSaudeDAO();
			planosaudeDAO.merge(planosaude);

			planosaude = new PlanoSaude();
			planoss = planosaudeDAO.listar();

			Messages.addGlobalInfo("PlanoSaude salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o planosaude");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			planosaude = (PlanoSaude) evento.getComponent().
					getAttributes().get("planosaudeSelecionado");

			PlanoSaudeDAO planosaudeDAO = new PlanoSaudeDAO();
			planosaudeDAO.excluir(planosaude);
			
			planoss = planosaudeDAO.listar();

			Messages.addGlobalInfo("PlanoSaude removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.
			addFlashGlobalError("Ocorreu um erro ao tentar remover o planosaude");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		planosaude = (PlanoSaude) evento.
				getComponent().
				getAttributes().get("planosaudeSelecionado");
	}

}