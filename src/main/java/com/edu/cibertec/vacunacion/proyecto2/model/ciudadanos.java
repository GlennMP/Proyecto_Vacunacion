
package com.edu.cibertec.vacunacion.proyecto2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_ciudadanos")
public class ciudadanos {
    
    @Id
    @Column(name="id_ciud")
    private int ciudadanoid; 
    @Column(name="nom_ciud")
    private String nombre;  
	
    @Column(name="ape_ciud")
    private String apellido;
	
    @Column(name="tlf_ciud")
    private String tlf;
	
    @Column(name="direccion_ciud")
    private String direccion; 
	
    @Column(name="dni_ciud")
    private String dni; 
	
    @Column(name="nacim_ciud")
    private String nacim;  
	
    @Column(name="idestado")
    private int estado;
}
