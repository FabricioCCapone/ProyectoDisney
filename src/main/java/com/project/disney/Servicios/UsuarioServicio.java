package com.project.disney.Servicios;

import com.project.disney.Entidades.Usuario;
import com.project.disney.Repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Capoun
 */
@Service
public class UsuarioServicio implements UserDetailsService {
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public Usuario saveUser(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usuario = usuarioRepositorio.findByUsername(username);
            User user;

            List<GrantedAuthority> authorities = new ArrayList<>();

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuario", usuario);

            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            
            return new User(username, usuario.getContrasena(), authorities);
        } catch (Exception e) {
            throw new UsernameNotFoundException("El usuario solicitado no existe");
        }
    }

}
