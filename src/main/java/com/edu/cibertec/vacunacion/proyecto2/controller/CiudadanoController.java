
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
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CiudadanoController {

	public int id = 0;

	@Autowired
	private CiudadanosService servisCiudadanos;
	@Autowired
	private EmpleadosService servisEpleados;
	@Autowired
	private VacunaService servisVacuna;
	@Autowired
	private EstadoService servisEstado;
	@Autowired
	private DetalleService servisDetalle;
	@Autowired
	private DetalleRepository repoDetalle;

	@GetMapping("/cargarCiudadanos")
	private String cargarCiudadanos(Model model, HttpServletRequest request) {

		HttpSession mi = (HttpSession) request.getSession();

		if (mi.getAttribute("carsession") == null) {

			model.addAttribute("empleados", new empleados());
			return "Index";

		} else {

			int carsession = (int) mi.getAttribute("carsession");
			if (carsession == 1 || carsession == 2 || carsession == 3) {

				model.addAttribute("lista_cuidadanos", servisCiudadanos.filPorEstadoId(1));
				return "Lista_Ciudadanos";

			} else {

				model.addAttribute("empleados", new empleados());
				return "Index";

			}
		}

	}

	@GetMapping("/registrar_Ciu")
	private String registrarUsuarios(Model model) {
		model.addAttribute("ciudadanos", new ciudadanos());
		model.addAttribute("lista_emepleados", servisEpleados.listarEmpleados());
		model.addAttribute("lista_vacunas", servisVacuna.listarVacuna());
		return "crudvacunados";
	}

	@PostMapping("/grabar_Ciu")
	public String grabarusu(@ModelAttribute detalle detalle, Model model) {
		System.out.println(detalle);

		// insertando id del ciudadano que sera vacunado
		detalle.setDetalleidciudadanos(id);

		if (detalle.getDetalleidempleados() == -1 || detalle.getDetalleidvacuna() == -1) {

			model.addAttribute("mensaje", "Error al registrar");
			model.addAttribute("lista_emepleados", servisEpleados.listarEmpleados());
			model.addAttribute("lista_vacunas", servisVacuna.listarVacuna());
			model.addAttribute("lista_estado", servisEstado.listarEstado());
			return "crudvacunados";

		} else {

			// Utilizamos el metodo save para registrar al ciudadano

			ciudadanos p = servisCiudadanos.findByCiudadanoid(this.id);

			p.setEstado(2);
			servisCiudadanos.guardar(p);
			servisDetalle.guardarDetalle(detalle);
			model.addAttribute("lista_cuidadanos", servisCiudadanos.filPorEstadoId(1));
			model.addAttribute("mensaje", "Registro correcto");
			id = 0;
			return "Lista_Ciudadanos";

		}

	}

	@PostMapping("/listar_Ciu")
	// "P" es el nombre que le das a las variables de tu recorrido en la pagina
	// Lista usuarios
	public String buscaremple(@ModelAttribute ciudadanos v , Model model) {

		
			int id = v.getCiudadanoid();
			this.id = id;

			model.addAttribute("iddeciudadanos", this.id);
			model.addAttribute("detalle", new detalle());
			model.addAttribute("lista_emepleados", servisEpleados.listarEmpleados());
			model.addAttribute("lista_vacunas", servisVacuna.listarVacuna());
			return "crudvacunados";

		}

	

}
