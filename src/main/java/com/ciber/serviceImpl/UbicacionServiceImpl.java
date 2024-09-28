package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IUbicacionDao;
import com.ciber.entities.Pais;
import com.ciber.service.IUbicacionService;

@Service
public class UbicacionServiceImpl implements IUbicacionService {

	@Autowired
	private IUbicacionDao ubicacionDao;

	@Override
	public List<Pais> obtenerPaisLocal() {

		return ubicacionDao.obtenerPaisLocal();

	}

	@Override
	public List<Pais> obtenerPaises() {

		return ubicacionDao.obtenerPaises();

	}

}
