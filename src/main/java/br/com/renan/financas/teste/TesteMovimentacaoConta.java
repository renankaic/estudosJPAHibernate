package br.com.renan.financas.teste;

import javax.persistence.EntityManager;

import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.modelo.Movimentacao;
import br.com.renan.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		Movimentacao movimentacao = entityManager.find(Movimentacao.class, 2);
		Conta conta = movimentacao.getConta();
		
		System.out.println(conta.getTitular());
		System.out.println(conta.getMovimentacoes().size());
		
		
		entityManager.getTransaction().commit();
		entityManager.close();		
	}

}
