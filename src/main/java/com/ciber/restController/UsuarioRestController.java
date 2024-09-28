package com.ciber.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.dto.UsuarioDto;
import com.ciber.service.IUsuarioService;

@RestController
@RequestMapping(path = "usuario")
public class UsuarioRestController {

	@Autowired
	IUsuarioService service;

	@PostMapping(path = "registrar-usuario")
	public int registrarUsuario(@RequestBody UsuarioDto usuario) {
		return service.registrarUsuario(usuario);
	}
	
	@PutMapping(path = "actualizar-usuario")
	public int actualizarUsuario(@RequestBody UsuarioDto usuario) {
		return service.actualizarUsuario(usuario);
	}
	
	@PutMapping(path = "eliminar-usuario")
	public int eliminarUsuario(@RequestBody UsuarioDto usuario) {
		return service.eliminarUsuario(usuario);
	}
}
