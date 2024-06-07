package pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.bd.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);
}
