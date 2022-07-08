package com.edu.cibertec.vacunacion.proyecto2.servicio;

import com.edu.cibertec.vacunacion.proyecto2.model.ciudadanos;
import com.edu.cibertec.vacunacion.proyecto2.repository.CiudadanosRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class CiudadanosServiceImp implements CiudadanosService{

    @Autowired
    private CiudadanosRepository repoCiudadanos;
    
    @Override
    public List<ciudadanos> filPorEstadoId(int id) {
     return repoCiudadanos.findByEstado(id);
    }

    @Override
    public ciudadanos findByCiudadanoid(int ciudadanoid) {
     return repoCiudadanos.findByCiudadanoid(ciudadanoid);
    }

    @Override
    public List<ciudadanos> findByNombre(String nombre) {
     return repoCiudadanos.findByNombre(nombre);
    }

    @Override
    public List<ciudadanos> findByDni(String dni) {
     return repoCiudadanos.findByDni(dni);
    }

    @Override
    public ciudadanos findByNombreAndDni(String nombre, String dni) {
     return repoCiudadanos.findByNombreAndDni(nombre, dni);
    }

    @Override
    public ciudadanos guardar(ciudadanos ciudadanos) {
        return repoCiudadanos.save(ciudadanos);
    }

    @Override
    public List<ciudadanos> listadoDeCiudadano() {
     return repoCiudadanos.findAll();
    }
    
}
