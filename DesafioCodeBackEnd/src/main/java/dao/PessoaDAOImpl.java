package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Pessoa;
import util.JpaUtil;

public class PessoaDAOImpl implements PessoaDAO {

	@Override
	public boolean inserirPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Pessoa pesBase = ent.find(Pessoa.class, pessoa.getCpf());
		if (pesBase == null) {
			ent.persist(pessoa);
			trans.commit();
		} else {
			retorno = false;
		}

		ent.close();
		return retorno;
	}

	@Override
	public boolean alterarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Pessoa pesBase = ent.find(Pessoa.class, pessoa.getCpf());
		if (pesBase == null) {
			ent.merge(pessoa);
			trans.commit();
		} else {
			retorno = false;
			System.out.println("Pessoa não localizada!");
		}

		ent.close();
		return retorno;
	}

	@Override
	public boolean excluirPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Pessoa pesBase = ent.find(Pessoa.class, pessoa.getCpf());
		if (pesBase == null) {
			ent.remove(pesBase);
			trans.commit();
		} else {
			retorno = false;
			System.out.println("Pessoa não localizada!");
		}

		ent.close();
		return retorno;
	}

	@Override
	public Pessoa pesquisarPessoa(String cpf) {
		// TODO Auto-generated method stub

		EntityManager ent = JpaUtil.getEntityManager();
		Pessoa retorno = ent.find(Pessoa.class, cpf);

		return retorno;
	}

	@Override
	public List<Pessoa> listarTodos() {
		// TODO Auto-generated method stub

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Pessoa p");

		List<Pessoa> pessoas = query.getResultList();

		return pessoas;
	}

}
