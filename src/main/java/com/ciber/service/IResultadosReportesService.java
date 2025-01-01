package com.ciber.service;

import java.util.List;

import com.ciber.dto.ReporteAgrupadoDto;
import com.ciber.entities.Calificacion;

public interface IResultadosReportesService {
	
	public float obtenerResultadoTrivia(Integer codigo);
	
	public List<Calificacion> obtenerCalificaciones();
	
	public List<Calificacion> obtenerCalificacionesTrivia(Integer codigo);
	
	public List<Calificacion> obtenerCalificacionesToken(String token);
	
	List<ReporteAgrupadoDto> generarDatosReporteAgrupado(Integer cuestionario, Integer[] preguntas);

}
