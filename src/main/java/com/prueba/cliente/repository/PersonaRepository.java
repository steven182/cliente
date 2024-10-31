package com.prueba.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.cliente.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
