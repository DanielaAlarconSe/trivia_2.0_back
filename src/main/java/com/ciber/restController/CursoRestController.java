package com.ciber.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.entities.Curso;
import com.ciber.service.ICursoService;

@RestController
@RequestMapping(path = "curso")
public class CursoRestController {

	@Autowired
	ICursoService service;

	@GetMapping(path = "obtener-cursos")
	public List<Curso> obtenerCurso() {
		return service.obtenerCurso();
	}

	@PostMapping(path = "registrar-curso")
	public int registrarCurso(@RequestBody Curso curso) {
		return service.registrarCurso(curso);
	}

	@PutMapping(path = "actualizar-curso")
	public int actualizarCurso(@RequestBody Curso curso) {
		return service.actualizarCurso(curso);
	}
	
	@PutMapping(path = "eliminar-curso")
	public int eliminarCurso(@RequestBody Curso curso) {
		return service.eliminarCurso(curso);
	}
}
