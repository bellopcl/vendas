package com.sistemas.produto;

import java.util.List;

import com.sistemas.cliente.Cliente;
import com.sistemas.util.DAOFactory;

public class ProdutoRN {
	private ProdutoDAO produtoDAO;
	
	public ProdutoRN(){
		this.produtoDAO = DAOFactory.criaProdutoDAO();
		
	}

	public void salvar(Produto p1) {
		this.produtoDAO.salvar(p1);
		
	}

	public void alterar(Produto produto) {
	 this.produtoDAO.alterar(produto);
	}
	
	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}
	
	public void excluir(Produto produto) {
		this.produtoDAO.excluir(produto);
		
	}
	
	public Cliente pesquisar(String string) {
		return this.produtoDAO.pesquisar(string);
	}
}
