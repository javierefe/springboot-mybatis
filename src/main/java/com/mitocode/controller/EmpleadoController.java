package com.mitocode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitocode.service.EmpleadoService;

@Controller
public class EmpleadoController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmpleadoController.class);
	
	@Autowired
		private EmpleadoService empleadoService;
	
	@RequestMapping("/empleados")
	public String listarEmpleados(Model model) {
		

		model.addAttribute("listaEmpleados", empleadoService.obtenerEmpleados());
		
		return "empleados/empleados";
	}

}
