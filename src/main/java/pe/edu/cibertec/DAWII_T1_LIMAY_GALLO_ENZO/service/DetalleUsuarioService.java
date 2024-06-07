package pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.bd.Rol;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.bd.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarUsuarioXNomusuario(username);
        return obtenerUsuarioAutenticado(usuario, obtenerListaRolesUsuario(usuario.getRoles()));
    }
    private List<GrantedAuthority> obtenerListaRolesUsuario(Set<Rol>listadoRoles){
        List<GrantedAuthority> roles = new ArrayList<>();
        for(Rol rol : listadoRoles){
            roles.add(new SimpleGrantedAuthority(rol.getNomrol()));
        }
        return roles;
    }
    private UserDetails obtenerUsuarioAutenticado(Usuario usuario,
                                                  List<GrantedAuthority> authorityList){
        return new User(usuario.getNomusuario(), usuario.getPassword(), usuario.getActivo(),
                true, true, true,
                authorityList);
    }
}
