
package com.edu.cibertec.vacunacion.proyecto2.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="tb_detalle_ciudadanos")
public class detalle {
    
    @Id
    @Column(name="iddetalle")
    private int detalleid;  
	
    @Column(name="idempleados")
    private int detalleidempleados;  
	
    @Column(name="idvacuna")
    private int detalleidvacuna;
	
    @Column(name="idciudadanos")
    private int detalleidciudadanos;
	
    @Column(name="fecha_dosis")
    private Date detallefechadosis; 
	
    @Column(name="numero_vacu")
    private String detallenumerovacuna;
    
    
}
