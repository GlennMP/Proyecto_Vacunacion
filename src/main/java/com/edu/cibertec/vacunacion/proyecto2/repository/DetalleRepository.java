
package com.edu.cibertec.vacunacion.proyecto2.repository;

import com.edu.cibertec.vacunacion.proyecto2.model.detalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<detalle, Integer>{
    
    List<detalle> findByDetalleidciudadanos(Integer detalleidciudadanos);
    
}
