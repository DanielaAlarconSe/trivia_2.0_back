package com.ciber.dao;

import java.util.List;

import com.ciber.dto.AsignacionDto;
import com.ciber.entities.AsignacionTrivia;

public interface IAsignacionDao {

	public List<AsignacionDto> obtenerAspirantesPorEntidad(Integer entidad);
	
	public List<AsignacionDto> obtenerAspirante(Integer codigo);
	
	public int registrarAsignacionTrivia(AsignacionTrivia asignacion);

	public int actualizarAsignacionTrivia(AsignacionTrivia asignacion);

	int eliminarAsignacionTrivia(AsignacionTrivia asignacion);
}
