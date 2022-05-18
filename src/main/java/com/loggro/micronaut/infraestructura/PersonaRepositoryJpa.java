package com.loggro.micronaut.infraestructura;

import com.loggro.micronaut.dominio.modelos.Persona;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface PersonaRepositoryJpa extends JpaRepository<Persona, String> {

}
