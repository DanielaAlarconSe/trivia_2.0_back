package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.RespuestaTipo;

public class RespuestaTipoRowMapper implements RowMapper<RespuestaTipo>{

	@Override
	public RespuestaTipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		RespuestaTipo respuestaTipo = new RespuestaTipo();
		respuestaTipo.setCodigo(rs.getInt("ret_codigo"));
		respuestaTipo.setNombre(rs.getString("ret_nombre"));
		respuestaTipo.setEstado(rs.getInt("ret_estado"));
		return respuestaTipo;
	}
}
