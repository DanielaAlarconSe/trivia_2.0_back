package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.Entidad;
import com.ciber.rowMapper.EntidadRowMapper;

public class EntidadSetExtractor implements ResultSetExtractor<List<Entidad>> {

	@Override
	public List<Entidad> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Entidad> list = new ArrayList<Entidad>();
		while (rs.next()) {
			list.add(new EntidadRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}

}
