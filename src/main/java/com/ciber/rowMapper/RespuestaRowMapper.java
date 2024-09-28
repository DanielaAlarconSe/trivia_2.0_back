package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Respuesta;

public class RespuestaRowMapper implements RowMapper<Respuesta>{

	@Override
	public Respuesta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Respuesta respuesta = new Respuesta();
		respuesta.setCodigo(rs.getInt("res_codigo"));
		respuesta.setRespuestaCuestionarioCodigo(rs.getInt("rec_codigo"));
		respuesta.setPreguntaRespuestaCodigo(rs.getInt("prr_codigo"));
		respuesta.setPreguntaCodigo(rs.getInt("pre_codigo"));
		respuesta.setFechaRegistro(rs.getDate("res_fecha_registro"));
		
		return respuesta;
	}
}
