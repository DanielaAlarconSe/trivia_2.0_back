package com.ciber.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.dto.AsignacionDto;
import com.ciber.entities.AsignacionTrivia;
import com.ciber.service.IAsignacionService;

@RestController
@RequestMapping(path = "asignacion")
public class AsignacionRestController {

	@Autowired
	IAsignacionService asignacionService;
	
	@GetMapping(path = "obtener-aspirantes-entidad/{entidad}")
	public List<AsignacionDto> obtenerAspirantesPorEntidad(@PathVariable Integer entidad) {
		return asignacionService.obtenerAspirantesPorEntidad(entidad);
	}
	
	@GetMapping(path = "obtener-aspirante/{codigo}")
	public List<AsignacionDto> obtenerAspirante(@PathVariable Integer codigo) {
		return asignacionService.obtenerAspirante(codigo);
	}
	
	@PostMapping(path = "registrar-asignacion")
	public int registrarAsignacionTrivia(@RequestBody AsignacionTrivia asignacion) {
		return asignacionService.registrarAsignacionTrivia(asignacion);
	}

	@PutMapping(path = "actualizar-asignacion")
	public int actualizarAsignacionTrivia(@RequestBody AsignacionTrivia asignacion) {
		return asignacionService.actualizarAsignacionTrivia(asignacion);
	}

	@PutMapping(path = "eliminar-asignacion")
	public int eliminarAsignacionTrivia(@RequestBody AsignacionTrivia asignacion) {
		return asignacionService.eliminarAsignacionTrivia(asignacion);
	}
	
}
