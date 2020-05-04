package com.mitocode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.mitocode.model.Empleado;
import com.mitocode.model.TipoEmpleado;
import com.mitocode.service.EmpleadoService;
import com.mitocode.service.TipoEmpleadoService;

@SpringBootTest
@ContextConfiguration
public class EmpleadoServiceTest {
	
	
	private static final Logger logger = LoggerFactory.getLogger(EmpleadoServiceTest.class);


	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private TipoEmpleadoService tipoEmpleadoService;
	
	@Test
	public void insert() {
		Empleado empleado = new Empleado();
		empleado.setNombres("Javier");
		empleado.setApellidos("Flores");
		empleado.setDocumento("123456");
		
		empleado.setFechaNacimiento(LocalDate.now());
		empleado.setSueldo(1000);
		empleado.setNumeroHijos(0);
		empleado.setUsuario("admin");
		empleado.setClave("admin");
		
		TipoEmpleado tipoEmpleado = new TipoEmpleado();
		tipoEmpleado.setIdTipoEmpleado(2);
		
		empleado.setTipoEmpleado(tipoEmpleado);
		
		int status = empleadoService.registrar(empleado);
		Assert.state(status == 1, "Insert Failed");
	//	Assert.state(empleado.getIdEmpleado()==4, "Insert Failed 2");
	}
	
	@Test
	public void update() {
		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1);
		empleado.setNombres("Juan");
		empleado.setApellidos("Cenas Vasquez");
		empleado.setDocumento("12345678");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		//se le asigna un patron a la clase DateTimeFormatter SE PUEDE CAMBIAR EL PATRON
		String date = "13/10/1992";
		
		LocalDate localDate = LocalDate.parse(date, formatter);
		empleado.setFechaNacimiento(localDate.plusYears(2));
		
//		empleado.setFechaNacimiento(LocalDate.now());
		empleado.setSueldo(1000);
		empleado.setNumeroHijos(10);
		empleado.setUsuario("123");
		empleado.setClave("123");
		
		int status = empleadoService.actualizar(empleado);
		Assert.state(status==1, "Update Failed");
	}
	
	@Test
	public void delete() {
		int idEmpleado = 10;
		
		
		int status = empleadoService.eliminar(idEmpleado);
		Assert.state(status==1, "Deletion  Failed");
	}
	
	@Test
	public void list() {
		
		List<Empleado> list = empleadoService.obtenerEmpleados();
		Assert.notNull(list, "List is null");
		Assert.notEmpty(list, "List is empty");
		
	}
	
	@Test
	public void listTipos() {
		
		List<TipoEmpleado> list = tipoEmpleadoService.obtenerTipos();
		list.stream().forEach(e -> logger.info(e.toString()));
		Assert.notNull(list, "list is null");
		Assert.notEmpty(list, "list is empty");
	}
	
	@Test
	public void testLogin() {
		
		Empleado empleado = empleadoService.login("admin", "123456");
		logger.info(empleado.toString());
		Assert.notNull(empleado, "empleado is null");
		
	}
	
	
}
