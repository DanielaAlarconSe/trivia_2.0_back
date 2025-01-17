package com.ciber.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.entities.Entidad;
import com.ciber.service.IEntidadService;

@RestController
@RequestMapping(path = "entidad")
public class EntidadRestController {

	@Autowired
	IEntidadService entidadService;

	@PostMapping(path = "registrar-entidad")
	public int registrarEntidad(@RequestBody Entidad entidad) {
		return entidadService.registrarEntidad(entidad);
	}

	@PutMapping(path = "actualizar-entidad")
	public int actualizarEntidad(@RequestBody Entidad entidad) {
		return entidadService.actualizarEntidad(entidad);
	}

	@PutMapping(path = "eliminar-entidad")
	public int eliminarEntidad(@RequestBody Entidad entidad) {
		return entidadService.eliminarEntidad(entidad);
	}
	
	@GetMapping(path = "obtener-entidad")
	public List<Entidad> obtenerEntidad() {
		return entidadService.obtenerEntidad();
	}
}
