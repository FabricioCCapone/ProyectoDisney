/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.disney.Repositorios;

import com.project.disney.Entidades.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabri
 */
@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, String>{
    
}
