package com.prueba.cliente.service;

import java.util.List;

import com.prueba.cliente.dto.ClienteDto;

public interface ClienteService {

	void crearCliente(ClienteDto clienteDto);

	void actualizarCliente(Long clienteId, ClienteDto clienteDto);

	List<ClienteDto> obtenerClientes();

	void borrarCliente(Long clienteId);

}
