
package com.edu.cibertec.vacunacion.proyecto2.repository;

import com.edu.cibertec.vacunacion.proyecto2.model.empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<empleados, Integer>{
    
    empleados findByNombreusuarioAndContrasena(String nombreusuario,String contrasena);
    empleados findByNombreusuario(String nombreusuario);
    empleados findByEmpleadoid (int empleadoid);
    
}
