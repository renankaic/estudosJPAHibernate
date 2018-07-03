package br.com.renan.financas.teste;

import javax.persistence.EntityManager;

import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		EntityManager emf = JPAUtil.getEntityManager();
		
		emf.getTransaction().begin();
		
		Conta conta = emf.find(Conta.class,2);
		
		//Pode-se realizar updates apenas alterando a propriedade na instância
		conta.setTitular("Iolanda Vieira");
		
		System.out.println(conta);
		
		emf.getTransaction().commit();		
		

	}

}
