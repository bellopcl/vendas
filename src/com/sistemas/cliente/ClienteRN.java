package com.sistemas.cliente;

import java.util.List;

import com.sistemas.util.DAOFactory;

public class ClienteRN {
	
	private ClienteDAO clienteDAO;
	
	public ClienteRN(){
		this.clienteDAO = DAOFactory.criaClienteDAO();
		
	}

	public void salvar(Cliente c1) {
		this.clienteDAO.salvar(c1);
		
	}

	public void alterar(Cliente cliente) {
	 this.clienteDAO.alterar(cliente);
	}

	public List<Cliente> listar() {
		return this.clienteDAO.listar();
	}

	public void excluir(Cliente cliente) {
		this.clienteDAO.excluir(cliente);
		
	}

	public Cliente pesquisar(String string) {
		return this.clienteDAO.pesquisar(string);
	}

}
