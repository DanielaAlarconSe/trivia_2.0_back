package com.ciber.service;

import java.util.List;

import com.ciber.entities.Curso;

public interface ICursoService {

	public List<Curso> obtenerCurso();

	public int registrarCurso(Curso curso);

	int actualizarCurso(Curso curso);
	
	int eliminarCurso(Curso curso);
}
