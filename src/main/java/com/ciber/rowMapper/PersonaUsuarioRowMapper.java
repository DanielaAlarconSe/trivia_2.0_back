package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.PersonaUsuario;

public class PersonaUsuarioRowMapper implements RowMapper<PersonaUsuario>{

	@Override
	public PersonaUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonaUsuario persona = new PersonaUsuario();
		persona.setCodigo(rs.getInt("per_codigo"));
		//persona.setIdentificacion(rs.getString("per_identificacion"));
		persona.setNombre(rs.getString("per_nombre"));
		persona.setApellido(rs.getString("per_apellido"));
		return persona;
	}

}