package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Persona;

public class InstructorRowMapper implements RowMapper<Persona>{

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona persona = new Persona();
		persona.setCodigo(rs.getInt("per_codigo"));
        persona.setNombre(rs.getString("per_nombre"));
        persona.setApellido(rs.getString("per_apellido"));
		return persona;
	}

}
