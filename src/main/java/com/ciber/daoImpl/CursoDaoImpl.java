package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ciber.dao.ICursoDao;
import com.ciber.entities.Curso;
import com.ciber.resultSetExtractor.CursoSetExtractor;

@Repository
public class CursoDaoImpl implements ICursoDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<Curso> obtenerCursos(Integer usuario, Integer persona) {

		String sql = "";
		
		if(usuario == 2) {
			
			sql = "select c.cur_codigo , c.cur_nombre , c.cur_descripcion, "
					+ "p.per_nombre || ' ' || p.per_apellido as nombre_completo, p.per_codigo from public.curso c "
					+ "inner join public.persona p on c.per_codigo = p.per_codigo "
					+ "where c.cur_estado = 1 and p.per_codigo = ?";
			return jdbcTemplate.query(sql, new CursoSetExtractor(), persona);
			
		}else {
			sql = "select c.cur_codigo , c.cur_nombre , c.cur_descripcion, "
					+ "p.per_nombre || ' ' || p.per_apellido as nombre_completo, p.per_codigo from public.curso c "
					+ "inner join public.persona p on c.per_codigo = p.per_codigo "
					+ "where c.cur_estado = 1";
			return jdbcTemplate.query(sql, new CursoSetExtractor());
		}

	}

	@Override
	public int registrarCurso(Curso curso) {

		String sql = " INSERT INTO public.curso (cur_nombre , per_codigo , cur_descripcion) " + " VALUES(?, ?, ?); ";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { curso.getNombre(), curso.getInstructor(), curso.getDescripcion() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", curso.getNombre());
			parameter.addValue("instructor", curso.getInstructor());
			parameter.addValue("descripcion", curso.getDescripcion());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
	}

	@Override
	public int actualizar(Curso curso) {

		String sql = " UPDATE public.curso " + " SET cur_nombre  = ?, per_codigo  = ?, cur_descripcion  = ? "
				+ " WHERE cur_codigo  = ?; ";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { curso.getNombre(), curso.getInstructor(), curso.getDescripcion(), curso.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", curso.getNombre());
			parameter.addValue("instructor", curso.getInstructor());
			parameter.addValue("descripcion", curso.getDescripcion());
			parameter.addValue("codigo", curso.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int eliminarCurso(Curso curso) {
		
		String sql = " UPDATE public.curso " + " SET cur_estado  = 0 "
				+ " WHERE cur_codigo  = ?; ";
		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { curso.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("codigo", curso.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

}
