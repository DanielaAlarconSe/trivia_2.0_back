package com.ciber.service;

import java.util.List;

import com.ciber.entities.Cuestionario;

public interface ICuestionarioService {
	
	public List<Cuestionario> obtenerCuestionarios();
	
	public List<Cuestionario> obtenerCuestionarioCodigo(int codigo);
	
	public List<Cuestionario> obtenerCuestionariosCurso(int codigo);

	public int registrarCuestionario(Cuestionario cuestionario);

	public int actualizarCuestionario(Cuestionario cuestionario);

}
