package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.CuestionarioCategoria;
import com.ciber.rowMapper.CategoriaRowMapper;

public class CategoriaSetExtractor implements ResultSetExtractor<List<CuestionarioCategoria>> {

	@Override
	public List<CuestionarioCategoria> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CuestionarioCategoria> list = new ArrayList<CuestionarioCategoria>();
		while (rs.next()) {
			list.add(new CategoriaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}

}
