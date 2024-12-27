package com.ciber.service;

import java.util.List;

import com.ciber.entities.Entidad;

public interface IEntidadService {

	public int registrarEntidad(Entidad entidad);

	public int actualizarEntidad(Entidad entidad);

	int eliminarEntidad(Entidad entidad);
	
	public List<Entidad> obtenerEntidad();
}
