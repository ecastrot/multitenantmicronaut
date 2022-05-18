package com.loggro.micronaut.aplicacion;


import com.loggro.micronaut.dominio.modelos.Persona;
import com.loggro.micronaut.dominio.modelos.PersonaRepository;
import com.loggro.micronaut.infraestructura.PersonaCommand;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class PersonaService {

    private final PersonaRepository personaRepository;

   // @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona crearModificar(PersonaCommand inPersona) {
//        Optional<Persona> optPersona = personaRepository.findById(inPersona.getId());
//        Persona persona = optPersona.isPresent() ? optPersona.get() : new Persona();
        Persona persona = new Persona();
        persona.setId(inPersona.getId());
        persona.setNombre(inPersona.getNombre());
        persona.setApellido(inPersona.getApellido());
        return personaRepository.guardar(persona);
    }

//    public List<Persona> getAll() {
//        return personaRepository.findAll();
//    }

    public Persona getById(String id) {
//        Optional<Persona> optPersona = personaRepository.findById(id);
//        return optPersona.isPresent() ? optPersona.get() : null;
        return null;
    }

    public Persona buscarPorId(String id) {
        Optional<Persona> optPersona = personaRepository.buscarPorId(id);
        return optPersona.isPresent() ? optPersona.get() : null;
    }
}
