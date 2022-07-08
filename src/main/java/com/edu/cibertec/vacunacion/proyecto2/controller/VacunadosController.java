
package com.edu.cibertec.vacunacion.proyecto2.controller;

import com.edu.cibertec.vacunacion.proyecto2.model.ciudadanos;
import com.edu.cibertec.vacunacion.proyecto2.model.detalle;
import com.edu.cibertec.vacunacion.proyecto2.model.empleados;
import com.edu.cibertec.vacunacion.proyecto2.repository.CiudadanosRepository;
import com.edu.cibertec.vacunacion.proyecto2.repository.DetalleRepository;
import com.edu.cibertec.vacunacion.proyecto2.repository.EmpleadosRepository;
import com.edu.cibertec.vacunacion.proyecto2.repository.EstadoRepository;
import com.edu.cibertec.vacunacion.proyecto2.repository.VacunaRepository;
import com.edu.cibertec.vacunacion.proyecto2.servicio.CiudadanosService;
import com.edu.cibertec.vacunacion.proyecto2.servicio.DetalleService;
import com.edu.cibertec.vacunacion.proyecto2.servicio.EmpleadosService;
import com.edu.cibertec.vacunacion.proyecto2.servicio.EstadoService;
import com.edu.cibertec.vacunacion.proyecto2.servicio.VacunaService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class VacunadosController {

	public int idvacu = 0;

	@Autowired
	private CiudadanosService servisCiudadano;
	@Autowired
	private EmpleadosService servisEpleados;
	@Autowired
	private VacunaService servisVacuna;
	@Autowired
	private EstadoService servisEstado;
	@Autowired
	private DetalleService servisDetalle;

	@GetMapping("/cargar_Vacunado2")
	private String cargarCiudadanos(Model model, HttpServletRequest request) {

		HttpSession mi = (HttpSession) request.getSession();
		
		if(mi.getAttribute("carsession")==null) {
			
			model.addAttribute("empleados", new empleados());
			return "Index";
			
		}else {
			
		int carsession = (int) mi.getAttribute("carsession");
		if (carsession == 1 || carsession == 2 || carsession == 3) {

			model.addAttribute("lista_cuidadanos", servisCiudadano.filPorEstadoId(2));
			model.addAttribute("lista_estado", servisEstado.listarEstado());
			//model.addAttribute("mensaje", "Registra Cambios");
			return "Lista_Vacunados";

		} else {

			model.addAttribute("empleados", new empleados());
			return "Index";

		}}

	}

	@GetMapping("/registrar_Vacunado")
	private String registrarUsuarios(Model model) {
		model.addAttribute("ciudadanos", new ciudadanos());
		return "Actuliza_Vacuna";
	}

	@PostMapping("/grabar_Vacunado")
	public String grabarusu(@ModelAttribute ciudadanos ciudadanos, Model model) {
		System.out.println(ciudadanos);
		// Utilizamos el metodo save para registrar al ciudadano
		servisCiudadano.guardar(ciudadanos);
		// model.addAttribute("lista_emepleados", repoemepleados.findAll());
		// model.addAttribute("lista_vacunas", repovacuna.findAll());
		model.addAttribute("lista_cuidadanos", servisCiudadano.filPorEstadoId(2));
		model.addAttribute("lista_emepleados", servisEpleados.listarEmpleados());
		model.addAttribute("lista_vacunas", servisVacuna.listarVacuna());
		model.addAttribute("lista_estado", servisEstado.listarEstado());
		model.addAttribute("mensaje", "Registro correcto");

		return "Lista_Vacunados";
	}

	@PostMapping("/listar_Vacunado")
	// "P" es el nombre que le das a las variables de tu recorrido en la pagina
	// Lista usuarios
	public String buscaremple(@ModelAttribute ciudadanos v, Model model) {
		System.out.println(v);

		int id = v.getCiudadanoid();
		idvacu = id;

		model.addAttribute("detalleciudadano", servisDetalle.findByDetalleidciudadanos(v.getCiudadanoid()));
		model.addAttribute("lista_emepleados", servisEpleados.listarEmpleados());
		model.addAttribute("lista_vacunas", servisVacuna.listarVacuna());
		model.addAttribute("lista_ciudadanos", servisCiudadano.listadoDeCiudadano());

		return "Historial_de_vacunas";
	}

	@GetMapping("/nueva_dosiss")
	// "P" es el nombre que le das a las variables de tu recorrido en la pagina
	// Lista usuarios
	public String buscaremple(@ModelAttribute detalle detalle, Model model) {

		model.addAttribute("iddeciudadanos", idvacu);
		model.addAttribute("lista_emepleados", servisEpleados.listarEmpleados());
		model.addAttribute("lista_vacunas", servisVacuna.listarVacuna());
		return "crudnuevadosis";
	}

	@PostMapping("/grabar_nueva_dosis")
	public String grabarusu(@ModelAttribute detalle detalle, Model model) {
		System.out.println(detalle);

		detalle.setDetalleidciudadanos(idvacu);

		if (detalle.getDetalleidempleados() == -1 || detalle.getDetalleidvacuna() == -1) {

			model.addAttribute("mensaje", "Error al registrar");
			model.addAttribute("lista_emepleados", servisEpleados.listarEmpleados());
			model.addAttribute("lista_vacunas", servisVacuna.listarVacuna());
			model.addAttribute("lista_estado", servisEstado.listarEstado());
			return "crudvacunados";

		} else {

			// Utilizamos el metodo save para registrar al ciudadano
			servisDetalle.guardarDetalle(detalle);
			model.addAttribute("lista_cuidadanos", servisCiudadano.filPorEstadoId(2));
			model.addAttribute("lista_estado", servisEstado.listarEstado());
			model.addAttribute("mensaje", "Registra Cambios");
			idvacu = 0;
			return "Lista_Vacunados";

		}

	}

	@GetMapping("/cargar_estadvacuna")
	private String cargaestadvacuna(Model model, HttpServletRequest request) {

		HttpSession mi = (HttpSession) request.getSession();

		if(mi.getAttribute("carsession")==null|| (int) mi.getAttribute("carsession") != 1 ) {
			
			model.addAttribute("empleados", new empleados());
			return "Index";
			
		}else {
			model.addAttribute("lista_vacunadoss", servisCiudadano.filPorEstadoId(1));
			model.addAttribute("lista_novacunadoss", servisCiudadano.filPorEstadoId(2));
			return "Estadisticas";
		}
	}

}
