package com.sistemas.util;

import com.sistemas.cliente.ClienteDAO;
import com.sistemas.cliente.ClienteDAOH;
import com.sistemas.produto.ProdutoDAO;
import com.sistemas.produto.ProdutoDAOH;
import com.sistemas.venda.VendaDAO;
import com.sistemas.venda.VendaDAOH;
import com.sistemas.vendas.JPAUtil;

public class DAOFactory {

	public static ClienteDAO criaClienteDAO() {
		ClienteDAOH clienteDAO = new ClienteDAOH();
		clienteDAO.setSessao(JPAUtil.getSession().getCurrentSession());
		return clienteDAO;
	}
	
	public static ProdutoDAO criaProdutoDAO() {
		ProdutoDAOH produtoDAO = new ProdutoDAOH();
		produtoDAO.setSessao(JPAUtil.getSession()
				.getCurrentSession());
		return produtoDAO;
	}

	public static VendaDAO criaVendaDAO() {
		VendaDAOH vendaDAO = new VendaDAOH();
		vendaDAO.setSessao(JPAUtil.getSession()
				.getCurrentSession());
		return vendaDAO;
	}
}
