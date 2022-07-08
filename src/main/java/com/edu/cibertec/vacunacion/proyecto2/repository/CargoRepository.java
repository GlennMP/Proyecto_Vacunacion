
package com.edu.cibertec.vacunacion.proyecto2.repository;

import com.edu.cibertec.vacunacion.proyecto2.model.cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<cargo,Integer>{
    
    cargo findById(int id);
}
