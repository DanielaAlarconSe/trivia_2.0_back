package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Pregunta;

public class PreguntaRowMapper implements RowMapper<Pregunta>{

	@Override
	public Pregunta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pregunta pregunta = new Pregunta();
		pregunta.setCodigo(rs.getInt("pre_codigo"));
		pregunta.setNombre(rs.getString("pre_nombre"));
		pregunta.setCuestionarioCodigo(rs.getInt("cue_codigo"));
		pregunta.setCuestionarioNombre(rs.getString("cue_nombre"));
        pregunta.setTipoRespuestaCodigo(rs.getInt("ret_codigo"));
        pregunta.setTipoRespuestaNombre(rs.getString("ret_nombre"));
        pregunta.setTextoAdicional(rs.getString("pre_texto_adicional"));
        pregunta.setEstado(rs.getInt("pre_estado"));
		return pregunta;
	}
}
