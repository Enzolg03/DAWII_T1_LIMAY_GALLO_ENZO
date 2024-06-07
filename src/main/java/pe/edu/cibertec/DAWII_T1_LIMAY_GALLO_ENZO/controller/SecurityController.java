package pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.bd.Usuario;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.dto.UsuarioDto;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.service.UsuarioService;

import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/seguridad")
public class SecurityController {
    private UsuarioService usuarioService;
    @GetMapping("/registro")
    public String frmMantUsuario(){
        return "seguridad/frmregistro";
    }
    @ResponseBody
    @PostMapping("/registrar")
    public ResultadoResponse registrarUsuario(@RequestBody UsuarioDto usuarioDto){
        String mensaje = "Usuario registrado correctamente";
        boolean respuesta = true;
        try{
            Usuario usuario = new Usuario();
            if(usuarioDto.getIdusuario()>0){
                usuario.setIdusuario(usuarioDto.getIdusuario());
            }
                usuario.setNombres(usuarioDto.getNombres());
                usuario.setApellidos(usuarioDto.getApellidos());
                usuario.setActivo(usuarioDto.getActivo());
                usuario.setNomusuario(usuarioDto.getNomusuario());
                usuario.setEmail(usuarioDto.getEmail());
                usuario.setPassword(usuarioDto.getPassword());
                usuarioService.registrarUsuario(usuario);
        }catch (Exception ex){
            mensaje = "Usuario no registrado, error en la BD";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje)
                .respuesta(respuesta).build();
    }
}
