package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IRespuestaDao;
import com.ciber.entities.Respuesta;
import com.ciber.entities.RespuestaCuestionario;
import com.ciber.entities.RespuestaOpcion;
import com.ciber.entities.RespuestaTipo;
import com.ciber.service.IRespuestaService;

@Service
public class RespuestaServiceImpl implements IRespuestaService{
	
	@Autowired
	IRespuestaDao respuestaDao;

	@Override
	public List<RespuestaOpcion> obtenerRespuestasCuestionario(int codigo) {
		
		return respuestaDao.obtenerRespuestasCuestionario(codigo);
		
	}

	@Override
	public List<RespuestaTipo> obtenerRespuestaTipo() {
		
		return respuestaDao.obtenerRespuestaTipo();
		
	}
	
	@Override
	public int obtenerUltimoRegistro() {
		
		return respuestaDao.obtenerUltimoRegistro();
		
	}

	@Override
	public int registrarRespuesta(RespuestaOpcion respuestaOpcion) {
		
		return respuestaDao.registrarRespuesta(respuestaOpcion);
		
	}

	@Override
	public int actualizarRespuesta(RespuestaOpcion respuestaOpcion) {
		
		return respuestaDao.actualizarRespuesta(respuestaOpcion);
		
	}

	@Override
	public int registrarRespuestaCuestionario(RespuestaCuestionario respuestaCuestionario) {
		
		return respuestaDao.registrarRespuestaCuestionario(respuestaCuestionario);
		
	}

	@Override
	public int registrarRespuestaTrivia(Respuesta respuesta) {
		
		return respuestaDao.registrarRespuestaTrivia(respuesta);
		
	}

	@Override
	public int actualizarCalificacion(RespuestaCuestionario respuestaCuestionario) {
		
		return respuestaDao.actualizarCalificacion(respuestaCuestionario);
		
	}

}
