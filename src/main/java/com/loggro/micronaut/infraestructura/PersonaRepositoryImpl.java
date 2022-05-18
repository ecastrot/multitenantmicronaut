package com.loggro.micronaut.infraestructura;

import com.loggro.micronaut.dominio.modelos.Persona;
import com.loggro.micronaut.dominio.modelos.PersonaRepository;
import io.micronaut.data.annotation.Repository;

import java.util.Optional;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository  {

    private final PersonaRepositoryJpa personaRepository;

    public PersonaRepositoryImpl(PersonaRepositoryJpa personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Optional<Persona> buscarPorId(String id) {
        return personaRepository.findById(id);
    }
}
