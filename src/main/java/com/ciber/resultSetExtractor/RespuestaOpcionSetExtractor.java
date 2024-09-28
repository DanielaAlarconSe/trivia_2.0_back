package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.RespuestaOpcion;
import com.ciber.rowMapper.RespuestaOpcionRowMapper;

public class RespuestaOpcionSetExtractor implements ResultSetExtractor<List<RespuestaOpcion>>{

	@Override
	public List<RespuestaOpcion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<RespuestaOpcion> list = new ArrayList<RespuestaOpcion>();
		while (rs.next()) {
			list.add(new RespuestaOpcionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
