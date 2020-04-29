package com.mitocode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.model.TipoEmpleado;

@Service
public interface TipoEmpleadoService {
	
	List<TipoEmpleado> obtenerTipos();
}
