package com.loggro.micronaut.infraestructura;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonaCommand {

    @NotNull
    @Size(min = 6, max = 9)
    private String id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String nombre;

    @Size(max = 30)
    private String apellido;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
