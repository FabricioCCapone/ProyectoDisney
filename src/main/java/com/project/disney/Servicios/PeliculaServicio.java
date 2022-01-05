package com.project.disney.Servicios;

import com.project.disney.Entidades.Pelicula;
import com.project.disney.Repositorios.PeliculaRepositorio;
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
public class PeliculaServicio {

    @Autowired
    PeliculaRepositorio peliculaRepositorio;
   
    @Autowired
    GeneroServicio generoServicio;

    public List<Pelicula> listAllPeliculas() {
        List<Pelicula> infoCompleta = peliculaRepositorio.listAllPeliculas();
        List<Pelicula> infoPedida = new ArrayList<>();
        for (int i = 0; i < infoCompleta.size(); i++) {
            Pelicula pelicula = new Pelicula();
            pelicula.setImagen(infoCompleta.get(i).getImagen());
            pelicula.setTitulo(infoCompleta.get(i).getTitulo());
            pelicula.setFechaCreacion(infoCompleta.get(i).getFechaCreacion());
            infoPedida.add(pelicula);
        }
        return infoPedida;
    }

    public List<Pelicula> findByNombre(String nombre) {
        nombre = nombre + "%";
        return peliculaRepositorio.findByNombre(nombre);
    }

    public List<Pelicula> findByGenero(String generoId) {
        return generoServicio.findByGenero(generoId);
    }

    public List<Pelicula> orderPeliculas(String orden) {
        if(orden.equalsIgnoreCase("asc")){
            return peliculaRepositorio.ordenAsc();
        }else if (orden.equalsIgnoreCase("desc")){
            return peliculaRepositorio.ordenDesc();
        }else{
            return peliculaRepositorio.listAllPeliculas();
        }
    }

    public Pelicula detallesPelicula(String id) {
        return peliculaRepositorio.findById(id).get();
    }

    @Transactional
    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepositorio.save(pelicula);
    }

    @Transactional
    public Boolean editPelicula(Pelicula pelicula) {
        if (peliculaRepositorio.findById(pelicula.getId()).isPresent()) {
            peliculaRepositorio.save(pelicula);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Boolean deletePelicula(String id) {
        try {
            peliculaRepositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
