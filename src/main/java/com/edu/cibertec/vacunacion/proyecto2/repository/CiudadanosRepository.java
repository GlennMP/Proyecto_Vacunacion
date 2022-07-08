
package com.edu.cibertec.vacunacion.proyecto2.repository;

import com.edu.cibertec.vacunacion.proyecto2.model.ciudadanos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadanosRepository extends JpaRepository<ciudadanos,Integer>{
    
    List<ciudadanos> findByEstado(Integer estado);
    ciudadanos findByCiudadanoid(Integer ciudadanoid);
    List<ciudadanos> findByNombre(String nombre);
    List<ciudadanos> findByDni(String dni);
    ciudadanos findByNombreAndDni(String nombre,String dni);
}
