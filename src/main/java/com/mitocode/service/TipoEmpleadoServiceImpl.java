package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mitocode.mapper.TipoEmpleadoMapper;
import com.mitocode.model.TipoEmpleado;

public class TipoEmpleadoServiceImpl implements TipoEmpleadoService {

	@Autowired
	private TipoEmpleadoMapper  tipoEmpleadoMapper;
	
	@Override
	public List<TipoEmpleado> obtenerTipos() {
		
		return tipoEmpleadoMapper.obtenerTipos();
	}

}
