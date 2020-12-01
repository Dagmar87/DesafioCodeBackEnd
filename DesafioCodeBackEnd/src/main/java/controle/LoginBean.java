package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import entidade.Pessoa;

@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean {

	private String cpfTela;
	private String senhaTela;
	private Pessoa pessoa;

	private PessoaDAO pessoaDAO;

	public LoginBean() {
		this.pessoa = new Pessoa();
		this.pessoaDAO = new PessoaDAOImpl();
	}

	public String entrar() {

		Pessoa pessoaBanco = this.pessoaDAO.pesquisarPessoa(this.cpfTela);
		System.out.println(pessoaBanco);
		if (pessoaBanco != null) {
			if (pessoaBanco.getSenha().equals(this.senhaTela)) {
				HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
						.getSession(true);
				sessao.setAttribute("pessoaLogada", pessoaBanco);
				return "telaPrincipal.xhtml?faces-redirect=true&amp;includeViewParams=true";
			} else {
				System.out.println("-- Senha invalida --");
			}
		} else {
			System.out.println("-- Pessoa invalida --");
		}

		return "";

	}

	public String getCpfTela() {
		return cpfTela;
	}

	public void setCpfTela(String cpfTela) {
		this.cpfTela = cpfTela;
	}

	public String getSenhaTela() {
		return senhaTela;
	}

	public void setSenhaTela(String senhaTela) {
		this.senhaTela = senhaTela;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
