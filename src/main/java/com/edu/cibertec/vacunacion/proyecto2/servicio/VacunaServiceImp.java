
package com.edu.cibertec.vacunacion.proyecto2.servicio;

import com.edu.cibertec.vacunacion.proyecto2.model.vacuna;
import com.edu.cibertec.vacunacion.proyecto2.repository.VacunaRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class VacunaServiceImp implements VacunaService{

    @Autowired
    public VacunaRepository repovacuna;
    
    @Override
    public List<vacuna> listarVacuna() {
     return repovacuna.findAll();
    }

    @Override
    public vacuna guardarvacuna(vacuna vacuna) {
     return repovacuna.save(vacuna);
    }
    
    
}
