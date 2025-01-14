package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Usuario;


public class UsuarioRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario user = new Usuario();
		user.setCodigo(rs.getInt("usu_codigo"));
		user.setHora(rs.getTimestamp("hora"));
		user.setPassword(rs.getString("uwd2"));
		user.setTipoUsurioCodigo(rs.getInt("ust_codigo"));
		user.setTipoUsurioNombre(rs.getString("ust_nombre"));
		user.setUsername(rs.getString("usu_nombre"));
		user.setPersona(new PersonaUsuarioRowMapper().mapRow(rs, rowNum));
		user.setEntidadCodigo(rs.getInt("ent_codigo"));
		user.setEntidadNombre(rs.getString("ent_nombre"));
		user.setToken(rs.getString("cue_token"));
		user.setState(rs.getInt("usu_estado") > 0 ? true : false);
		return user;
	}

}

