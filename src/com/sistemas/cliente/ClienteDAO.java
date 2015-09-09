package com.sistemas.cliente;

import java.util.List;

public interface ClienteDAO {
	
	public void salvar(Cliente cliente);

	public void alterar(Cliente cliente);

	public List<Cliente> listar();

	public void excluir(Cliente cliente);

	public Cliente pesquisar(String string);

}
