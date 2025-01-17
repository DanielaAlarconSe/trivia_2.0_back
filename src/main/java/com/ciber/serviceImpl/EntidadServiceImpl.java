package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IEntidadDao;
import com.ciber.entities.Entidad;
import com.ciber.service.IEntidadService;

@Service
public class EntidadServiceImpl implements IEntidadService{

	@Autowired
	IEntidadDao entidadDao;
	
	@Override
	public int registrarEntidad(Entidad entidad) {
		return entidadDao.registrarEntidad(entidad);
	}

	@Override
	public int actualizarEntidad(Entidad entidad) {
		return entidadDao.actualizarEntidad(entidad);
	}

	@Override
	public int eliminarEntidad(Entidad entidad) {
		return entidadDao.eliminarEntidad(entidad);
	}

	@Override
	public List<Entidad> obtenerEntidad() {
		return entidadDao.obtenerEntidad();
	}

}
