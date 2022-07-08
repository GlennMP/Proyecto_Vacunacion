
package com.edu.cibertec.vacunacion.proyecto2.controller;

import com.edu.cibertec.vacunacion.proyecto2.model.empleados;
import com.edu.cibertec.vacunacion.proyecto2.model.vacuna;
import com.edu.cibertec.vacunacion.proyecto2.repository.VacunaRepository;
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
public class VacunasController {

	@Autowired
	private VacunaService servisVacuna;

	@GetMapping("/cargar_Vacunas")
	private String cargarCiudadanos(Model model, HttpServletRequest request) {

		HttpSession mi = (HttpSession) request.getSession();

		if (mi.getAttribute("carsession") == null || (int) mi.getAttribute("carsession") != 1) {

			model.addAttribute("empleados", new empleados());
			return "Index";

		} else {

			model.addAttribute("lista_vacu", servisVacuna.listarVacuna());
			return "Lista_Vacunas";

		}

	}

	@GetMapping("/registrar_Vacuna")
	private String registrarUsuarios(Model model, HttpServletRequest request) {

		HttpSession mi = (HttpSession) request.getSession();

		if (mi.getAttribute("carsession") == null || (int) mi.getAttribute("carsession") != 1) {

			model.addAttribute("empleados", new empleados());
			return "Index";

		}else {
			
			model.addAttribute("vacuna", new vacuna());
			return "Registrar_Vacuna";
			
		}

	}

	@PostMapping("/grabar_Vacuna")
	public String grabarusu(@ModelAttribute vacuna vacuna, Model model) {
		System.out.println(vacuna);
		servisVacuna.guardarvacuna(vacuna);
		model.addAttribute("lista_vacu", servisVacuna.listarVacuna());
		model.addAttribute("mensaje", "Registro correcto");

		return "Lista_Vacunas";
	}

}
