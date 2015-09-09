package com.sistemas.teste;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sistemas.cliente.Cliente;
import com.sistemas.cliente.ClienteRN;
import com.sistemas.vendas.JPAUtil;

public class ClienteTest {
	
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
		Cliente c1 = new Cliente("02131222", "bellop", "Vila nova", "teste", new Date(), 100);
		Cliente c2 = new Cliente("02131222", "bellop", "Vila nova", "teste", new Date(), 100);
		Cliente c3 = new Cliente("02131222", "bellop", "Vila nova", "teste", new Date(), 100);
		
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.salvar(c1);
		clienteRN.salvar(c1);
		clienteRN.salvar(c1);
	}
	
	@After
	public void limpaBanco(){
		
		ClienteRN clienteRN = new ClienteRN();
		List<Cliente> lista = clienteRN .listar();
		
		for (Cliente cliente : lista) {
			clienteRN.excluir(cliente);
		}
	}
	@Test
	public void salvarTest(){
		Cliente c1 = new Cliente();
		
		c1.setNome("Ronaldo");
		c1.setEndereco("Rua Teste");
		c1.setRenda(500f);
		c1.setCpf("123456789");
		
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.salvar(c1);
		assertEquals(true, true);
	}
	
	@Test
	public void listarTest(){
		ClienteRN clienteRN = new ClienteRN();
		List<Cliente> lista = clienteRN.listar();
		assertEquals(4, lista.size());
	}
	
	@Test
	public void excluirTest(){
		ClienteRN clienteRN = new ClienteRN();
		
		List<Cliente> lista = clienteRN.listar();
		
		Cliente clienteExcluido = new Cliente();
		
		clienteRN.excluir(clienteExcluido);
		
		lista = clienteRN.listar();
		
		assertEquals(2, lista.size());
	}
	
	@Test
	public void pesquisarTest(){
		ClienteRN clienteRN = new ClienteRN();
		Cliente clientePesquisado = clienteRN.pesquisar("te 1");
		
		assertEquals("gmail.com", clientePesquisado.getEmail());
		
	}
	
	@Test
	public void alterarTest(){
		ClienteRN clienteRN = new ClienteRN();
		Cliente clientePesquisado = clienteRN.pesquisar("te 1");
		
		assertEquals("gmail.com", clientePesquisado.getEmail());
		
		clientePesquisado.setEndereco("novo Endereco");
		
		clienteRN.alterar(clientePesquisado);
		
		Cliente clienteAlterado = clienteRN.pesquisar("te 1");
		
		assertEquals("novo Endereco", clienteAlterado.getEndereco());
	}
}
	