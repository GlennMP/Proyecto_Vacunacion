
package com.edu.cibertec.vacunacion.proyecto2.servicio;

import com.edu.cibertec.vacunacion.proyecto2.model.estado;
import com.edu.cibertec.vacunacion.proyecto2.repository.EstadoRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class EstadoServiceImp implements EstadoService{

    @Autowired
    private EstadoRepository repoEstado;
    
    @Override
    public List<estado> listarEstado() {
     return repoEstado.findAll();
    }
    
}
