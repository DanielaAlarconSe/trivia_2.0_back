package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.dto.AsignacionDto;

public class AsignacionRowMapper implements RowMapper<AsignacionDto> {

	@Override
	public AsignacionDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		AsignacionDto asi = new AsignacionDto();
		asi.setUsuarioCodigo(rs.getInt("usu_codigo"));
		asi.setPersonaCodigo(rs.getInt("per_codigo"));
		asi.setPersonaNombre(rs.getString("per_nombre"));
		asi.setPersonaApellido(rs.getString("per_apellido"));
		asi.setPersonaEmail(rs.getString("per_email"));
		//asi.setPersonaToken(rs.getString("usu_token"));
		asi.setEntidadCodigo(rs.getInt("ent_codigo"));
		asi.setEntidadNombre(rs.getString("ent_nombre"));
		asi.setEntidadEmail(rs.getString("ent_email"));
		asi.setAsignacionCodigo(rs.getInt("ast_codigo"));
		asi.setCuestionarioCodigo(rs.getInt("cue_codigo"));
		asi.setCuestionarioNombre(rs.getString("cue_nombre"));
		asi.setCuestionarioFechaInicio(rs.getTimestamp("cue_fecha_inicio"));
		asi.setCuestionarioFechaFin(rs.getTimestamp("cue_fecha_fin"));
		asi.setFechaAsignacion(rs.getTimestamp("ast_fecha_asignacion"));
		asi.setFechaFinalizacion(rs.getTimestamp("ast_fecha_finalizacion"));
		asi.setSeguimientoCodigo(rs.getInt("seg_codigo"));
		asi.setSeguimientoNombre(rs.getString("seg_nombre"));
		asi.setEstado(rs.getInt("ast_estado"));

		return asi;
	}

}
