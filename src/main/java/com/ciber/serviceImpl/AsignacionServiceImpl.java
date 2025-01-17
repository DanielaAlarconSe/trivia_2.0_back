package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IAsignacionDao;
import com.ciber.dto.AsignacionDto;
import com.ciber.entities.AsignacionTrivia;
import com.ciber.service.IAsignacionService;

@Service
public class AsignacionServiceImpl implements IAsignacionService {

	@Autowired
	IAsignacionDao asignacionDao;

	@Override
	public List<AsignacionDto> obtenerAspirantesPorEntidad(Integer entidad) {
		return asignacionDao.obtenerAspirantesPorEntidad(entidad);
	}
	
	@Override
	public List<AsignacionDto> obtenerAspirante(Integer codigo) {
		return asignacionDao.obtenerAspirante(codigo);
	}

	@Override
	public int registrarAsignacionTrivia(AsignacionTrivia asignacion) {
		return asignacionDao.registrarAsignacionTrivia(asignacion);
	}

	@Override
	public int actualizarAsignacionTrivia(AsignacionTrivia asignacion) {
		return asignacionDao.actualizarAsignacionTrivia(asignacion);
	}

	@Override
	public int eliminarAsignacionTrivia(AsignacionTrivia asignacion) {
		return asignacionDao.eliminarAsignacionTrivia(asignacion);
	}

}
