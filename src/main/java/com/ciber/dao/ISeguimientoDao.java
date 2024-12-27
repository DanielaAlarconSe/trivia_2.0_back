package com.ciber.dao;

import java.util.List;

import com.ciber.dto.EmailNotificacionDto;
import com.ciber.entities.Seguimiento;

public interface ISeguimientoDao {

	public List<Seguimiento> obtenerSeguimiento();
	
	public void EnviarCorreoAspirante(EmailNotificacionDto email);
}
