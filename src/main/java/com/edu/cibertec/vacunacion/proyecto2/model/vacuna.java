
package com.edu.cibertec.vacunacion.proyecto2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_tipo_vacuna")
public class vacuna {
    
    @Id
    @Column(name="id_tpva")
    private int tippvaid;
	
    @Column(name="nom_tpva")
    private String nomtpva;
	
    @Column(name="dosis_tpva")
    private String dosistpva;
	
    @Column(name="pais_tpva")
    private String paistpva;
    
}
