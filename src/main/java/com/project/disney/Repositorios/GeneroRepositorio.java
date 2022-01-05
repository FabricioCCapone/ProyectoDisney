/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.disney.Repositorios;

import com.project.disney.Entidades.Genero;
import com.project.disney.Entidades.Pelicula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabri
 */
@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, String> {

    @Query("SELECT p FROM Pelicula p, Genero g WHERE peliculas_asociadas_id = :peliculas_asociadas_id")
    public List<Pelicula> findByGenero(@Param("peliculas_asociadas_id") String genero);

}
