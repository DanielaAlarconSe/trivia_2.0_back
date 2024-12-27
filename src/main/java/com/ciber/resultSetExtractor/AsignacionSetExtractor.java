package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.dto.AsignacionDto;
import com.ciber.rowMapper.AsignacionRowMapper;

public class AsignacionSetExtractor implements ResultSetExtractor<List<AsignacionDto>> {

	@Override
	public List<AsignacionDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<AsignacionDto> list = new ArrayList<AsignacionDto>();
		while (rs.next()) {
			list.add(new AsignacionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}

}
