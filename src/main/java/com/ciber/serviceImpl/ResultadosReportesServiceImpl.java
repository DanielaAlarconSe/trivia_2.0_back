package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IResultadosReportesDao;
import com.ciber.dto.EmailNotificacionDto;
import com.ciber.dto.ReporteAgrupadoDto;
import com.ciber.entities.Calificacion;
import com.ciber.service.IResultadosReportesService;

@Service
public class ResultadosReportesServiceImpl implements IResultadosReportesService{
	
	@Autowired
	IResultadosReportesDao dao;

	@Override
	public float obtenerResultadoTrivia(Integer codigo) {
		
		return dao.obtenerResultadoTrivia(codigo);
		
	}
	
	@Override
	public List<Calificacion> obtenerCalificacionesTrivia(Integer codigo) {
		
		return dao.obtenerCalificacionesTrivia(codigo);
		
	}
	
	@Override
	public List<Calificacion> obtenerCalificacionesToken(String token) {
		
		return dao.obtenerCalificacionesToken(token);
		
	}

	@Override
	public List<Calificacion> obtenerCalificaciones() {

		return dao.obtenerCalificaciones();
		
	}

	@Override
	public List<ReporteAgrupadoDto> generarDatosReporteAgrupado(Integer cuestionario, Integer[] preguntas) {
		
		return dao.generarDatosReporteAgrupado(cuestionario, preguntas);
		
	}

	@Override
	public void EnviarCorreoEntidad(EmailNotificacionDto email) {
		dao.EnviarCorreoEntidad(email);
		
	}

}
