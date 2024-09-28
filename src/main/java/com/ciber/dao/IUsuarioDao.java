package com.ciber.dao;

import com.ciber.dto.UsuarioDto;
import com.ciber.entities.Usuario;

public interface IUsuarioDao {
	
	public Usuario buscarUsuario(String username);
	
	public boolean validarUsuario(String username);
	
	public int registrarUsuario(UsuarioDto usuario);

	int actualizarUsuario(UsuarioDto usuario);

	int eliminarUsuario(UsuarioDto usuario);
}
