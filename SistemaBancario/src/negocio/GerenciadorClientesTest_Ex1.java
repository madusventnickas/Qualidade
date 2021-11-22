package negocio;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;

public class GerenciadorClientesTest_Ex1 {
	
	@Test
	public void TestePesquisaCliente(){
		Cliente cliente01 = new Cliente(1, "Madu", 18, "madusventnickas@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Lua", 36, "luasventnickas@gmail.com", 2, true);
		
		List<Cliente> clienteDoBanco = new ArrayList<>();
		clienteDoBanco.add(cliente01);
		clienteDoBanco.add(cliente02);
		
		GerenciadorClientes gerClientes = new GerenciadorClientes(clienteDoBanco);
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		Assert.assertThat(cliente.getId(), is(1));
		Assert.assertThat(cliente.getEmail(), is("madusventnickas@gmail.com"));
	}
}

