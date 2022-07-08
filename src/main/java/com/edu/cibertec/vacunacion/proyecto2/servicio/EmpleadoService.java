
package com.edu.cibertec.vacunacion.proyecto2.servicio;

/* 
import com.edu.cibertec.vacunacion.proyecto2.model.cargo;
import com.edu.cibertec.vacunacion.proyecto2.model.empleados;
import com.edu.cibertec.vacunacion.proyecto2.repository.CargoRepository;
import com.edu.cibertec.vacunacion.proyecto2.repository.EmpleadosRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
        
        */

//@Service("userDetailsService")
//@Slf4j
public class EmpleadoService /*implements UserDetailsService*/ {

    
   /* @Autowired
    private EmpleadosRepository repoempleado;
    @Autowired
    private CargoRepository repocargo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         empleados em = repoempleado.findByNombreusuario(username);
         cargo car = repocargo.findById(em.getCargo());
         if(em == null){
            throw new UsernameNotFoundException(username);
        }
         List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(car.getNombrecargo()));
        UserDetails userdet = new User(em.getNombre(),em.getContrasena(),roles);
        return userdet;
    }
    
    */
    
}
