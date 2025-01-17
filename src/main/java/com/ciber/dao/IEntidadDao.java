package com.ciber.dao;

import java.util.List;

import com.ciber.entities.Entidad;

public interface IEntidadDao {

	public int registrarEntidad(Entidad entidad);

	public int actualizarEntidad(Entidad entidad);

	int eliminarEntidad(Entidad entidad);

	public List<Entidad> obtenerEntidad();
}
