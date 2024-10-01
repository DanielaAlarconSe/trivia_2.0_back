package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ciber.dao.ICuestionarioCategoriaDao;
import com.ciber.entities.CuestionarioCategoria;
import com.ciber.resultSetExtractor.CategoriaSetExtractor;

@Repository
public class CuestionarioCategoriaDaoImpl implements ICuestionarioCategoriaDao{

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CuestionarioCategoria> obtenerCategorias() {

		String sql = " select c.cuc_codigo, c.cuc_nombre, c.cuc_descripcion from principal.cuestionario_categoria c where cuc_estado = 1 ";
		
		return jdbcTemplate.query(sql, new CategoriaSetExtractor());
	}

}
