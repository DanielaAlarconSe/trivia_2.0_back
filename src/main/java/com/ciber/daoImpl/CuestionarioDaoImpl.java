package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Types;

import com.ciber.dao.ICuestionarioDao;
import com.ciber.entities.Cuestionario;
import com.ciber.resultSetExtractor.CuestionarioSetExtractor;

@Repository
public class CuestionarioDaoImpl implements ICuestionarioDao{
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<Cuestionario> obtenerCuestionarios() {
		
		String sql = "select * from principal.cuestionario c "
				+ "inner join principal.curso cu on c.cur_codigo = cu.cur_codigo "
				+ "inner join principal.cuestionario_categoria cc on c.cuc_codigo = cc.cuc_codigo "
				+ "where c.cue_estado = 1";

		return jdbcTemplate.query(sql, new CuestionarioSetExtractor());
	}
	
	@Override
	public List<Cuestionario> obtenerCuestionarioCodigo(int codigo) {
		
		String sql = "select * from principal.cuestionario c "
				+ "inner join principal.curso cu on c.cur_codigo = cu.cur_codigo "
				+ "where c.cue_codigo = " + codigo + " and c.cue_estado = 1";

		return jdbcTemplate.query(sql, new CuestionarioSetExtractor());
		
	}
	
	@Override
	public List<Cuestionario> obtenerCuestionariosCurso(int codigo) {
		
		String sql = " SELECT * FROM principal.cuestionario c "
				+ " INNER JOIN principal.curso cu ON c.cur_codigo = cu.cur_codigo "
				+ " INNER JOIN principal.cuestionario_categoria cc ON c.cuc_codigo = cc.cuc_codigo "
				+ " WHERE c.cur_codigo = ? AND c.cue_estado = 1 "
				+ " AND CURRENT_DATE BETWEEN c.cue_fecha_inicio AND c.cue_fecha_fin;";

		return jdbcTemplate.query(sql, new CuestionarioSetExtractor(), codigo);
		
	}

	@Override
	public int registrarCuestionario(Cuestionario cuestionario) {
		
		String sql = "INSERT INTO principal.cuestionario (cue_nombre, cue_instrucciones, cur_codigo, cue_fecha_inicio, cue_fecha_fin, cuc_codigo) VALUES(?, ?, ?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { cuestionario.getNombre(), cuestionario.getInstrucciones(), cuestionario.getCursoCodigo(), cuestionario.getFechaInicio(), cuestionario.getFechaFin(), cuestionario.getCategoriaCodigo()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", cuestionario.getNombre());
			parameter.addValue("instrucciones", cuestionario.getInstrucciones());
			parameter.addValue("curso", cuestionario.getCursoCodigo());
			parameter.addValue("fechaInicio", cuestionario.getFechaInicio(), Types.TIMESTAMP);
			parameter.addValue("fechaFin", cuestionario.getFechaFin(), Types.TIMESTAMP);
			parameter.addValue("categoria", cuestionario.getCategoriaCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
		
	}

	@Override
	public int actualizarCuestionario(Cuestionario cuestionario) {
		
		String sql = "UPDATE principal.cuestionario SET cue_nombre = ?, cue_instrucciones = ?, cur_codigo = ?, cue_fecha_inicio = ?, cue_fecha_fin = ?, cue_estado = ?, cuc_codigo = ? WHERE cue_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { cuestionario.getNombre(), cuestionario.getInstrucciones(), cuestionario.getCursoCodigo(), cuestionario.getFechaInicio(), cuestionario.getFechaFin(), cuestionario.getEstado(), cuestionario.getCategoriaCodigo(), cuestionario.getCodigo()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", cuestionario.getNombre());
			parameter.addValue("instrucciones", cuestionario.getInstrucciones());
			parameter.addValue("curso", cuestionario.getCursoCodigo());
			parameter.addValue("fechaInicio", cuestionario.getFechaInicio(), Types.TIMESTAMP);
			parameter.addValue("fechaFin", cuestionario.getFechaFin(), Types.TIMESTAMP);
			parameter.addValue("estado", cuestionario.getEstado());
			parameter.addValue("categoria", cuestionario.getCategoriaCodigo());
			parameter.addValue("codigo", cuestionario.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

}
