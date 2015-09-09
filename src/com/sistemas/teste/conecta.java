package com.sistemas.teste;

import org.hibernate.Session;
import com.sistemas.vendas.JPAUtil;

public class conecta {
	public static void main(String[] args) {
		Session sessao = null;
		try {
			sessao = JPAUtil.getSession().openSession();
			System.out.println("conexão efetuada com sucesso!");
		} finally {
			sessao.close();
			System.out.println("conexao fechada");
		}
	}
}
