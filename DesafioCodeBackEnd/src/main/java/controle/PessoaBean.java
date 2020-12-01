package controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;

import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import entidade.Pessoa;

@ManagedBean(name = "PessoaBean")
@SessionScoped
public class PessoaBean {

	private Pessoa pessoa;

	private List<Pessoa> listaPessoas;
	private String cpfPessoa;

	private PessoaDAO pessoaDAO;

	public PessoaBean() {
		this.iniciarCampor();
		this.pessoaDAO = new PessoaDAOImpl();
	}

	private void iniciarCampor() {
		this.pessoa = new Pessoa();

		//HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// this.pessoa.setCpf((cpf)sessao.getAttribute("pessoaLogada"));

	}

	public void inserirPessoa() {

		this.pessoaDAO.inserirPessoa(this.pessoa);
		this.iniciarCampor();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Pessoa cadastrada!"));

	}

	public void pesquisarPessoa() {

		this.listaPessoas = this.pessoaDAO.listarTodos();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Pessoa pesquisada!"));

	}

	public void excluirPessoa() {

		Pessoa pessoaRemover = null;
		for (Pessoa pessoaLista : listaPessoas) {
			if (this.cpfPessoa == pessoaLista.getCpf()) {
				pessoaRemover = pessoaLista;
			}
		}
		if (pessoaRemover != null) {
			this.pessoaDAO.excluirPessoa(pessoaRemover);
			this.pesquisarPessoa();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Pessoa removida!"));
		}

	}

	public void alterarPessoa() {

		this.pessoaDAO.alterarPessoa(pessoa);
		this.iniciarCampor();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Pessoa atualizada!"));

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}

	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

}
