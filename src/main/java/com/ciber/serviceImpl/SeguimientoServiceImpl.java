package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.ISeguimientoDao;
import com.ciber.dto.EmailNotificacionDto;
import com.ciber.entities.AsignacionTrivia;
import com.ciber.entities.Seguimiento;
import com.ciber.service.ISeguimientoService;

@Service
public class SeguimientoServiceImpl implements ISeguimientoService{
	
	@Autowired
	ISeguimientoDao seguimientoDao;

	@Override
	public List<Seguimiento> obtenerSeguimiento() {
		return seguimientoDao.obtenerSeguimiento();
	}

	@Override
	public void EnviarCorreoAspirante(EmailNotificacionDto email) {
		seguimientoDao.EnviarCorreoAspirante(email);
	}
	
	@Override
	public void EnviarCorreoEntidad(EmailNotificacionDto email) {
		seguimientoDao.EnviarCorreoEntidad(email);
		
	}

	@Override
	public int actualizarSeguimiento(AsignacionTrivia asignacion) {
		
		return seguimientoDao.actualizarSeguimiento(asignacion);
		
	}

}
