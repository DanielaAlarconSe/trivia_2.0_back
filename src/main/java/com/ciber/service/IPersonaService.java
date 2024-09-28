package com.ciber.service;

import java.util.List;

import com.ciber.dto.PersonaDto;
import com.ciber.entities.Persona;

public interface IPersonaService {

	public List<Persona> obtenerPersonas();

	public List<Persona> obtenerPersonaCodigo(Integer id);

	public int registrar(Persona persona);

	int actualizar(Persona persona);

	public List<PersonaDto> obtenerPersonasUsuario();
	
	public List<Persona> obtenerInstructores();
}
