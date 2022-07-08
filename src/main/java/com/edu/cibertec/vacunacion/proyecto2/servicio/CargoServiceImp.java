package com.edu.cibertec.vacunacion.proyecto2.servicio;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.cibertec.vacunacion.proyecto2.model.cargo;
import com.edu.cibertec.vacunacion.proyecto2.repository.CargoRepository;
import com.edu.cibertec.vacunacion.proyecto2.repository.EmpleadosRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CargoServiceImp implements CargoService {
	
	@Autowired
    private CargoRepository repoCargo;

	
	@Override
   // @RolesAllowed("ROLE_ADMIN")
	public cargo filtrarCargoPorId(int id) {
		return repoCargo.findById(id);
	}


	@Override
	//@RolesAllowed("ROLE_ADMIN")
	public List<cargo> listarCargo() {
		return repoCargo.findAll();
	}

}
