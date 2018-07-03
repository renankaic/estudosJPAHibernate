package br.com.renan.financas.teste;

import javax.persistence.EntityManager;

import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.util.JPAUtil;

public class Teste {
	
	public static void main(String[] args) {		

		Conta conta = new Conta();
		conta.setTitular("Renan");
		conta.setBanco("Bradesco");
		conta.setAgencia("123");		
		conta.setNumero("456");
		
	
		EntityManager eManager = JPAUtil.getEntityManager();
		
		eManager.getTransaction().begin();
		
		//A partir daqui, a instância conta sai do estado transient para managed
		//Ou seja qualquer alteração na instância afetará seus dados no banco de dados
		//Ver arquivo TesteBuscaConta.java
		eManager.persist(conta);
		
		eManager.getTransaction().commit();		
		
		//A partir daqui as instãncias não serão sincronizadas com o banco
		//Se torna "detached" - Não gerenciada mais pelo JPA
		eManager.close();		
		
		EntityManager eManager2 = JPAUtil.getEntityManager();
		eManager2.getTransaction().begin();
		
		//Aqui passo de detached para Managed - permitindo a sincronização novamente dos dados
		eManager2.merge(conta);
		conta.setBanco("Banco do Brasil");
		
		eManager2.getTransaction().commit();
		eManager2.close();
		
		
	}
	
}