package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Calificacion;

public class CalificacionRowMapper implements RowMapper<Calificacion>{

	@Override
	public Calificacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Calificacion calificacion = new Calificacion();
		calificacion.setCodigo(rs.getInt("rec_codigo"));
		calificacion.setEstudianteNombre(rs.getString("rec_estudiante_nombre"));
		calificacion.setCursoCodigo(rs.getInt("cur_codigo"));
		calificacion.setCursoNombre(rs.getString("cur_nombre"));
		calificacion.setCuestionarioCodigo(rs.getInt("cue_codigo"));
		calificacion.setCuestionarioNombre(rs.getString("cue_nombre"));
		calificacion.setCalificacion(rs.getFloat("rec_calificacion_total"));
		calificacion.setFechaRegistro(rs.getTimestamp("rec_fecha_registro"));
		
		return calificacion;
		
	}
}
