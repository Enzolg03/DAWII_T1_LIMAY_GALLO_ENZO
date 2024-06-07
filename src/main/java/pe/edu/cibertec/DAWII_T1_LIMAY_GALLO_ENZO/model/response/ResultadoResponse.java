package pe.edu.cibertec.DAWII_T1_LIMAY_GALLO_ENZO.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
    private boolean respuesta;
    private String mensaje;
}
