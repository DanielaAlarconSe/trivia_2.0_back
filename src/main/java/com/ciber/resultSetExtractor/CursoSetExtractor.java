package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.Curso;
import com.ciber.rowMapper.CursoRowMapper;

public class CursoSetExtractor implements ResultSetExtractor<List<Curso>> {

	@Override
	public List<Curso> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Curso> list = new ArrayList<Curso>();
		while (rs.next()) {
			list.add(new CursoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}

}
