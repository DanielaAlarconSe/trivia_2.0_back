package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.ICuestionarioDao;
import com.ciber.entities.Cuestionario;
import com.ciber.service.ICuestionarioService;

@Service
public class CuestionarioServiceImpl implements ICuestionarioService {

	@Autowired
	ICuestionarioDao cuestionarioDao;

	@Override
	public List<Cuestionario> obtenerCuestionarios(Integer usuario, Integer persona) {

		return cuestionarioDao.obtenerCuestionarios(usuario, persona);

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
	public List<Cuestionario> obtenerCuestionariosCursoGeneral(int codigo) {
		
		return cuestionarioDao.obtenerCuestionariosCursoGeneral(codigo);
		
	}

	@Override
	public int registrarCuestionario(Cuestionario cuestionario) {

		return cuestionarioDao.registrarCuestionario(cuestionario);

	}

	@Override
	public int actualizarCuestionario(Cuestionario cuestionario) {

		return cuestionarioDao.actualizarCuestionario(cuestionario);

	}

	@Override
	public Cuestionario obtenerCuestionarioPorToken(String token) {

		Cuestionario cuestionario = cuestionarioDao.obtenerCuestionarioPorToken(token);

		if (cuestionario == null) {
			throw new RuntimeException("El token no es válido o no coincide con ningún cuestionario.");
		}

		return cuestionario;
	}

	@Override
	public List<Cuestionario> obtenerCuestionariosAspirantes() {
		return cuestionarioDao.obtenerCuestionariosAspirantes();
	}

	@Override
	public Cuestionario obtenerCuestionarioPorTokenAspirante(String token) {
		
		return cuestionarioDao.obtenerCuestionarioPorTokenAspirante(token);
		
	}

}
