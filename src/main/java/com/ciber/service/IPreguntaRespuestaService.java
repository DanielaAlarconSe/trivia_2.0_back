package com.ciber.service;

import java.util.List;

import com.ciber.entities.PreguntaRespuesta;

public interface IPreguntaRespuestaService {
	
	public List<PreguntaRespuesta> obtenerPreguntaRespuestas(int codigo);

	public int registrarPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta);

	public int actualizarPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta);

}
