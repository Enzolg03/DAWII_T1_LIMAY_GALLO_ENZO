package pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.bd.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);
    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET password = :password WHERE nomusuario = :nomusuario", nativeQuery = true)
    void actualizarClave(@Param("password") String password, @Param("nomusuario") String nomusuario);
}
