package br.com.renan.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.renan.financas.modelo.Categoria;
import br.com.renan.financas.modelo.Conta;
import br.com.renan.financas.modelo.Movimentacao;
import br.com.renan.financas.modelo.enums.TipoMovimentacao;
import br.com.renan.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");			
		Categoria categoria2 = new Categoria("Negocios");
		
		Conta conta = new Conta();
		conta.setId(2);
	
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem a SP");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100.00"));
		movimentacao1.setCategorias(Arrays.asList(categoria2));
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem ao RJ");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.00"));
		movimentacao2.setCategorias(Arrays.asList(categoria2, categoria1));
		movimentacao2.setConta(conta);
		
		EntityManager eManager = JPAUtil.getEntityManager();
		eManager.getTransaction().begin();
		
		eManager.persist(categoria1);
		eManager.persist(categoria2);
		
		eManager.persist(movimentacao1);
		eManager.persist(movimentacao2);
		
		eManager.getTransaction().commit();
		eManager.close();
		
		

	}

}
