package br.com.renan.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.util.JPAUtil;

public class TesteTodasMovimentacoesDaConta {
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "Select DISTINCT c from Conta c LEFT JOIN JOIN FETCH c.movimentacoes";
		Query query = entityManager.createQuery(jpql);	
		
		@SuppressWarnings("unchecked")
		List<Conta> todasAsContas = query.getResultList();
		for (Conta conta : todasAsContas) {
			System.out.println("Titular : " + conta.getTitular());
			System.out.println("Movimentações: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();	
		
	}
}
