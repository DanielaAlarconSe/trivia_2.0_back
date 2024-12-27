package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Entidad;

public class EntidadRowMapper implements RowMapper<Entidad>{

	@Override
	public Entidad mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Entidad ent = new Entidad();
		ent.setCodigo(rs.getInt("ent_codigo"));
		ent.setNombre(rs.getString("ent_nombre"));
		ent.setDireccion(rs.getString("ent_direccion"));
		ent.setTelefono(rs.getString("ent_telefono"));
		ent.setEmail(rs.getString("ent_email"));
		ent.setFechaRegistro(rs.getTimestamp("ent_fecha_registro"));
		ent.setEstado(rs.getInt("ent_estado"));
		
		return ent;
	}

}
