package com.prueba.cliente.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestCliente {

	@Test
	void testClienteId() {
		Cliente cliente = new Cliente();
		cliente.setClienteId(1L);
		Assertions.assertEquals(cliente.getClienteId(), 1L);
	}

	@Test
	void testContrasena() {
		Cliente cliente = new Cliente();
		cliente.setContrasena("password123");
		Assertions.assertEquals(cliente.getContrasena(), "password123");
	}

	@Test
	void testEstado() {
		Cliente cliente = new Cliente();
		cliente.setEstado(true);
		Assertions.assertTrue(cliente.getEstado());
	}

	@Test
	void testPersona() {
		Cliente cliente = new Cliente();
		Persona persona = new Persona();
		persona.setPersonaId(1L);
		cliente.setPersona(persona);
		Assertions.assertEquals(cliente.getPersona(), persona);
	}

}
