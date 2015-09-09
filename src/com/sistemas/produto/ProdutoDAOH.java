package com.sistemas.produto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sistemas.cliente.Cliente;

public class ProdutoDAOH implements ProdutoDAO {
	
	private Session sessao;

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	public void salvar(Produto produto) {
		this.sessao.save(produto);

	}

	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		Criteria lista = sessao.createCriteria(Produto.class);
		return lista.list();
	}

	@Override
	public Produto pesquisarPorDescricao(String string) {
		Query consultaNome = this.sessao.createQuery("from produto c.descricao like :descricao");
		consultaNome.setString("descricao", "%" + string + "%");
		return (Produto) consultaNome.uniqueResult();
		
	}

	@Override
	public void excluir(Produto produto) {
		this.sessao.delete(produto);
		
	}

	@Override
	public void alterar(Produto produto) {
		this.sessao.update(produto);
		
	}

	@Override
	public Cliente pesquisar(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	@Override
	public Produto pesquisarPorDescricao(String descricao) {
		String sql = "from Produto p where p.descricao like :descricao";
		Query consulta = sessao.createQuery(sql);
		consulta.setString("descricao", "%" + descricao + "%");
		return (Produto) consulta.uniqueResult();
	}

	@Override
	public void excluir(Produto produto) {
		this.sessao.delete(produto);

	}*/
}
