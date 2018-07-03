package br.com.renan.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {
	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
	    Conta conta = manager.find(Conta.class, 2);//id 2 deve existir no banco
		
	    Query query = manager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
	    
	    query.setParameter("pConta", conta);
	    Long quantidade =  (Long) query.getSingleResult();
	    System.out.println("Total de movimentações: " + quantidade);
	}
}
