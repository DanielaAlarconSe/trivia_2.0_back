package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IPreguntaRespuestaDao;
import com.ciber.entities.PreguntaRespuesta;
import com.ciber.service.IPreguntaRespuestaService;

@Service
public class PreguntaRespuestaServiceImpl implements IPreguntaRespuestaService {
	
	@Autowired
	IPreguntaRespuestaDao dao;

	@Override
	public List<PreguntaRespuesta> obtenerPreguntaRespuestas(int codigo) {
		
		return dao.obtenerPreguntaRespuestas(codigo);
		
	}

	@Override
	public int registrarPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
		
		return dao.registrarPreguntaRespuesta(preguntaRespuesta);
		
	}

	@Override
	public int actualizarPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
		
		return dao.actualizarPreguntaRespuesta(preguntaRespuesta);
		
	}

}
