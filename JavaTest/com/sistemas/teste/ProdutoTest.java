package com.sistemas.teste;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sistemas.produto.Produto;
import com.sistemas.vendas.JPAUtil;

public class ProdutoTest {

	private static Session sessao;
	private static Transaction transacao;
	
	@BeforeClass
	public static void abreConexao(){
		sessao = JPAUtil.getSession().getCurrentSession();
		transacao = sessao.beginTransaction();
		
	}
	
	@AfterClass
	public static void fechaConexao(){
		
		try {
			transacao.commit();
		} catch (Throwable e) {
			System.out.println("deu problema no fechamento da conexão: " + e.getMessage());
		}finally{
			try {
				if(sessao.isOpen()){
					sessao.close();
				}
			} catch (Exception e2) {
				System.out.println("deu erro no fechamento da sessão " + e2.getMessage());
			}
			
		}
	}
	
	@Before
	public void setup(){
		Produto p1 = new Produto("lote", "regua", new Date(), 30, 1.2f);
		Produto p2 = new Produto("lote2", "teste1", new Date(), 12, 1.2f);
		Produto p3 = new Produto("fardo", "caderno", new Date(), 30, 1.2f);
		Produto p4 = new Produto("edicao", "caneta", new Date(), 30, 1.2f);
		Produto p5 = new Produto("caixa", "tabua", new Date(), 30, 1.2f);
		
		sessao.save(p1);
		sessao.save(p2);
		sessao.save(p3);
		sessao.save(p4);
		sessao.save(p5);
		
		
	}
	
	@After
	public void limpaBanco(){
		Criteria lista = sessao.createCriteria(Produto.class);
		@SuppressWarnings("unchecked")
		List<Produto> produtos = lista.list();
		for (Produto produto : produtos) {
			sessao.delete(produto);
		}
	}
	
	@Test
	public void salvarProdutoTest(){
		Query consulta = pesquisar("re");
		Produto produtoPesquisado = (Produto) consulta.uniqueResult();
		assertEquals("lote2", produtoPesquisado.getUnidade());
	}
	
	@Test
	public void listaProdutoTes(){
		Criteria lista = sessao.createCriteria(Produto.class);
		@SuppressWarnings("unchecked")
		List<Produto> produtos = lista.list();
		
		assertEquals(5, produtos.size());
	}
	
	@Test
	public void ecluirProdutoTest(){
		Query consulta = pesquisar("pel");
		Produto produtoDeletar = (Produto) consulta.uniqueResult();
		sessao.delete(produtoDeletar);
		
		produtoDeletar = (Produto) consulta.uniqueResult();
		assertNull(produtoDeletar);
	}
	
	@Test
	public void alteracaoProdutoTest(){
		Query consulta = pesquisar("livro");
		Produto produtoAlterar = (Produto) consulta.uniqueResult();
		produtoAlterar.setEstoque(100);
		sessao.update(produtoAlterar);
		
		produtoAlterar = (Produto) consulta.uniqueResult();
		
		assertEquals(100, produtoAlterar.getEstoque().intValue());
	}

	private Query pesquisar(String parametro) {
		String sql = "from produto p where p.descricao like : descricao";
		Query consulta = sessao.createQuery(sql);
		consulta.setString("descricao", "%"+parametro+"%");
		return consulta;
	}
}
	