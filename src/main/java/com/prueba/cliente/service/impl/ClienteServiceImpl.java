package com.prueba.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.cliente.dto.ClienteDto;
import com.prueba.cliente.entity.Cliente;
import com.prueba.cliente.entity.Persona;
import com.prueba.cliente.exception.AdvencedException;
import com.prueba.cliente.repository.ClienteRepository;
import com.prueba.cliente.repository.PersonaRepository;
import com.prueba.cliente.service.ClienteService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

	private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	@Transactional
	public void crearCliente(ClienteDto clienteDto) {
		final var cliente = new Cliente();
		final var persona = new Persona();
		persona.setDireccion(clienteDto.getDireccion());
		persona.setTelefono(clienteDto.getTelefono());
		persona.setNombre(clienteDto.getNombres());
		final var personaSaved = personaRepository.save(persona);
		cliente.setContrasena(clienteDto.getContrasena());
		cliente.setEstado(true);
		cliente.setPersona(personaSaved);
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void actualizarCliente(Long clienteId, ClienteDto clienteDto) {
		try {
			var persona = getPersona(clienteId);
			var cliente = getCliente(clienteId);
			validarPersonaYCliente(persona, cliente);
			persona.setDireccion(clienteDto.getDireccion());
			persona.setTelefono(clienteDto.getTelefono());
			persona.setNombre(clienteDto.getNombres());
			cliente.setContrasena(clienteDto.getContrasena());
			personaRepository.save(persona);
			clienteRepository.save(cliente);
		} catch (EntityNotFoundException e) {
			logger.error("Error: {}", e.getMessage());
		} catch (Exception e) {
			logger.error("Error al actualizar el cliente: {}", e.getMessage());
		}
	}

	@Override
	public List<ClienteDto> obtenerClientes() {
		final List<ClienteDto> listaRespuesta = new ArrayList<>();
		final var listaClientes = personaRepository.findAll();
		listaClientes.forEach(cliente -> {
			final var clienteDto = new ClienteDto();
			clienteDto.setDireccion(cliente.getDireccion());
			clienteDto.setNombres(cliente.getNombre());
			clienteDto.setTelefono(cliente.getTelefono());
			listaRespuesta.add(clienteDto);
		});
		return listaRespuesta;
	}

	@Override
	@Transactional
	public void borrarCliente(Long clienteId) {
		final var cliente = personaRepository.findById(clienteId)
				.orElseThrow(() -> new AdvencedException("Error: Cliente no encontrado para ID " + clienteId));
		personaRepository.delete(cliente);
	}

	private Persona getPersona(Long clienteId) {
		return personaRepository.findById(clienteId)
				.orElseThrow(() -> new AdvencedException("Persona no encontrada para el ID: " + clienteId));
	}

	private Cliente getCliente(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new AdvencedException("Cliente no encontrado para el ID: " + clienteId));
	}

	private void validarPersonaYCliente(Persona persona, Cliente cliente) {
		if (persona.getPersonaId().longValue() != cliente.getPersona().getPersonaId()) {
			throw new AdvencedException("La persona y el cliente no coinciden.");
		}
	}

}
