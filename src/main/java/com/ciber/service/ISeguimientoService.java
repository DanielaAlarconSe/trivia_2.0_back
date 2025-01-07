package com.ciber.service;

import java.util.List;

import com.ciber.dto.EmailNotificacionDto;
import com.ciber.entities.AsignacionTrivia;
import com.ciber.entities.Seguimiento;

public interface ISeguimientoService {

	public List<Seguimiento> obtenerSeguimiento();
	
	public void EnviarCorreoAspirante(EmailNotificacionDto email);
	
	public void EnviarCorreoEntidad(EmailNotificacionDto email);
	
	public int actualizarSeguimiento(AsignacionTrivia asignacion);
}
