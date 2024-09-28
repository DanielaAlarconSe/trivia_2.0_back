package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.RespuestaOpcion;

public class RespuestaOpcionRowMapper implements RowMapper<RespuestaOpcion>{

	@Override
	public RespuestaOpcion mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RespuestaOpcion respuesta = new RespuestaOpcion();
		respuesta.setCodigo(rs.getInt("reo_codigo"));
		respuesta.setNombre(rs.getString("reo_nombre"));
		respuesta.setCuestionarioCodigo(rs.getInt("cue_codigo"));
		respuesta.setCuestionarioNombre(rs.getString("cue_nombre"));
		respuesta.setPuntuacion(rs.getFloat("reo_puntuacion"));
		respuesta.setEstado(rs.getInt("reo_estado"));
		return respuesta;
		
	}
}
