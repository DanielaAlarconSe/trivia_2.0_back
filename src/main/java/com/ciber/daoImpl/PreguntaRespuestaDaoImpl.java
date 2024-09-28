package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IPreguntaRespuestaDao;
import com.ciber.entities.PreguntaRespuesta;
import com.ciber.resultSetExtractor.PreguntaRespuestaSetExtractor;

@Repository
public class PreguntaRespuestaDaoImpl implements IPreguntaRespuestaDao {
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<PreguntaRespuesta> obtenerPreguntaRespuestas(int codigo) {
		
		String sql = "select * from principal.pregunta_respuesta pr "
				+ "inner join principal.pregunta p on pr.pre_codigo = p.pre_codigo "
				+ "inner join principal.respuesta_opcion ro on pr.reo_codigo = ro.reo_codigo "
				+ "inner join principal.cuestionario c on p.cue_codigo = c.cue_codigo "
				+ "where pr.pre_codigo = " + codigo + " and pr.prr_estado = 1 "
				+ "order by pr.prr_codigo asc";

		return jdbcTemplate.query(sql, new PreguntaRespuestaSetExtractor());
		
	}

	@Override
	public int registrarPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
		
		String sql = "INSERT INTO principal.pregunta_respuesta "
				+ "(pre_codigo, reo_codigo) "
				+ "VALUES(?, ?);";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { preguntaRespuesta.getPreguntaCodigo(), preguntaRespuesta.getRespuestaOpcionCodigo()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("1", preguntaRespuesta.getPreguntaCodigo());
			parameter.addValue("2", preguntaRespuesta.getRespuestaOpcionCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
		
	}

	@Override
	public int actualizarPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
		
		String sql = "UPDATE principal.pregunta_respuesta "
				+ "SET pre_codigo = ?, reo_codigo = ?, prr_estado = ? "
				+ "WHERE prr_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { preguntaRespuesta.getPreguntaCodigo(), preguntaRespuesta.getRespuestaOpcionCodigo(), preguntaRespuesta.getEstado(), preguntaRespuesta.getCodigo()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("1", preguntaRespuesta.getPreguntaCodigo());
			parameter.addValue("2", preguntaRespuesta.getRespuestaOpcionCodigo());
			parameter.addValue("3", preguntaRespuesta.getEstado());
			parameter.addValue("4", preguntaRespuesta.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
		
	}

}
