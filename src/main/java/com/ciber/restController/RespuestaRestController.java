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

import com.ciber.entities.Respuesta;
import com.ciber.entities.RespuestaCuestionario;
import com.ciber.entities.RespuestaOpcion;
import com.ciber.entities.RespuestaTipo;
import com.ciber.service.IRespuestaService;

@RestController
@RequestMapping(path = "respuesta")
public class RespuestaRestController {
	
	@Autowired
	IRespuestaService service;

	@GetMapping(path = "obtener-respuestas-cuestionario/{codigo}")
	public List<RespuestaOpcion> obtenerRespuestasCuestionario(@PathVariable Integer codigo) {
		return service.obtenerRespuestasCuestionario(codigo);
	}
	
	@GetMapping(path = "obtener-respuesta-tipo")
	public List<RespuestaTipo> obtenerRespuestaTipo() {
		return service.obtenerRespuestaTipo();
	}
	
	@GetMapping(path = "obtener-ultimo-registro")
	public int obtenerUltimoRegistro() {
		return service.obtenerUltimoRegistro();
	}

	@PostMapping(path = "registrar-respuesta")
	public int registrarRespuesta(@RequestBody RespuestaOpcion respuestaOpcion) {
		return service.registrarRespuesta(respuestaOpcion);
	}

	@PutMapping(path = "actualizar-respuesta")
	public int actualizarRespuesta(@RequestBody RespuestaOpcion respuestaOpcion) {
		return service.actualizarRespuesta(respuestaOpcion);
	}
	
	@PostMapping(path = "registrar-respuesta-cuestionario")
	public int registrarRespuestaCuestionario(@RequestBody RespuestaCuestionario respuestaCuestionario) {
		return service.registrarRespuestaCuestionario(respuestaCuestionario);
	}
	
	@PostMapping(path = "registrar-respuesta-trivia")
	public int registrarRespuestaTrivia(@RequestBody Respuesta respuesta) {
		return service.registrarRespuestaTrivia(respuesta);
	}
	
	@PostMapping(path = "actualizar-calificacion")
	public int actualizarCalificacion(@RequestBody RespuestaCuestionario respuestaCuestionario) {
		return service.actualizarCalificacion(respuestaCuestionario);
	}
	

}
