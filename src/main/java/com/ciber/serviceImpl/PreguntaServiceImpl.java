package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IPreguntaDao;
import com.ciber.entities.Pregunta;
import com.ciber.entities.RespuestaTipo;
import com.ciber.service.IPreguntaService;

@Service
public class PreguntaServiceImpl implements IPreguntaService {
	
	@Autowired
	IPreguntaDao preguntaDao;

	@Override
	public List<Pregunta> obtenerPreguntasCuestionario(int codigo) {
		
		return preguntaDao.obtenerPreguntasCuestionario(codigo);
		
	}
	
	@Override
	public List<RespuestaTipo> obtenerRespuestaTipo() {
		
		return preguntaDao.obtenerRespuestaTipo();
		
	}

	@Override
	public int registrarPregunta(Pregunta pregunta) {
		
		return preguntaDao.registrarPregunta(pregunta);
		
	}

	@Override
	public int actualizarPregunta(Pregunta pregunta) {
		
		return preguntaDao.actualizarPregunta(pregunta);
		
	}

}
