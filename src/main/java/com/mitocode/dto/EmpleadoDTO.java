package com.mitocode.dto;

import com.mitocode.model.Empleado;

public class EmpleadoDTO {

	private String nombresCompleto;

	public EmpleadoDTO(Empleado empleado) {
		super();
		this.setNombresCompleto(String.join(" ", empleado.getNombres() , empleado.getApellidos()));
	}

	public String getNombresCompleto() {
		return nombresCompleto;
	}

	public void setNombresCompleto(String nombresCompleto) {
		this.nombresCompleto = nombresCompleto;
	}
	
	
	
}
