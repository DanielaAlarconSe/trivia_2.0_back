package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IUbicacionDao;
import com.ciber.entities.Pais;
import com.ciber.resultSetExtractor.PaisSetExtractor;

@Repository
public class UbicacionDaoImpl implements IUbicacionDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Pais> obtenerPaisLocal() {

		String sql = "select * from principal.pais p where p.pai_codigo = 43";

		return jdbcTemplate.query(sql, new PaisSetExtractor());
	}

	@Override
	public List<Pais> obtenerPaises() {

		String sql = "select * from principal.pais ";

		return jdbcTemplate.query(sql, new PaisSetExtractor());

	}

}
