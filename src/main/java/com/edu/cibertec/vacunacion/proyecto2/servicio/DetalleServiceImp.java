
package com.edu.cibertec.vacunacion.proyecto2.servicio;

import com.edu.cibertec.vacunacion.proyecto2.model.detalle;
import com.edu.cibertec.vacunacion.proyecto2.repository.DetalleRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class DetalleServiceImp implements DetalleService{

    @Autowired
    private DetalleRepository repoDetalle;
    
    @Override
    public List<detalle> findByDetalleidciudadanos(Integer detalleidciudadanos) {
     return repoDetalle.findByDetalleidciudadanos(detalleidciudadanos);
    }

    @Override
    public detalle guardarDetalle(detalle detalle) {
     return repoDetalle.save(detalle);
    }
    
}
