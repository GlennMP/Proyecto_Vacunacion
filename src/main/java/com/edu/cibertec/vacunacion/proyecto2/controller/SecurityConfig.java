/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.cibertec.vacunacion.proyecto2.controller;

/*
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

*/

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
	//	  prePostEnabled = true, 
		//  securedEnabled = true, 
		  //jsr250Enabled = true)
//@Configuration
public class SecurityConfig /* extends WebSecurityConfigurerAdapter */{
    
/*	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
    //@Autowired
    //private UserDetailsService userDetailsService;
    
    //@Bean
    //public BCryptPasswordEncoder passwordEncoder(){
    //    return new BCryptPasswordEncoder();
    //}
    
    //@Override
    //public void configure(AuthenticationManagerBuilder build) throws Exception{
    //    build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    //}
    

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http.authorizeRequests().antMatchers("/","/css/**","/img/**").permitAll()
	      .antMatchers("/cargarCiudadanos/**","/registrar_Ciu/**","/grabar_Ciu/**","/listar_Ciu/**","/cargar_Vacunado2/**","/registrar_Vacunado/**","/grabar_Vacunado/**","/listar_Vacunado/**","/nueva_dosiss/**","/grabar_nueva_dosis/**","/cargar_estadvacuna/**").hasAnyRole("ADMIN","DOCTOR","DOCTORA")
	      .antMatchers("/listar_usuarios/**","/registrar/**","/grabar/**","/esitar/**","/cargar_Vacunas/**","/registrar_Vacuna/**","/grabar_Vacuna/**").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().permitAll()
                          .and().logout().permitAll();
	    	    
	}

	@Autowired
        public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
    	builder.jdbcAuthentication().
    	dataSource(dataSource).
    	passwordEncoder(passEncoder).
    	usersByUsernameQuery("select usr_emp,cla_emp,esrado from tb_empleados where usr_emp=?").
    	authoritiesByUsernameQuery("select e.usr_emp,r.nom_car from rol r inner join tb_empleados e on r.id_car=e.idcargo where e.usr_emp=?");
    }
    
        
    	*/
   
}
