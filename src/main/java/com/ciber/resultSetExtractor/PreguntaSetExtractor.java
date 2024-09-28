package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.Pregunta;
import com.ciber.rowMapper.PreguntaRowMapper;

public class PreguntaSetExtractor implements ResultSetExtractor<List<Pregunta>>{

	@Override
	public List<Pregunta> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Pregunta> list = new ArrayList<Pregunta>();
		while (rs.next()) {
			list.add(new PreguntaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
