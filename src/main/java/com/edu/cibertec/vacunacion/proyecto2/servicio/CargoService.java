package com.edu.cibertec.vacunacion.proyecto2.servicio;

import java.util.List;
import com.edu.cibertec.vacunacion.proyecto2.model.cargo;

public interface CargoService {
	
	List<cargo> listarCargo();
	cargo filtrarCargoPorId (int id);
        

}
