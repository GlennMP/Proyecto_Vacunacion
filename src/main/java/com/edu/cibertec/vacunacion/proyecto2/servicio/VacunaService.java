
package com.edu.cibertec.vacunacion.proyecto2.servicio;

import com.edu.cibertec.vacunacion.proyecto2.model.vacuna;
import java.util.List;

 
public interface VacunaService {
    
    List<vacuna> listarVacuna();
    vacuna guardarvacuna (vacuna vacuna);
    
}
