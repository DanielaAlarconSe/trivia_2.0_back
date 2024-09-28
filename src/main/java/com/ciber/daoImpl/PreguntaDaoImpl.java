package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IPreguntaDao;
import com.ciber.entities.Pregunta;
import com.ciber.entities.RespuestaTipo;
import com.ciber.resultSetExtractor.PreguntaSetExtractor;
import com.ciber.resultSetExtractor.RespuestaTipoSetExtractor;

@Repository
public class PreguntaDaoImpl implements IPreguntaDao{
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;


	@Override
	public List<Pregunta> obtenerPreguntasCuestionario(int codigo) {
		
		String sql = "select * from principal.pregunta p "
				+ "inner join principal.cuestionario c on p.cue_codigo = c.cue_codigo "
				+ "inner join principal.respuesta_tipo rt on p.ret_codigo = rt.ret_codigo "
				+ "where p.pre_estado = 1 and p.cue_codigo = " + codigo + " "
				+ "order by p.pre_codigo asc";

		return jdbcTemplate.query(sql, new PreguntaSetExtractor());
		
	}
	
	@Override
	public List<RespuestaTipo> obtenerRespuestaTipo() {
		
		String sql = "select * from principal.respuesta_tipo rt where rt.ret_estado = 1";

		return jdbcTemplate.query(sql, new RespuestaTipoSetExtractor());
		
	}


	@Override
	public int registrarPregunta(Pregunta pregunta) {
		
		String sql = "INSERT INTO principal.pregunta "
				+ "(pre_nombre, cue_codigo, ret_codigo, pre_texto_adicional) "
				+ "VALUES(?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { pregunta.getNombre(), pregunta.getCuestionarioCodigo(), pregunta.getTipoRespuestaCodigo(), pregunta.getTextoAdicional()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("1", pregunta.getNombre());
			parameter.addValue("2", pregunta.getCuestionarioCodigo());
			parameter.addValue("3", pregunta.getTipoRespuestaCodigo());
			parameter.addValue("4", pregunta.getTextoAdicional());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
		
	}

	@Override
	public int actualizarPregunta(Pregunta pregunta) {
		
		String sql = "UPDATE principal.pregunta "
				+ "SET pre_nombre = ?, cue_codigo = ?, ret_codigo = ?, pre_texto_adicional = ?, pre_estado = ? "
				+ "WHERE pre_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { pregunta.getNombre(), pregunta.getCuestionarioCodigo(), pregunta.getTipoRespuestaCodigo(), pregunta.getTextoAdicional(), pregunta.getEstado(), pregunta.getCodigo()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("1", pregunta.getNombre());
			parameter.addValue("2", pregunta.getCuestionarioCodigo());
			parameter.addValue("3", pregunta.getTipoRespuestaCodigo());
			parameter.addValue("4", pregunta.getTextoAdicional());
			parameter.addValue("5", pregunta.getEstado());
			parameter.addValue("6", pregunta.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
		
	}

}
