package com.ciber.service;

import java.util.List;

import com.ciber.entities.Pregunta;
import com.ciber.entities.RespuestaTipo;

public interface IPreguntaService {
	
	public List<Pregunta> obtenerPreguntasCuestionario(int codigo);
	
	public List<RespuestaTipo> obtenerRespuestaTipo();

	public int registrarPregunta(Pregunta pregunta);

	public int actualizarPregunta(Pregunta pregunta);

}
