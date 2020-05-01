package com.mitocode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.model.TipoEmpleado;


public interface TipoEmpleadoService {
	
	List<TipoEmpleado> obtenerTipos();
}
