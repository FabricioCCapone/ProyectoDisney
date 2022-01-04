package com.project.disney.Controllers;

import com.project.disney.Entidades.Usuario;
import com.project.disney.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Capoun
 */
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UsuarioServicio usuarioServicio;

    @PostMapping("/register")
    public Usuario saveUser(@RequestBody Usuario usuario) {
        return usuarioServicio.saveUser(usuario);
    }

    @PostMapping("/login")
    public Usuario loginUser(@RequestBody Usuario usuario) {
        try {
            if(usuario != null){
                usuarioServicio.loadUserByUsername(usuario.getUsuario());
                return usuario;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
