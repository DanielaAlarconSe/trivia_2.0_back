package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.PreguntaRespuesta;
import com.ciber.rowMapper.PreguntaRespuestaRowMapper;

public class PreguntaRespuestaSetExtractor implements ResultSetExtractor<List<PreguntaRespuesta>>{

	@Override
	public List<PreguntaRespuesta> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<PreguntaRespuesta> list = new ArrayList<PreguntaRespuesta>();
		while (rs.next()) {
			list.add(new PreguntaRespuestaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
