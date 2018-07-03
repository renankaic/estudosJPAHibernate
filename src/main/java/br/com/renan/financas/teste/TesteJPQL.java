package br.com.renan.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.modelo.Movimentacao;
import br.com.renan.financas.modelo.enums.TipoMovimentacao;
import br.com.renan.financas.util.JPAUtil;

public class TesteJPQL {
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pconta"
				+ " AND m.tipo = :pTipo"
				+ " ORDER BY m.valor DESC";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pconta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
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
