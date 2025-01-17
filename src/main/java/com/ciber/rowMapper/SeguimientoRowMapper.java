package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Seguimiento;

public class SeguimientoRowMapper implements RowMapper<Seguimiento>{

	@Override
	public Seguimiento mapRow(ResultSet rs, int rowNum) throws SQLException {

		Seguimiento seg = new Seguimiento();
		seg.setCodigo(rs.getInt("seg_codigo"));
		seg.setNombre(rs.getString("seg_nombre"));
		seg.setEstado(rs.getInt("seg_estado"));
		
		return seg;
	}

}
