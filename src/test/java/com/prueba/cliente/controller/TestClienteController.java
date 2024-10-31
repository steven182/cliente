package com.prueba.cliente.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.cliente.dto.ClienteDto;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class TestClienteController {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testSaveCliente() throws Exception {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setContrasena("password123");
		clienteDto.setDireccion("Prueba");
		clienteDto.setNombres("Stiwen Romero");
		mockMvc.perform(post("/cliente/save-client").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(clienteDto))).andExpect(status().isOk());
	}

	@Test
	void testUpdateCliente() throws Exception {
		Long clientId = 1L;
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setContrasena("newPassword123");
		clienteDto.setDireccion("Prueba");
		clienteDto.setNombres("Stiwen Romero");
		mockMvc.perform(put("/cliente/update-client/{clientId}", clientId).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(clienteDto))).andExpect(status().isOk());
	}

	@Test
	void testGetClients() throws Exception {
		mockMvc.perform(get("/cliente/get-clients").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

	@Test
	void testDeleteClienteError() throws Exception {
		mockMvc.perform(delete("/cliente/delete-client/{clientId}", 1L).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is5xxServerError());
	}

}
