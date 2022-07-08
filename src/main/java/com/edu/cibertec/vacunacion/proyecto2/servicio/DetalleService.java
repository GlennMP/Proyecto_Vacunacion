
package com.edu.cibertec.vacunacion.proyecto2.servicio;

import com.edu.cibertec.vacunacion.proyecto2.model.detalle;
import java.util.List;

public interface DetalleService {
    
    List<detalle> findByDetalleidciudadanos(Integer detalleidciudadanos);
    detalle guardarDetalle (detalle detalle);
}
