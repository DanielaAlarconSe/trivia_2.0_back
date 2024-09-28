package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Persona;

public class PersonaRowMapper implements RowMapper<Persona>{

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona persona = new Persona();
		persona.setCodigo(rs.getInt("per_codigo"));
        persona.setNombre(rs.getString("per_nombre"));
        persona.setApellido(rs.getString("per_apellido"));
        persona.setPaisResidencia(rs.getInt("per_pais_residencia"));
        persona.setCorreo(rs.getString("per_email"));
        persona.setEstado(rs.getInt("per_estado"));
        persona.setFechaRegistro(rs.getDate("per_fecha_registro"));
        persona.setNombrePaisResidencia(rs.getString("pai_nombre"));
		return persona;
	}

}