
package com.edu.cibertec.vacunacion.proyecto2.repository;

import com.edu.cibertec.vacunacion.proyecto2.model.estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<estado, Integer>{
    
    
    
}
