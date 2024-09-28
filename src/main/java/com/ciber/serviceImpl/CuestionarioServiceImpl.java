package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.ICuestionarioDao;
import com.ciber.entities.Cuestionario;
import com.ciber.service.ICuestionarioService;

@Service
public class CuestionarioServiceImpl implements ICuestionarioService{
	
	@Autowired
	ICuestionarioDao cuestionarioDao;

	@Override
	public List<Cuestionario> obtenerCuestionarios() {

		return cuestionarioDao.obtenerCuestionarios();
		
	}
	
	@Override
	public List<Cuestionario> obtenerCuestionarioCodigo(int codigo) {
		
		return cuestionarioDao.obtenerCuestionarioCodigo(codigo);
	}
	
	@Override
	public List<Cuestionario> obtenerCuestionariosCurso(int codigo) {
		
		return cuestionarioDao.obtenerCuestionariosCurso(codigo);
	}

	@Override
	public int registrarCuestionario(Cuestionario cuestionario) {

		return cuestionarioDao.registrarCuestionario(cuestionario);
		
	}

	@Override
	public int actualizarCuestionario(Cuestionario cuestionario) {

		return cuestionarioDao.actualizarCuestionario(cuestionario);
		
	}

}
