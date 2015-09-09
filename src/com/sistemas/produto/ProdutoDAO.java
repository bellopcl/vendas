package com.sistemas.produto;

import java.util.List;

import com.sistemas.cliente.Cliente;

public interface ProdutoDAO {
	
	public void salvar(Produto produto);

	public List<Produto> listar();

	public Produto pesquisarPorDescricao(String descricao);

	public void excluir(Produto produto);
	
	public void alterar(Produto produto);

	public Cliente pesquisar(String string);

}
