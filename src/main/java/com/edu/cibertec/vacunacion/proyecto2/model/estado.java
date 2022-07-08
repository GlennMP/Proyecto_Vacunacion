
package com.edu.cibertec.vacunacion.proyecto2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_estado")
public class estado {
    
    @Id
    @Column(name="id_esta")
    private int estadoid;
	
    @Column(name="nom_esta")
    private String nombre;
    
}
