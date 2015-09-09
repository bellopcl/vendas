package com.sistemas.venda;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name="vendaBean")
public class VendaBean {
	
	private Venda vendaSelecionado = new Venda();
	private List<Venda> lista = null;
	
	public Venda getVendaSelecionado() {
		return vendaSelecionado;
	}

	public void setVendaSelecionado(Venda vendaSelecionado) {
		this.vendaSelecionado = vendaSelecionado;
	}

	public void salvar(){
		VendaRN vendaRN = new VendaRN();
		vendaSelecionado.setDataVenda(new Date());
		if (this.vendaSelecionado.getId() != null	&& this.vendaSelecionado.getId() != 0) {
			vendaRN.alterar(this.vendaSelecionado);
		} else {
			vendaRN.salvar(vendaSelecionado);
			FacesMessage faces = new FacesMessage(
					"Pedido cadastrado com sucesso!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
		}
		this.lista = null;
	}

	public List<Venda> getLista() {
		VendaRN vendaRN = new VendaRN();
		if(lista == null){
			lista = vendaRN.listar();
		}
		return lista;
	}
	
	public void excluir(){
		VendaRN VendaRN = new VendaRN();
		VendaRN.excluir(this.vendaSelecionado);
		this.lista = null;
	}
	
}
