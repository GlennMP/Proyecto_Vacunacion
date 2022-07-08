package com.edu.cibertec.vacunacion.proyecto2.servicio;

import com.edu.cibertec.vacunacion.proyecto2.model.empleados;
import com.edu.cibertec.vacunacion.proyecto2.repository.EmpleadosRepository;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class EmpleadosServiceImp implements EmpleadosService{

    @Autowired
    private EmpleadosRepository repoEmpleado;
    
    
    @Override
   // @RolesAllowed("ROLE_ADMIN")
    public List<empleados> listarEmpleados() {
        return repoEmpleado.findAll();
    }

    @Override
    public empleados guardarEmpleados(String nombre, String apellido, String telefono, String edad, String nombreusuario, String contrasena, int cargo) {
    
        empleados emple = new empleados();
        emple.setNombre(nombre);
        emple.setApellido(apellido);
        emple.setTelefono(telefono);
        emple.setEdad(edad);
        emple.setNombreusuario(nombreusuario);
        emple.setContrasena(contrasena);
        emple.setCargo(cargo);
        return repoEmpleado.save(emple);
    }

    @Override
    //@RolesAllowed("ROLE_ADMIN")
    public empleados filtrarEmpleadoPorId(int id) {
            return repoEmpleado.findByEmpleadoid(id);
    }

    @Override
    public empleados logeoEmpleado(String nombreusuario, String contrasena) {
        return repoEmpleado.findByNombreusuarioAndContrasena(nombreusuario, contrasena);
    }

    @Override
    public empleados editarEmpleado(int id, String nombre, String apellido, String telefono, String edad, String usuario, String contrasena, int cargo) {
        empleados e = new empleados();
        e.setEmpleadoid(id);
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setTelefono(telefono);
        e.setEdad(edad);
        e.setNombreusuario(usuario);
        e.setContrasena(contrasena);
        e.setCargo(cargo);
        return repoEmpleado.save(e);
    }
    
}
