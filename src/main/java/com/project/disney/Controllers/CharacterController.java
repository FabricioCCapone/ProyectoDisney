package com.project.disney.Controllers;

import com.project.disney.Entidades.Personaje;
import com.project.disney.Servicios.PersonajeServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Capoun
 */
@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    PersonajeServicio personajeServicio;

    @GetMapping()
    public List<Personaje> characterList(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age, @RequestParam(required = false) Float weight, @RequestParam(required = false) String movies) {
        if (name != null) {
            return personajeServicio.findByNombre(name);
        } else if (age != null) {
            return personajeServicio.findByEdad(age);
        } else if (weight != null) {
            return personajeServicio.findByPeso(weight);
        } else if (movies != null) {
            return personajeServicio.findByAparicion(movies);
        } else {
            return personajeServicio.listAllPersonajes();
        }
    }

    @PostMapping("/register")
    public Personaje savePersonaje(@RequestBody Personaje personaje) {
        return personajeServicio.savePersonaje(personaje);
    }

    @PostMapping("/edit")
    public Boolean editPersonaje(@RequestBody Personaje personaje) {
        return personajeServicio.editPersonaje(personaje);
    }

    @DeleteMapping("/delete")
    public Boolean deletePersonaje(@RequestBody String id) {
        return personajeServicio.deletePersonaje(id);
    }

    @GetMapping(path = "/{id}")
    public Personaje characterDetalles(@PathVariable("id") String id) {
        return personajeServicio.detallesPersonaje(id);
    }

}
