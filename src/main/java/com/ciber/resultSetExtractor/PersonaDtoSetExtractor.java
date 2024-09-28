package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.dto.PersonaDto;
import com.ciber.rowMapper.PersonaDtoRowMapper;

public class PersonaDtoSetExtractor implements ResultSetExtractor<List<PersonaDto>>{

	@Override
	public List<PersonaDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<PersonaDto> list = new ArrayList<PersonaDto>();
		while (rs.next()) {
			list.add(new PersonaDtoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}

}
