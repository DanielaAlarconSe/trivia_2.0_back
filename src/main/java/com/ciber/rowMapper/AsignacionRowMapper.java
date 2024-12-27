package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.dto.AsignacionDto;

public class AsignacionRowMapper implements RowMapper<AsignacionDto> {

	@Override
	public AsignacionDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		AsignacionDto asi = new AsignacionDto();
		asi.setUsuariocodigo(rs.getInt("usu_codigo"));
		asi.setUsuarioNombre(rs.getString("usu_nombre"));
		asi.setAsignacionCodigo(rs.getInt("ast_codigo"));
		asi.setCuestionarioCodigo(rs.getInt("cue_codigo"));
		asi.setFechaAsignacion(rs.getTimestamp("ast_fecha_asignacion"));
		asi.setFechaFinalizacion(rs.getTimestamp("ast_fecha_finalizacion"));
		asi.setEstado(rs.getInt("ast_estado"));
		asi.setSeguimientoNombre(rs.getString("seg_nombre"));

		return asi;
	}

}
