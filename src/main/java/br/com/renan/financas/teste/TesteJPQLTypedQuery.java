package br.com.renan.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.modelo.enums.TipoMovimentacao;
import br.com.renan.financas.util.JPAUtil;

public class TesteJPQLTypedQuery {
	
		public static void main(String[] args) {
			
			EntityManager entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			
			Conta conta = new Conta();
			conta.setId(2);
			
			String jpql = "SELECT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pconta"			
					+ " GROUP BY year(m.data), month(m.data), day(m.data)";
			
			TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
			query.setParameter("pconta", conta);
	
			List<Double> medias = query.getResultList();
		
			for (Double media : medias) {
				System.out.println("A média do dia: " + media);
			}
		
			entityManager.getTransaction().commit();
			entityManager.close();
			
		}

}
