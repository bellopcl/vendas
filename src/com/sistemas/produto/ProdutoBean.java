package com.sistemas.produto;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name = "produtoBean")
public class ProdutoBean {
	
	private Produto produtoSelecionado = new Produto();
	private List<Produto> lista = null;
	
	
	
	public List<Produto> getLista() {
		ProdutoRN produtoRN = new ProdutoRN();
		if(lista == null){
			lista = produtoRN.listar();
		}
		return lista;
	}

	public void salvar(){
		ProdutoRN produtoRN = new ProdutoRN();
		produtoSelecionado.setDataCadastro(new Date());
		if (this.produtoSelecionado.getId() != null	&& this.produtoSelecionado.getId() != 0) {
			produtoRN.alterar(this.produtoSelecionado);
		} else {
			produtoRN.salvar(produtoSelecionado);
			FacesMessage faces = new FacesMessage(
					"Produto cadastrado com sucesso!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
		}
		this.lista = null;
	}

	public void novo() {
		this.produtoSelecionado = new Produto();
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	public void excluir(){
		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.excluir(this.produtoSelecionado);
		this.lista = null;
	}

}
