package com.mitocode.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitocode.dto.EmpleadoDTO;
import com.mitocode.model.Empleado;
import com.mitocode.service.EmpleadoService;

@Controller
public class LoginController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String loginForm(ModelMap model) {
		model.put("name", "Dany");
		return "login";
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam String user, @RequestParam String password, Principal principal) {
		
		Empleado empleado = empleadoService.login(user, password);
		
		if(empleado instanceof Empleado) {
			
			EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleado);
			model.put("nombresCompletos",empleadoDTO.getNombresCompleto());
			
		//	return "bienvenido";
			return principal != null ? "index" : "fragments/layout";
		}else {
			model.put("message","Usuario y/o contraseña incorrectos");
			return "login";
		}
		
		
	}
}
