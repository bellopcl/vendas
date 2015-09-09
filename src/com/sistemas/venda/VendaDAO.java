package com.sistemas.venda;

import java.util.List;

public interface VendaDAO {
	
	public void salvar(Venda venda);

	public void alterar(Venda venda);
	
	public List<Venda> listar();
	
	public void excluir(Venda venda);


}
