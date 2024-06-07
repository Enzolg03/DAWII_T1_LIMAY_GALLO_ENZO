package pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.bd.Rol;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.bd.Usuario;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.repository.RolRepository;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarClave(Usuario usuario) {
    }

    @Override
    public Usuario buscarUsuarioXNomusuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

}
