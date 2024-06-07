package pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.service;

import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.bd.Usuario;

public interface IUsuarioService {
    Usuario registrarUsuario(Usuario usuario);
    void actualizarClave(Usuario usuario);
    Usuario buscarUsuarioXNomusuario(String nomusuario);
}
