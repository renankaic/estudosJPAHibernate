package br.com.renan.financas.teste;

import javax.persistence.EntityManager;

import br.com.renan.financas.modelo.Cliente;
import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.util.JPAUtil;

public class TestaContaCliente {
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua 123");
		cliente.setProfissao("Professor");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		cliente.setConta(conta);
		
		EntityManager eManager = JPAUtil.getEntityManager();
		eManager.getTransaction().begin();
		
		eManager.persist(cliente);
		
		eManager.getTransaction().commit();
		eManager.close();
		
		
	}
}
