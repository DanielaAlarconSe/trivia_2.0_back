package com.ciber.restController;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.entities.Cuestionario;
import com.ciber.service.ICuestionarioService;

@RestController
@RequestMapping(path = "cuestionario")
public class CuestionarioRestController {

	@Autowired
	ICuestionarioService service;

	@GetMapping(path = "obtener-cuestionarios")
	public List<Cuestionario> obtenerCuestionarios() {
		return service.obtenerCuestionarios();
	}

	@GetMapping(path = "obtener-cuestionario/{codigo}")
	public List<Cuestionario> obtenerCuestionarioCodigo(@PathVariable Integer codigo) {
		return service.obtenerCuestionarioCodigo(codigo);
	}

	@GetMapping(path = "obtener-cuestionarios-curso/{codigo}")
	public List<Cuestionario> obtenerCuestionariosCurso(@PathVariable Integer codigo) {
		return service.obtenerCuestionariosCurso(codigo);
	}
	
	@GetMapping(path = "obtener-cuestionarios-curso-general/{codigo}")
	public List<Cuestionario> obtenerCuestionariosCursoGeneral(@PathVariable Integer codigo) {
		return service.obtenerCuestionariosCursoGeneral(codigo);
	}

	@PostMapping(path = "registrar-cuestionario")
	public int registrarCuestionario(@RequestBody Cuestionario cuestionario) {
		return service.registrarCuestionario(cuestionario);
	}

	@PutMapping(path = "actualizar-cuestionario")
	public int actualizarCuestionario(@RequestBody Cuestionario cuestionario) {
		return service.actualizarCuestionario(cuestionario);
	}

	@GetMapping(path = "obtener-cuestionario-token/{token}")
	public ResponseEntity<?> obtenerTriviaPorToken(@PathVariable String token) {
	    try {
	        Cuestionario cuestionario = service.obtenerCuestionarioPorToken(token);
	        return ResponseEntity.ok(cuestionario);
	    } catch (EntityNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un cuestionario con el token proporcionado");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al procesar la solicitud");
	    }
	}

}
