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

import com.ciber.entities.PreguntaRespuesta;
import com.ciber.service.IPreguntaRespuestaService;

@RestController
@RequestMapping(path = "pregunta-respuesta")
public class PreguntaRespuestaRestController {
	
	@Autowired
	IPreguntaRespuestaService service;

	@GetMapping(path = "obtener-pregunta-respuestas/{codigo}")
	public List<PreguntaRespuesta> obtenerPreguntaRespuestas(@PathVariable Integer codigo) {
		return service.obtenerPreguntaRespuestas(codigo);
	}

	@PostMapping(path = "registrar-pregunta-respuesta")
	public int registrarPreguntaRespuesta(@RequestBody PreguntaRespuesta preguntaRespuesta) {
		return service.registrarPreguntaRespuesta(preguntaRespuesta);
	}

	@PutMapping(path = "actualizar-pregunta-respuesta")
	public int actualizarPreguntaRespuesta(@RequestBody PreguntaRespuesta preguntaRespuesta) {
		return service.actualizarPreguntaRespuesta(preguntaRespuesta);
	}

}
