package com.ciber.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IWebParametroDao;

@Repository
public class WebParametroDaoImpl implements IWebParametroDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public String getValor(String nombre) {

		String sql = " SELECT wep_valor FROM public.web_parametro WHERE wep_nombre = ? ";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { nombre }, String.class);
		} catch (EmptyResultDataAccessException e) {
			System.err.println("No se encontró el parámetro: " + nombre);
			return null;
		} catch (DataAccessException e) {
			System.err.println("Error al consultar el parámetro: " + e.getMessage());
			throw e;
		}
	}

}
