
package com.edu.cibertec.vacunacion.proyecto2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_empleados")
public class empleados {
    
    @Id
    @Column(name="id_emp")
    private int empleadoid;
	
    @Column(name="nom_emp")
    private String nombre;
	
    @Column(name="ape_emp")
    private String apellido;
	
    @Column(name="tlf_emp")
    private String telefono;
	
    @Column(name="edad_emp")
    private String edad;
	
    @Column(name="usr_emp")
    private String nombreusuario;
	
    @Column(name="cla_emp")
    private String contrasena;
	
    @Column(name="idcargo")
    private int cargo;
    
}
