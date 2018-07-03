package br.com.renan.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.renan.financas.modelo.Conta;

public class MovimentacaoDao {
	
	private EntityManager entityManager;
	
	public MovimentacaoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public  List<Double> getMediasPorDia(Conta conta ){
		
		String jpql = "SELECT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pconta"			
				+ " GROUP BY year(m.data), month(m.data), day(m.data)";
		
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		query.setParameter("pconta", conta);

		List<Double> medias = query.getResultList();
		return medias;
		
	}
	
}
