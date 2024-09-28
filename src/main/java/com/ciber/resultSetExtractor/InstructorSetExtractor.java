package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.Persona;
import com.ciber.rowMapper.InstructorRowMapper;

public class InstructorSetExtractor implements ResultSetExtractor<List<Persona>>{

	@Override
	public List<Persona> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Persona> list = new ArrayList<Persona>();
		while (rs.next()) {
			list.add(new InstructorRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}
