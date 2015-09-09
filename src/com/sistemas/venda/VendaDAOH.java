package com.sistemas.venda;

import java.util.List;

import org.hibernate.Session;


public class VendaDAOH implements VendaDAO{
	private Session sessao;
		
	public Session getSessao() {
		return sessao;
	}
	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void salvar(Venda venda) {
		this.sessao.save(venda);
		
	}

	@Override
	public void alterar(Venda venda) {
		this.sessao.update(venda);
		
	}
	@Override
	public List<Venda> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void excluir(Venda venda) {
		this.sessao.delete(venda);
		
	}
}
