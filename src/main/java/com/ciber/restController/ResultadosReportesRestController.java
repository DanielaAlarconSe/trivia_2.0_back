package com.ciber.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.dto.ReporteAgrupadoDto;
import com.ciber.entities.Calificacion;
import com.ciber.service.IResultadosReportesService;

@RestController
@RequestMapping(path = "resultados-reportes")
public class ResultadosReportesRestController {
	
	@Autowired
	IResultadosReportesService service;

	@GetMapping(path = "obtener-resultado-trivia/{codigo}")
	public float obtenerResultadoTrivia(@PathVariable Integer codigo) {
		return service.obtenerResultadoTrivia(codigo);
	}
	
	@GetMapping(path = "obtener-calificaciones")
	public List<Calificacion> obtenerCalificaciones() {
		return service.obtenerCalificaciones();
	}
	
	@GetMapping(path = "generar-datos-reporte-agrupado/{cuestionario}/{preguntas}")
	public List<ReporteAgrupadoDto> obtenerResultadoTrivia(@PathVariable Integer cuestionario, @PathVariable Integer[] preguntas) {
		return service.generarDatosReporteAgrupado(cuestionario, preguntas);
	}

}
