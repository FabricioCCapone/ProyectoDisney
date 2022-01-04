package com.project.disney.Servicios;

import com.project.disney.Entidades.Personaje;
import com.project.disney.Repositorios.PersonajeRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Capoun
 */
@Service
public class PersonajeServicio {

    @Autowired
    PersonajeRepositorio personajeRepositorio;

    //Cuando hago el query para que solo traiga nombre e imagen no trae nada
    public List<Personaje> listAllPersonajes() {
       List<Personaje> infoCompleta = personajeRepositorio.listAllCharacters();
       List<Personaje> infoPedida = new ArrayList<>();
        for (int i = 0; i < infoCompleta.size(); i++) {
            Personaje personaje = new Personaje();
            personaje.setNombre(infoCompleta.get(i).getNombre());
            personaje.setImagen(infoCompleta.get(i).getImagen());
            infoPedida.add(personaje);
        }
        return infoPedida;
    }
    
    public Personaje detallesPersonaje(String id) {
        return personajeRepositorio.findById(id).get();
    }
    
    public List<Personaje> findByNombre(String nombre){
        nombre = nombre + "%";
        return personajeRepositorio.findByNombre(nombre);
    } 

    public List<Personaje> findByEdad(Integer edad){
        return personajeRepositorio.findByEdad(edad);
    } 

    public List<Personaje> findByPeso(Float peso){
        return personajeRepositorio.findByPeso(peso);
    } 

    public List<Personaje> findByAparicion(String movieId){
        return personajeRepositorio.findByAparicion(movieId);
    } 

    @Transactional
    public Personaje savePersonaje(Personaje personaje) {
        return personajeRepositorio.save(personaje);
    }

    @Transactional
    public Boolean editPersonaje(Personaje personaje) {
        if (personajeRepositorio.findById(personaje.getId()).isPresent()) {
            personajeRepositorio.save(personaje);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Boolean deletePersonaje(String id) {
        try {
            personajeRepositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
