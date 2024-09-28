package com.ciber.dao;

import java.util.List;

import com.ciber.entities.Cuestionario;

public interface ICuestionarioDao {
	
	public List<Cuestionario> obtenerCuestionarios();
	
	public List<Cuestionario> obtenerCuestionarioCodigo(int codigo);
	
	public List<Cuestionario> obtenerCuestionariosCurso(int codigo);

	public int registrarCuestionario(Cuestionario cuestionario);

	public int actualizarCuestionario(Cuestionario cuestionario);

}
