package com.project.disney.Entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Capoun
 */
@Entity
public class Genero {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String nombre;
    
    @OneToOne
    private Imagen imagen;
    
    @OneToMany
    private List<Pelicula> peliculasAsociadas;

    public Genero() {
    }

    public Genero(String id, String nombre, Imagen imagen, List<Pelicula> peliculasAsociadas) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculasAsociadas = peliculasAsociadas;
    }

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

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public List<Pelicula> getPeliculasAsociadas() {
        return peliculasAsociadas;
    }

    public void setPeliculasAsociadas(List<Pelicula> peliculasAsociadas) {
        this.peliculasAsociadas = peliculasAsociadas;
    }
    
    
}
