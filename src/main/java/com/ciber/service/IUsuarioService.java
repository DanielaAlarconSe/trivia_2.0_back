package com.ciber.service;

import com.ciber.dto.UsuarioDto;
import com.ciber.entities.Usuario;

public interface IUsuarioService {
	
	public Usuario buscarUsuario(String username);

	public int registrarUsuario(UsuarioDto usuario);
	
	public int actualizarUsuario(UsuarioDto usuario);
	
	public int eliminarUsuario(UsuarioDto usuario);
}
