package br.com.renan.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		Conta conta = entityManager.find(Conta.class, 2);
		
		Query query = entityManager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", conta);
		BigDecimal maiorValor = (BigDecimal) query.getSingleResult();
		
		System.out.println(maiorValor);
		
		entityManager.getTransaction().commit();
		entityManager.close();	

	}

}
