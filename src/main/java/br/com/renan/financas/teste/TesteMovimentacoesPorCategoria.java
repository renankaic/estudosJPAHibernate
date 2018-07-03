package br.com.renan.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.renan.financas.modelo.Categoria;
import br.com.renan.financas.modelo.Movimentacao;
import br.com.renan.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(2);
		
		String jpql = "SELECT m FROM Movimentacao m JOIN m.categoria c WHERE c = :pCategoria ";		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		@SuppressWarnings("unchecked")
		List<Movimentacao> resultados = (List<Movimentacao>) query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println(movimentacao.getDescricao());
			System.out.println(movimentacao.getConta());			
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
}
