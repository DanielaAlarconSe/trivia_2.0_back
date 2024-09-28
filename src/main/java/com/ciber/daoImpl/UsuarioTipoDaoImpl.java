package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IUsuarioTipoDao;
import com.ciber.entities.UsuarioTipo;
import com.ciber.resultSetExtractor.UsuarioTipoSetExtrator;

@Repository
public class UsuarioTipoDaoImpl implements IUsuarioTipoDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<UsuarioTipo> obtenerTipoUsuario() {

		String sql = " SELECT * FROM principal.usuario_tipo ut WHERE ut.ust_codigo in (1,2) AND ut.ust_estado = 1 ";

		return jdbcTemplate.query(sql, new UsuarioTipoSetExtrator());
	}

}
