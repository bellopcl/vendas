package com.sistemas.venda;


import java.util.List;

import com.sistemas.util.DAOFactory;

public class VendaRN {
	
	private VendaDAO vendaDAO;
	
	public VendaRN(){
		this.vendaDAO = DAOFactory.criaVendaDAO();
		
	}

	public void salvar(Venda v1) {
		this.vendaDAO.salvar(v1);
	}

	public void alterar(Venda venda) {
		this.vendaDAO.alterar(venda);
	}
	
	public List<Venda> listar() {
		return this.vendaDAO.listar();
	}

	public void excluir(Venda vendaSelecionado) {
		this.vendaDAO.excluir(vendaSelecionado);
		
	}


}
