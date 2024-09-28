package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IRespuestaDao;
import com.ciber.entities.Respuesta;
import com.ciber.entities.RespuestaCuestionario;
import com.ciber.entities.RespuestaOpcion;
import com.ciber.entities.RespuestaTipo;
import com.ciber.resultSetExtractor.RespuestaOpcionSetExtractor;
import com.ciber.resultSetExtractor.RespuestaTipoSetExtractor;

@Repository
public class RespuestaDaoImpl implements IRespuestaDao{
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<RespuestaOpcion> obtenerRespuestasCuestionario(int codigo) {
		
		String sql = "select * from principal.respuesta_opcion ro "
				+ "inner join principal.cuestionario c on ro.cue_codigo = c.cue_codigo "
				+ "where ro.cue_codigo = " + codigo + " and ro.reo_estado = 1 "
				+ "order by ro.reo_codigo asc";

		return jdbcTemplate.query(sql, new RespuestaOpcionSetExtractor());
		
	}

	@Override
	public List<RespuestaTipo> obtenerRespuestaTipo() {
		
		String sql = "select * from principal.respuesta_tipo rt where rt.ret_estado = 1";

		return jdbcTemplate.query(sql, new RespuestaTipoSetExtractor());
		
	}
	
	@Override
	public int obtenerUltimoRegistro() {
		
	    String sql = "select rc.rec_codigo from principal.respuesta_cuestionario rc order by rc.rec_codigo desc limit 1;";
	    
	    return jdbcTemplate.queryForObject(sql, Integer.class);
	    
	}

	@Override
	public int registrarRespuesta(RespuestaOpcion respuestaOpcion) {
		
		String sql = "INSERT INTO principal.respuesta_opcion "
				+ "(reo_nombre, cue_codigo, reo_puntuacion) "
				+ "VALUES(?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { respuestaOpcion.getNombre(), respuestaOpcion.getCuestionarioCodigo(), respuestaOpcion.getPuntuacion()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("1", respuestaOpcion.getNombre());
			parameter.addValue("2", respuestaOpcion.getCuestionarioCodigo());
			parameter.addValue("3", respuestaOpcion.getPuntuacion());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
		
	}

	@Override
	public int actualizarRespuesta(RespuestaOpcion respuestaOpcion) {
		
		String sql = "UPDATE principal.respuesta_opcion "
				+ "SET reo_nombre = ?, cue_codigo = ?, reo_puntuacion = ?, reo_estado = ? "
				+ "WHERE reo_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { respuestaOpcion.getNombre(), respuestaOpcion.getCuestionarioCodigo(), respuestaOpcion.getPuntuacion(), respuestaOpcion.getEstado(), respuestaOpcion.getCodigo()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("1", respuestaOpcion.getNombre());
			parameter.addValue("2", respuestaOpcion.getCuestionarioCodigo());
			parameter.addValue("3", respuestaOpcion.getPuntuacion());
			parameter.addValue("4", respuestaOpcion.getEstado());
			parameter.addValue("5", respuestaOpcion.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
		
	}

	@Override
	public int registrarRespuestaCuestionario(RespuestaCuestionario respuestaCuestionario) {
		
		String sql = "INSERT INTO principal.respuesta_cuestionario "
				+ "(rec_estudiante_nombre, cue_codigo, rec_calificacion_total, rec_total_preguntas) "
				+ "VALUES(?, ?, ?, (SELECT COUNT(*) FROM principal.pregunta WHERE cue_codigo = ? and pre_estado = 1));";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { respuestaCuestionario.getEstudianteNombre(), respuestaCuestionario.getCuestionarioCodigo(), respuestaCuestionario.getCalificacionTotal(), respuestaCuestionario.getCuestionarioCodigo()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("1", respuestaCuestionario.getEstudianteNombre());
			parameter.addValue("2", respuestaCuestionario.getCuestionarioCodigo());
			parameter.addValue("3", respuestaCuestionario.getCalificacionTotal());
			parameter.addValue("4", respuestaCuestionario.getCuestionarioCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
		
	}

	@Override
	public int registrarRespuestaTrivia(Respuesta respuesta) {
		
		String sql = "INSERT INTO principal.respuesta "
				+ "(rec_codigo, prr_codigo, pre_codigo) "
				+ "VALUES(?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { respuesta.getRespuestaCuestionarioCodigo(), respuesta.getPreguntaRespuestaCodigo(), respuesta.getPreguntaCodigo()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("1", respuesta.getRespuestaCuestionarioCodigo());
			parameter.addValue("2", respuesta.getPreguntaRespuestaCodigo());
			parameter.addValue("3", respuesta.getPreguntaCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
		
	}

	@Override
	public int actualizarCalificacion(RespuestaCuestionario respuestaCuestionario) {
		
		String sql = "UPDATE principal.respuesta_cuestionario "
				+ "SET rec_calificacion_total = ? "
				+ "WHERE rec_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { respuestaCuestionario.getCalificacionTotal(), respuestaCuestionario.getCodigo()});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("1", respuestaCuestionario.getCalificacionTotal());
			parameter.addValue("2", respuestaCuestionario.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
	}

}
