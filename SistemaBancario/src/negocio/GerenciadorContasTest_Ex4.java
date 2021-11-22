package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class GerenciadorContasTest_Ex4 {
	
	private GerenciadoraContas gerContas;

	@Test
	public void testTransfereValor(){
		
	/* MONTAGEM */
	int idConta01 = 1;
	int idConta02 = 2;
	
	ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
	ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
	
	List<ContaCorrente> contasDoBanco = new ArrayList<>();
	
	contasDoBanco.add(conta01);
	contasDoBanco.add(conta02);
	
	
	gerContas = new GerenciadoraContas(contasDoBanco);
	
	/* EXECUÇÃO */
	boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
	
	/* VERIFICAÇÃO */
	assertTrue(sucesso);
	assertThat(conta02.getSaldo(), is(100.0));
	assertThat(conta01.getSaldo(), is(100.0));
	
	
	}
}
