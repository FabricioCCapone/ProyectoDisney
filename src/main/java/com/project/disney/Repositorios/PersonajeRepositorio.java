/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.disney.Repositorios;

import com.project.disney.Entidades.Personaje;
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
public interface PersonajeRepositorio extends JpaRepository<Personaje, String> {

    @Query("SELECT p FROM Personaje p")
    public List<Personaje> listAllCharacters();

    @Query("SELECT p FROM Personaje p WHERE nombre LIKE :nombre")
    public List<Personaje> findByNombre(@Param("nombre") String nombre);

    @Query("SELECT p FROM Personaje p WHERE aparicion_id = :aparicion_id")
    public List<Personaje> findByAparicion(@Param("aparicion_id") String pelicula_id);

    @Query("SELECT p FROM Personaje p WHERE edad = :edad")
    public List<Personaje> findByEdad(@Param("edad") Integer edad);

    @Query("SELECT p FROM Personaje p WHERE peso = :peso")
    public List<Personaje> findByPeso(@Param("peso") Float peso);
}
