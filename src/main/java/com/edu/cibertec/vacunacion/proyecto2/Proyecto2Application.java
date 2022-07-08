package com.edu.cibertec.vacunacion.proyecto2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Proyecto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto2Application.class, args);
                System.out.println("Listo");
                
                
                /**
	 * TECNOLOGI UTILIZADA:
         * dependecia de bootstrap con meven
         * dependencia de font-awesome para iconos con bootstrap
         * dependencia de webjars-locator con bootstrap
         * OJO: 
         * -"EN TU BASE DE DATOS" EN LA TABLA ROLES PARA LOGIARTE TIENES QUE 
         * TENER COMO NOMBRE LOS LIGIENTES ROLES: ROLE_ADMIN ,ROLE_USER PORQUE SI NO EL 
         * SPRINT SEGURIDAD NO TE RECONOCERA LOS ROLES QUE TIENE ESE USUARIO QUE SE LOGIO
         * -SI TRABAJAS CON SPRIN SEGURIDAD LAS CONTRASEÑAS REGISTRADAS EN TU BASE DE DATOS 
         * TIENE QUE ESTAR REGISTRADAS ENCRIPTADAS PORQUE SI NO EL SPRIN SEGURIDA NO TE LO RECONOCE 
         * LA CONTRASEÑA CUANDO TE LOGES
	 */
                
	}

}
