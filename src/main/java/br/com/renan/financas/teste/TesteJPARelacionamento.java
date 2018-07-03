package br.com.renan.financas.teste;


import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.modelo.Movimentacao;
import br.com.renan.financas.modelo.enums.TipoMovimentacao;
import br.com.renan.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("1234");
		conta.setNumero("6789");
		conta.setBanco("iTau");
		conta.setTitular("Renan");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.00"));
		
		movimentacao.setConta(conta);
		
		EntityManager eManager = JPAUtil.getEntityManager();
		eManager.getTransaction().begin();
		
		eManager.persist(conta);
		eManager.persist(movimentacao);
		
		eManager.getTransaction().commit();
		eManager.close();
	
	}
}
