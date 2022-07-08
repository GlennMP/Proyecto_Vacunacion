package com.edu.cibertec.vacunacion.proyecto2.servicio;

import com.edu.cibertec.vacunacion.proyecto2.model.ciudadanos;
import java.util.List;


public interface CiudadanosService {
    
    List<ciudadanos> filPorEstadoId(int id);
    ciudadanos findByCiudadanoid(int ciudadanoid);
    List<ciudadanos> findByNombre(String nombre);
    List<ciudadanos> findByDni(String dni);
    ciudadanos findByNombreAndDni(String nombre,String dni);
    ciudadanos guardar(ciudadanos ciudadanos);
    List<ciudadanos> listadoDeCiudadano ();
}
