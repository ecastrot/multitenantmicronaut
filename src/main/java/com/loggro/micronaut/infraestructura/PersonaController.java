package com.loggro.micronaut.infraestructura;


import com.loggro.micronaut.aplicacion.PersonaService;
import com.loggro.micronaut.dominio.modelos.Persona;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.MediaType;
import io.micronaut.validation.Validated;

//@RestController
@Controller("/personas")
//@RequestMapping("/personas")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

//    @Get(produces = MediaType.TEXT_PLAIN)
//    public String index() {
//        return "Hello World";
//    }

//    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, path = "/{id}")
    @Get("/{id}")
    public HttpResponse<Object> getPersona(@PathVariable String id) {
        try {
            Persona persona = personaService.buscarPorId(id);
            if (persona != null) {
                return HttpResponse.ok(persona);
            } else {
                return HttpResponse.notFound();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.badRequest(e.getMessage());
        }
    }

    @Put(produces = MediaType.TEXT_JSON)
    public HttpResponse<Object> crearModificar(@Body PersonaCommand inPersona) {
        try {
            Persona personaCreada = personaService.crearModificar(inPersona);
            return HttpResponse.ok(personaCreada);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResponse.badRequest(e.getMessage());
        }
    }

    /*@Autowired
    private PersonaService personaService;

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> crearModificar(@RequestBody @Validated PersonaCommand inPersona) {
        try {
            return new ResponseEntity<>(personaService.crearModificar(inPersona), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getAll() {
        try {
            return new ResponseEntity<>(personaService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, path = "/{id}")
    public ResponseEntity<Object> getPersona(@PathVariable String id) {
        try {
            Persona persona = personaService.getById(id);
            if (persona != null) {
                return new ResponseEntity<>(persona, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }*/
}
