package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.dto.PersonaDto;

public class PersonaDtoRowMapper implements RowMapper<PersonaDto>{

	@Override
	public PersonaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonaDto persona = new PersonaDto();
		persona.setCodigo(rs.getInt("per_codigo"));
        persona.setNombre(rs.getString("per_nombre"));
        persona.setApellido(rs.getString("per_apellido"));
        persona.setCorreo(rs.getString("per_email"));
        persona.setUsuario(rs.getInt("usuario"));
        persona.setTipoUsuarioCodigo(rs.getInt("ust_codigo"));
        persona.setTipoUsuarioNombre(rs.getString("ust_nombre"));
        persona.setPw(rs.getString("uwd2"));
		return persona;
	}

}
