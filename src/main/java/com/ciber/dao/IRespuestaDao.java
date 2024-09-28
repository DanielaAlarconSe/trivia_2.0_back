package com.ciber.dao;

import java.util.List;

import com.ciber.entities.Respuesta;
import com.ciber.entities.RespuestaCuestionario;
import com.ciber.entities.RespuestaOpcion;
import com.ciber.entities.RespuestaTipo;

public interface IRespuestaDao {
	
	public List<RespuestaOpcion> obtenerRespuestasCuestionario(int codigo);
	
	public List<RespuestaTipo> obtenerRespuestaTipo();
	
	public int obtenerUltimoRegistro();

	public int registrarRespuesta(RespuestaOpcion respuestaOpcion);

	public int actualizarRespuesta(RespuestaOpcion respuestaOpcion);
	
	public int registrarRespuestaCuestionario(RespuestaCuestionario respuestaCuestionario);
	
	public int registrarRespuestaTrivia(Respuesta respuesta);
	
	public int actualizarCalificacion(RespuestaCuestionario respuestaCuestionario);

}
