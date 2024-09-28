package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.RespuestaCuestionario;

public class RespuestaCuestionarioRowMapper implements RowMapper<RespuestaCuestionario>{

	@Override
	public RespuestaCuestionario mapRow(ResultSet rs, int rowNum) throws SQLException {
		RespuestaCuestionario respuestaCuestionario = new RespuestaCuestionario();
		respuestaCuestionario.setCodigo(rs.getInt("rec_codigo"));
		respuestaCuestionario.setEstudianteNombre(rs.getString("rec_estudiante_nombre"));
		respuestaCuestionario.setCuestionarioCodigo(rs.getInt("cue_codigo"));
		respuestaCuestionario.setFechaRegistro(rs.getDate("rec_fecha_registro"));
		respuestaCuestionario.setCalificacionTotal(rs.getFloat("rec_calificacion_total"));
		return respuestaCuestionario;
	}
}
