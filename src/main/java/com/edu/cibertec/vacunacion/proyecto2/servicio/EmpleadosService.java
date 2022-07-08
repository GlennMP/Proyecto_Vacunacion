
package com.edu.cibertec.vacunacion.proyecto2.servicio;
import com.edu.cibertec.vacunacion.proyecto2.model.empleados;

import java.util.List;


public interface EmpleadosService {
    
    List<empleados> listarEmpleados();
    empleados guardarEmpleados (String nombre,String apellido,String telefono,String edad,String nombreusuario,String contrasena,int cargo);
    empleados filtrarEmpleadoPorId (int id);
    empleados logeoEmpleado(String nombreusuario,String contrasena);
    empleados editarEmpleado(int id,String nombre,String apellido,String telefono,String edad,String usuario,String contrasena, int cargo);
}
