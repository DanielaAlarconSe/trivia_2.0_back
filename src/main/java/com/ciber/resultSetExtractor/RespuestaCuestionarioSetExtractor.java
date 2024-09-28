package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.RespuestaCuestionario;
import com.ciber.rowMapper.RespuestaCuestionarioRowMapper;

public class RespuestaCuestionarioSetExtractor implements ResultSetExtractor<List<RespuestaCuestionario>>{

	@Override
	public List<RespuestaCuestionario> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<RespuestaCuestionario> list = new ArrayList<RespuestaCuestionario>();
		while (rs.next()) {
			list.add(new RespuestaCuestionarioRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
