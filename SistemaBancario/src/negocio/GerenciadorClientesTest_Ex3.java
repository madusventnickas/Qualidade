package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GerenciadorClientesTest_Ex3 {
	
	private GerenciadorClientes gerContas;
	
	@Test
	public void TestePesquisaCliente(){
		Cliente cliente01 = new Cliente(1, "Madu", 18, "madusventnickas@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Lua", 36, "luasventnickas@gmail.com", 2, true);
		
		List<Cliente> clienteDoBanco = new ArrayList<>();
		clienteDoBanco.add(cliente01);
		clienteDoBanco.add(cliente02);
		
		gerContas = new GerenciadorClientes(clienteDoBanco);
		
		Cliente cliente = gerContas.pesquisaCliente(1);
		
		Assert.assertThat(cliente.getId(), is(1));
		Assert.assertThat(cliente.getEmail(), is("madusventnickas@gmail.com"));
	
	}
	
	@Test
	public void testRemoveCliente(){
		Cliente cliente01 = new Cliente(1, "Madu", 18, "madusventnickas@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Lua", 36, "luasventnickas@gmail.com", 2, true);
		
		List<Cliente> clienteDoBanco = new ArrayList<>();
		clienteDoBanco.add(cliente01);
		clienteDoBanco.add(cliente02);
		
		gerContas = new GerenciadorClientes(clienteDoBanco);
		
		boolean clienteRemovido = gerContas.removeCliente(2);
		
		assertThat(clienteRemovido, is(true));
		assertThat(gerContas.getClientesDoBanco().size(), is(1));
		assertNull(gerContas.pesquisaCliente(2));
		
		
	}
}

