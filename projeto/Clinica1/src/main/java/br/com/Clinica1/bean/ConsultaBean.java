package br.com.Clinica1.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import br.com.Clinica1.DAO.ConsultaDAO;
import br.com.Clinica1.domain.Consulta;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ConsultaBean implements Serializable {
	private Consulta consulta;
	private List<Consulta> consultas;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@PostConstruct
	public void listar() {
		try {
			ConsultaDAO consultaDAO = new ConsultaDAO();
			consultas = consultaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.
			addGlobalError("Ocorreu um erro ao tentar listar as consultas");
			erro.printStackTrace();
		}
	}

	public void novo() {
		consulta = new Consulta();
	}

	public void salvar() {
		try {
			ConsultaDAO consultaDAO = new ConsultaDAO();
			consultaDAO.merge(consulta);

			consulta = new Consulta();
			consultas = consultaDAO.listar();

			Messages.addGlobalInfo("Consulta salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o consulta");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			consulta = (Consulta) evento.getComponent().
					getAttributes().get("consultaSelecionado");

			ConsultaDAO consultaDAO = new ConsultaDAO();
			consultaDAO.excluir(consulta);
			
			consultas = consultaDAO.listar();

			Messages.addGlobalInfo("Consulta removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.
			addFlashGlobalError("Ocorreu um erro ao tentar remover o consulta");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		consulta = (Consulta) evento.
				getComponent().
				getAttributes().get("consultaSelecionado");
	}

}