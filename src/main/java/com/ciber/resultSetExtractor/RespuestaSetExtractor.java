package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.Respuesta;
import com.ciber.rowMapper.RespuestaRowMapper;

public class RespuestaSetExtractor implements ResultSetExtractor<List<Respuesta>>{

	@Override
	public List<Respuesta> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Respuesta> list = new ArrayList<Respuesta>();
		while (rs.next()) {
			list.add(new RespuestaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
