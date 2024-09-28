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

import com.ciber.entities.Pregunta;
import com.ciber.entities.RespuestaTipo;
import com.ciber.service.IPreguntaService;

@RestController
@RequestMapping(path = "pregunta")
public class PreguntaRestController {
	
	@Autowired
	IPreguntaService service;

	@GetMapping(path = "obtener-preguntas-cuestionario/{codigo}")
	public List<Pregunta> obtenerPreguntasCuestionario(@PathVariable Integer codigo) {
		return service.obtenerPreguntasCuestionario(codigo);
	}
	
	@GetMapping(path = "obtener-respuesta-tipo")
	public List<RespuestaTipo> obtenerRespuestaTipo() {
		return service.obtenerRespuestaTipo();
	}

	@PostMapping(path = "registrar-pregunta")
	public int registrarPregunta(@RequestBody Pregunta pregunta) {
		return service.registrarPregunta(pregunta);
	}

	@PutMapping(path = "actualizar-pregunta")
	public int actualizarPregunta(@RequestBody Pregunta pregunta) {
		return service.actualizarPregunta(pregunta);
	}

}
