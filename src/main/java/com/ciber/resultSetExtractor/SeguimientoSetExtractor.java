package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.Seguimiento;
import com.ciber.rowMapper.SeguimientoRowMapper;

public class SeguimientoSetExtractor implements ResultSetExtractor<List<Seguimiento>>{

	@Override
	public List<Seguimiento> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Seguimiento> list = new ArrayList<Seguimiento>();
		while (rs.next()) {
			list.add(new SeguimientoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}

		return list;
	}

}
