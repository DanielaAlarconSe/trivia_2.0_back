package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.ICuestionarioCategoriaDao;
import com.ciber.entities.CuestionarioCategoria;
import com.ciber.service.ICuestionarioCategoriaService;

@Service
public class CuestionarioCategoriaServiceImpl implements ICuestionarioCategoriaService {

	@Autowired
	ICuestionarioCategoriaDao categoriaDao;

	@Override
	public List<CuestionarioCategoria> obtenerCategorias(Integer usuarioTipo) {
		return categoriaDao.obtenerCategorias(usuarioTipo);
	}

}
