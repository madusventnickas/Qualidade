package negocio;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class GerenciadorContasTest_Ex6 {
	
	private GerenciadoraContas gerContas;  
	
	@Test
	public void testTransferenciaValor(){
		
	/* MONTAGEM */
	int idConta01 = 1;
	int idConta02 = 2;
	
	ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
	ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
	
	List<ContaCorrente> contasDoBanco = new ArrayList<>();
	
	contasDoBanco.add(conta01);
	contasDoBanco.add(conta02); 
	
	
	gerContas = new GerenciadoraContas(contasDoBanco);
	
	boolean sucesso = gerContas.transfereValor(idConta01, 200.0, idConta02);
	
	assertTrue(sucesso);
	Assert.assertThat(conta01.getSaldo(), CoreMatchers.is(-100.0));
	Assert.assertThat(conta02.getSaldo(), CoreMatchers.is(200.0));
	}
}