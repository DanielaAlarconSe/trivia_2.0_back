package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.UsuarioTipo;

public class UsuarioTipoRowMapper implements RowMapper<UsuarioTipo>{

	@Override
	public UsuarioTipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuarioTipo usuarioTipo = new UsuarioTipo();
		usuarioTipo.setCodigo(rs.getInt("ust_codigo"));
		usuarioTipo.setNombre(rs.getString("ust_nombre"));
		usuarioTipo.setEstado(rs.getInt("ust_estado"));
		return usuarioTipo;
		
	}
	
}
