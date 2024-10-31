package com.prueba.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.cliente.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
