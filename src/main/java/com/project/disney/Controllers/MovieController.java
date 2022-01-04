package com.project.disney.Controllers;

import com.project.disney.Entidades.Pelicula;
import com.project.disney.Servicios.PeliculaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Capoun
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    PeliculaServicio peliculaServicio;

    @GetMapping()
    public List<Pelicula> listPelicula() {
        return peliculaServicio.listAllPeliculas();
    }

    @PostMapping("/register")
    public Pelicula savePelicula(@RequestBody Pelicula pelicula) {
        return peliculaServicio.savePelicula(pelicula);
    }

    @PostMapping("/edit")
    public Boolean editPelicula(@RequestBody Pelicula pelicula) {
        return peliculaServicio.editPelicula(pelicula);
    }

    @DeleteMapping("/delete")
    public Boolean deletePelicula(@RequestBody String id) {
        return peliculaServicio.deletePelicula(id);
    }

    @GetMapping(path = "/{id}")
    public Pelicula peliculaDetalles(@PathVariable("id") String id) {
        return peliculaServicio.detallesPelicula(id);
    }
}
