package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.Calificacion;
import com.ciber.rowMapper.CalificacionRowMapper;

public class CalificacionSetExtractor implements ResultSetExtractor<List<Calificacion>> {

	@Override
	public List<Calificacion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Calificacion> list = new ArrayList<Calificacion>();
		while (rs.next()) {
			list.add(new CalificacionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}
}
