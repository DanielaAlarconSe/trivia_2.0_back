package com.ciber.service;

import java.util.List;

import com.ciber.dto.AsignacionDto;
import com.ciber.entities.AsignacionTrivia;

public interface IAsignacionService {

	public List<AsignacionDto> obtenerAspirantesPorEntidad(Integer entidad);
	
	public int registrarAsignacionTrivia(AsignacionTrivia asignacion);

	public int actualizarAsignacionTrivia(AsignacionTrivia asignacion);

	int eliminarAsignacionTrivia(AsignacionTrivia asignacion);
}