package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.Cuestionario;
import com.ciber.rowMapper.CuestionarioRowMapper;

public class CuestionarioSetExtractor implements ResultSetExtractor<List<Cuestionario>> {

	@Override
	public List<Cuestionario> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Cuestionario> list = new ArrayList<Cuestionario>();
		while (rs.next()) {
			list.add(new CuestionarioRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}
}
