package com.ciber.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.entities.UsuarioTipo;
import com.ciber.service.IUsuarioTipoService;

@RestController
@RequestMapping(path = "usuario-tipo")
public class UsuarioTipoRestController {

	@Autowired
	IUsuarioTipoService service;

	@GetMapping(path = "obtener-tipos")
	public List<UsuarioTipo> obtenerPersonas() {

		return service.obtenerTipoUsuario();

	}
}
