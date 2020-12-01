package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa {

	@Id
	@Column(name = "CPF", nullable = false)
	private String cpf;
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "IDADE", nullable = false)
	private int idade;
	@Column(name = "GENERO", nullable = false)
	private String genero;
	@Column(name = "TELEFONE", nullable = false)
	private int telefone;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "SENHA", nullable = false)
	private String senha;
	@Column(name = "PROFISSAO", nullable = false)
	private String profissao;
	@Column(name = "CIDADE", nullable = false)
	private String cidade;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
