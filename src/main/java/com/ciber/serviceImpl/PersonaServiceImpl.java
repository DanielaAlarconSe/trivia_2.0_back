package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IPersonaDao;
import com.ciber.dto.PersonaDto;
import com.ciber.entities.Persona;
import com.ciber.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;

	@Override
	public List<Persona> obtenerPersonas() {

		return personaDao.obtenerPersonas();

	}

	@Override
	public int registrar(Persona persona) {

		return personaDao.registrar(persona);

	}

	@Override
	public int actualizar(Persona persona) {

		return personaDao.actualizar(persona);

	}

	@Override
	public List<Persona> obtenerPersonaCodigo(Integer id) {
		return personaDao.obtenerPersonaCodigo(id);
	}

	@Override
	public List<PersonaDto> obtenerPersonasUsuario() {
		return personaDao.obtenerPersonasUsuario();
	}

	@Override
	public List<Persona> obtenerInstructores() {
		return personaDao.obtenerInstructores();
	}

}
