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
public class Personaje {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @OneToOne
    private Imagen imagen;
    
    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;
    
    @OneToMany
    private List<Pelicula> aparicion;
}