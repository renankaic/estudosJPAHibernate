package br.com.renan.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.renan.financas.dao.MovimentacaoDao;
import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.util.JPAUtil;

public class TesteJPQLTypedQuery {
	
		public static void main(String[] args) {
			
			EntityManager entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			
			Conta conta = new Conta();
			conta.setId(2);
		
			MovimentacaoDao mDao = new MovimentacaoDao(entityManager);
			List<Double> medias = mDao.getMediasPorDia(conta);
			
			for (Double media : medias) {
				System.out.println("A média do dia: " + media);
			}
		
			entityManager.getTransaction().commit();
			entityManager.close();
			
		}

}
