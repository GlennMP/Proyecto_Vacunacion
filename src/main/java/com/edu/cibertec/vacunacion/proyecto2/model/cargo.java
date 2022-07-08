
package com.edu.cibertec.vacunacion.proyecto2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="rol")
public class cargo {
    
    @Id
    @Column(name="id_car")
    private int cargoid;
    
    @Column(name="nom_car")
    private String nombrecargo;
    
}
