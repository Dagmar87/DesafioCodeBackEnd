package dao;

import java.util.List;

import entidade.Pessoa;

public interface PessoaDAO {

	public boolean inserirPessoa(Pessoa pessoa);

	public boolean alterarPessoa(Pessoa pessoa);

	public boolean excluirPessoa(Pessoa pessoa);

	public Pessoa pesquisarPessoa(String cpf);

	public List<Pessoa> listarTodos();

}
