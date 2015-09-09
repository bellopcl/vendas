package com.sistemas.cliente;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class ClienteDAOH implements ClienteDAO {
	
	private Session sessao;
	public void salvar(Cliente cliente) {
		this.sessao.save(cliente);

	}
	
	public Session getSessao() {
		return sessao;
	}
	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void alterar(Cliente cliente) {
		this.sessao.update(cliente);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		Criteria lista = sessao.createCriteria(Cliente.class);
		return lista.list();
	}

	@Override
	public void excluir(Cliente cliente) {
		this.sessao.delete(cliente);
		
	}

	@Override
	public Cliente pesquisar(String string) {
		Query consultaNome = this.sessao.createQuery("from cliente c.nome like :nome");
		consultaNome.setString("nome", "%" + string + "%");
		return (Cliente) consultaNome.uniqueResult();
	}
}
