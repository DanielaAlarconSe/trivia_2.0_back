package com.ciber.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.dto.PersonaDto;
import com.ciber.entities.Persona;
import com.ciber.service.IPersonaService;

@RestController
@RequestMapping(path = "persona")
public class PersonaRestController {

	@Autowired
	IPersonaService personaService;

	@GetMapping(path = "obtener-personas")
	public List<Persona> obtenerPersonas() {

		return personaService.obtenerPersonas();

	}

	@GetMapping(path = "obtener-persona-codigo/{id}")
	public List<Persona> obtenerPersonaIdentificacion(@PathVariable Integer id) {

		return personaService.obtenerPersonaCodigo(id);

	}

	@PostMapping(path = "registrar-persona")
	public int registrar(@RequestBody Persona persona) {
		System.out.println(persona);
		return personaService.registrar(persona);

	}

	@PutMapping(path = "actualizar-persona")
	public int actualizar(@RequestBody Persona persona) {

		return personaService.actualizar(persona);

	}
	
	@GetMapping(path = "obtener-personas-usuario")
	public List<PersonaDto> obtenerPersonasUsuario() {

		return personaService.obtenerPersonasUsuario();

	}
	
	@GetMapping(path = "obtener-instructores")
	public List<Persona> obtenerInstructores() {

		return personaService.obtenerInstructores();

	}

}
