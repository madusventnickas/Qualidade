package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GerenciadorClientesTest_Ex2 {
	
	private GerenciadorClientes gerClientes;
	
	@Test
	public void TestePesquisaCliente(){
		Cliente cliente01 = new Cliente(1, "Madu", 18, "madusventnickas@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Lua", 36, "luasventnickas@gmail.com", 2, true);
		
		List<Cliente> clienteDoBanco = new ArrayList<>();
		clienteDoBanco.add(cliente01);
		clienteDoBanco.add(cliente02);
		
		gerClientes = new GerenciadorClientes(clienteDoBanco);
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
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
		
		gerClientes = new GerenciadorClientes(clienteDoBanco);
		
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		
		
	}
}

