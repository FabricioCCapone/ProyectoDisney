package com.project.disney.Servicios;

import com.project.disney.Entidades.Pelicula;
import com.project.disney.Repositorios.GeneroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Capoun
 */
@Service
public class GeneroServicio {

    @Autowired
    GeneroRepositorio generoRepositorio;
    
    public List<Pelicula> findByGenero(String id){
        return generoRepositorio.findByGenero(id);
    }
}

