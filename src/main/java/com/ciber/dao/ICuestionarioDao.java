package com.ciber.dao;

import java.util.List;

import com.ciber.entities.Cuestionario;

public interface ICuestionarioDao {

	public List<Cuestionario> obtenerCuestionarios(Integer usuario, Integer persona);

	public List<Cuestionario> obtenerCuestionarioCodigo(int codigo);

	public List<Cuestionario> obtenerCuestionariosCurso(int codigo);

	public List<Cuestionario> obtenerCuestionariosCursoGeneral(int codigo);

	public int registrarCuestionario(Cuestionario cuestionario);

	public int actualizarCuestionario(Cuestionario cuestionario);

	public Cuestionario obtenerCuestionarioPorToken(String token);
	
	public Cuestionario obtenerCuestionarioPorTokenAspirante(String token);

	public List<Cuestionario> obtenerCuestionariosAspirantes();

}
