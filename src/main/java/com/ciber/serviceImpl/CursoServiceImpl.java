package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.ICursoDao;
import com.ciber.entities.Curso;
import com.ciber.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	ICursoDao dao;

	@Override
	public List<Curso> obtenerCurso() {
		return dao.obtenerCursos();
	}

	@Override
	public int registrarCurso(Curso curso) {
		return dao.registrarCurso(curso);
	}

	@Override
	public int actualizarCurso(Curso curso) {
		return dao.actualizar(curso);
	}

	@Override
	public int eliminarCurso(Curso curso) {
		return dao.eliminarCurso(curso);
	}

}
