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
	public List<CuestionarioCategoria> obtenerCategorias(Integer usuarioTipo) {
		
		String sql = "";
		
		if(usuarioTipo == 2) {
			sql = "select * from public.cuestionario_categoria c where c.cuc_estado = 1 and c.cuc_codigo in (1,3)";		
		}else {
			sql = "select * from public.cuestionario_categoria c where c.cuc_estado = 1 ";
		}
		
		return jdbcTemplate.query(sql, new CategoriaSetExtractor());
	}

}
