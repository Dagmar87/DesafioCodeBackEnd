package servico;

import java.awt.Desktop;
import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import entidade.Pessoa;
import entidade.RetornoPessoa;

@Path("/pessoa")
public class PessoaServico {

	PessoaDAO pessoaDAO;

	public PessoaServico() {
		this.pessoaDAO = new PessoaDAOImpl();
	}

	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Pessoa DesafioCodeBackEnd !!!";
	}

	@Path("/inserirPessoa")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoPessoa inserirPessoa(Pessoa pessoa) {

		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (!this.pessoaDAO.inserirPessoa(pessoa)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Pessoa não inserida!!");
		}

		return retorno;

	}

	@Path("/alterarPessoa")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoPessoa alterarPessoa(Pessoa pessoa) {

		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (!this.pessoaDAO.alterarPessoa(pessoa)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Pessoa não atualizada!!");
		}

		return retorno;

	}

	@Path("/excluirPessoa")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoPessoa excluirPessoa(Pessoa pessoa) {

		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (!this.pessoaDAO.excluirPessoa(pessoa)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Pessoa não removida!!");
		}

		return retorno;

	}

	@Path("/pesquisarPessoa")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoPessoa pesquisarPessoa(Pessoa pessoa) {

		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (this.pessoaDAO.pesquisarPessoa(pessoa.getCpf()) == null) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Pessoa não encontrada!!!!");
		}

		return retorno;

	}

	@Path("/login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoPessoa login(Pessoa pessoa) {

		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		Pessoa recuperadoBase = pessoaDAO.pesquisarPessoa(pessoa.getCpf());

		if (!(recuperadoBase != null && recuperadoBase.getSenha().equals(pessoa.getSenha()))) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Pessoa invalida!!!");
		}

		if (retorno.getCodigoRetorno() == 0) {
			System.out.println("LOGADO");
			try {
				URI link = new URI("www.globo.com");
				Desktop.getDesktop().browse(link);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return retorno;

	}

}
