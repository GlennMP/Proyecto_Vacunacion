
package com.edu.cibertec.vacunacion.proyecto2.controller;

import com.edu.cibertec.vacunacion.proyecto2.model.ciudadanos;
import com.edu.cibertec.vacunacion.proyecto2.model.empleados;
import com.edu.cibertec.vacunacion.proyecto2.servicio.CargoService;
import com.edu.cibertec.vacunacion.proyecto2.servicio.EmpleadosService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class EmpleadoContriller {

	final int se = 0;

	// aqui creamos un objieto conectado con el repositorio es decir que
	// "repoempleado" tiene todo el crud
	@Autowired
	private EmpleadosService servisEmpleado;

	@Autowired
	private CargoService servisCargo;

	/*
	 * @Autowired private BCryptPasswordEncoder bcryptPasswordEncoder ;
	 */

	@GetMapping("/listar_usuarios")
	private String listarUsuarios(Model model, HttpServletRequest request) {

		HttpSession mi = (HttpSession) request.getSession();

		if (mi.getAttribute("carsession") == null || (int) mi.getAttribute("carsession") != 1) {

			model.addAttribute("empleados", new empleados());
			return "Index";

		} else {

			model.addAttribute("lista_usuarios", servisEmpleado.listarEmpleados());
			model.addAttribute("lista_cargo", servisCargo.listarCargo());
			return "Listar_Usuarios";

		}

	}

	@GetMapping("/registrar")
	private String registrarUsuarios(Model model, HttpServletRequest request) {

		HttpSession mi = (HttpSession) request.getSession();

		if (mi.getAttribute("carsession") == null || (int) mi.getAttribute("carsession") != 1) {

			model.addAttribute("empleados", new empleados());
			return "Index";

		} else {

			model.addAttribute("empleados", new empleados());
			model.addAttribute("lista_cargo", servisCargo.listarCargo());
			return "Registrar_Usuario";

		}

	}

	@PostMapping("/grabar")
	public String grabarusu(@ModelAttribute empleados empleados, Model model) {

		if (empleados.getCargo() == -1) {

			System.out.println(empleados);
			model.addAttribute("mensaje", "Error al registrar");
			model.addAttribute("lista_cargo", servisCargo.listarCargo());
			return "Registrar_Usuario";

		} else {

			System.out.println(empleados);
			model.addAttribute("mensaje", "Registro correcto");
			servisEmpleado.editarEmpleado(empleados.getEmpleadoid(), empleados.getNombre(), empleados.getApellido(),
					empleados.getTelefono(), empleados.getEdad(), empleados.getNombreusuario(),
					/* bcryptPasswordEncoder.encode( */empleados.getContrasena()/* ) */, empleados.getCargo());
			// servisEmpleado.guardarEmpleados(empleados.getNombre(),empleados.getApellido(),empleados.getTelefono(),empleados.getEdad(),empleados.getNombreusuario(),/*bcryptPasswordEncoder.encode(
			// */empleados.getContrasena()/*) */, empleados.getCargo());
			model.addAttribute("lista_usuarios", servisEmpleado.listarEmpleados());
			model.addAttribute("lista_cargo", servisCargo.listarCargo());
			return "Listar_Usuarios";
		}

	}

	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("empleados", new empleados());
		return "Index";

	}

	@GetMapping("/salir")
	public String salir(Model model, HttpServletRequest request) {

		HttpSession mi = (HttpSession) request.getSession();
		mi.invalidate();
		model.addAttribute("empleados", new empleados());
		return "Index";
	}

	@PostMapping("/valida")
	public String valida(@ModelAttribute empleados empleados, Model model, HttpServletRequest request) {

		empleados em = servisEmpleado.logeoEmpleado(empleados.getNombreusuario(), empleados.getContrasena());

		if (em != null) {
			HttpSession mi = request.getSession(true);
			int carsession = em.getCargo();
			mi.setAttribute("carsession", carsession);
			return "Dentro_del_sistema";
		} else {

			model.addAttribute("empleados", new empleados());
			return "Index";
		}
	}

	@PostMapping("/esitar")
	// "P" es el nombre que le das a las variables de tu recorrido en la pagina
	// Lista usuarios
	public String buscaremple(@ModelAttribute empleados p, Model model) {
		model.addAttribute("empleados", servisEmpleado.filtrarEmpleadoPorId(p.getEmpleadoid()));
		model.addAttribute("lista_cargo", servisCargo.listarCargo());
		model.addAttribute("mensaje", "Registra Cambios");

		return "Registrar_Usuario";
	}

}
