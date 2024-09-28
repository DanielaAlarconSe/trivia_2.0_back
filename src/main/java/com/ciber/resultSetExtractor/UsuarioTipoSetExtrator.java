package com.ciber.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ciber.entities.UsuarioTipo;
import com.ciber.rowMapper.UsuarioTipoRowMapper;

public class UsuarioTipoSetExtrator implements ResultSetExtractor<List<UsuarioTipo>>{

	@Override
	public List<UsuarioTipo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<UsuarioTipo> list = new ArrayList<UsuarioTipo>();
		while (rs.next()) {
			list.add(new UsuarioTipoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}
