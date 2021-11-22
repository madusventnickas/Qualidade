package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GerenciadorClientesTest_Ex7 {
	
	private GerenciadorClientes gerContas;
	int idCliente01 = 1;
	int idCliente02 = 2;
	
	@Before
	public void setUp(){
		Cliente cliente01 = new Cliente(idCliente01, "Madu", 18, "madusventnickas@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Lua", 36, "luasventnickas@gmail.com", 2, true);
		
		List<Cliente> clienteDoBanco = new ArrayList<>();
		clienteDoBanco.add(cliente01);
		clienteDoBanco.add(cliente02);
		
		gerContas = new GerenciadorClientes(clienteDoBanco);
		
		System.out.println("Before foi executato");
	}
	
	@After
	public void tearDown(){
		gerContas.limpa();
	}
	
	@Test
	public void TestePesquisaCliente(){
		
		Cliente cliente = gerContas.pesquisaCliente(1);
		
		Assert.assertThat(cliente.getId(), is(1));
		Assert.assertThat(cliente.getEmail(), is("madusventnickas@gmail.com"));
	
	}
	
	@Test
	public void testRemoveCliente(){
		
	}
}

