package com.prueba.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.cliente.dto.ClienteDto;
import com.prueba.cliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("/save-client")
	public ResponseEntity<Void> saveCliente(@RequestBody ClienteDto cliente) {
		clienteService.crearCliente(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update-client/{clientId}")
	public ResponseEntity<Void> updateCliente(@PathVariable Long clientId, @RequestBody ClienteDto cliente) {
		clienteService.actualizarCliente(clientId, cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/get-clients")
	public ResponseEntity<List<ClienteDto>> getClients() {
		return new ResponseEntity<>(clienteService.obtenerClientes(), HttpStatus.OK);
	}

	@DeleteMapping("/delete-client/{clientId}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Long clientId) {
		clienteService.borrarCliente(clientId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
