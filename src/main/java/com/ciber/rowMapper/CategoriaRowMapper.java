package com.ciber.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ciber.entities.CuestionarioCategoria;

public class CategoriaRowMapper implements RowMapper<CuestionarioCategoria> {

	@Override
	public CuestionarioCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {

		CuestionarioCategoria categoria = new CuestionarioCategoria();
		categoria.setCodigo(rs.getInt("cuc_codigo"));
		categoria.setNombre(rs.getString("cuc_nombre"));
		categoria.setDescripcion(rs.getString("cuc_descripcion"));

		return categoria;
	}

}
