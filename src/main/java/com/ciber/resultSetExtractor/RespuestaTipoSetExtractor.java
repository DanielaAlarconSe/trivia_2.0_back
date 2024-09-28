package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.RespuestaTipo;
import com.ciber.rowMapper.RespuestaTipoRowMapper;

public class RespuestaTipoSetExtractor implements ResultSetExtractor<List<RespuestaTipo>>{

	@Override
	public List<RespuestaTipo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<RespuestaTipo> list = new ArrayList<RespuestaTipo>();
		while (rs.next()) {
			list.add(new RespuestaTipoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
