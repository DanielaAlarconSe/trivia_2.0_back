package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.Curso;

public class CursoRowMapper implements RowMapper<Curso>{

	@Override
	public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Curso cur = new Curso();
		cur.setCodigo(rs.getInt("cur_codigo"));
		cur.setNombre(rs.getString("cur_nombre"));
		cur.setDescripcion(rs.getString("cur_descripcion"));
		cur.setNombreInstructor(rs.getString("nombre_completo"));
		cur.setInstructor(rs.getInt("per_codigo"));
		
		return cur;
		
	}

}
