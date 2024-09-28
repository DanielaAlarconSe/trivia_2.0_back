package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Cuestionario;

public class CuestionarioRowMapper implements RowMapper<Cuestionario>{
	
	@Override
	public Cuestionario mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cuestionario cuestionario = new Cuestionario();
		cuestionario.setCodigo(rs.getInt("cue_codigo"));
		cuestionario.setNombre(rs.getString("cue_nombre"));
		cuestionario.setInstrucciones(rs.getString("cue_instrucciones"));
		cuestionario.setCursoCodigo(rs.getInt("cur_codigo"));
		cuestionario.setCursoNombre(rs.getString("cur_nombre"));
		cuestionario.setFechaInicio(rs.getTimestamp("cue_fecha_inicio"));
		cuestionario.setFechaFin(rs.getTimestamp("cue_fecha_fin"));
		cuestionario.setEstado(rs.getInt("cue_estado"));
		
		return cuestionario;
		
	}

}
