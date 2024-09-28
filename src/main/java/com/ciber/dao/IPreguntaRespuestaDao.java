package com.ciber.dao;

import java.util.List;

import com.ciber.entities.PreguntaRespuesta;

public interface IPreguntaRespuestaDao {
	
	public List<PreguntaRespuesta> obtenerPreguntaRespuestas(int codigo);

	public int registrarPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta);

	public int actualizarPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta);

}
