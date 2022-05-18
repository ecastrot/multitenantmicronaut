package com.loggro.micronaut.dominio.modelos;

import java.util.Optional;

public interface PersonaRepository {

    Persona guardar(Persona persona);

    Optional<Persona> buscarPorId(String id);
}
