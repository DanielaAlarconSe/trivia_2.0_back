package com.ciber.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IResultadosReportesDao;
import com.ciber.dto.EmailNotificacionDto;
import com.ciber.dto.ReporteAgrupadoDto;
import com.ciber.entities.Calificacion;
import com.ciber.resultSetExtractor.CalificacionSetExtractor;
import com.ciber.util.EmailComponent;

@Repository
public class ResultadosReportesDaoImpl implements IResultadosReportesDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public float obtenerResultadoTrivia(Integer codigo) {

		String sql = "select rc.rec_calificacion_total from principal.respuesta_cuestionario rc where rc.rec_codigo = ? ;";

		return jdbcTemplate.queryForObject(sql, Float.class, codigo);

	}

	@Override
	public List<Calificacion> obtenerCalificaciones() {

		String sql = "select * from principal.respuesta_cuestionario rc "
				+ "inner join principal.cuestionario cu on rc.cue_codigo = cu.cue_codigo "
				+ "inner join principal.curso c on cu.cur_codigo = c.cur_codigo "
				+ "group by rc.rec_codigo, c.cur_codigo, cu.cue_codigo, rc.rec_calificacion_total "
				+ "order by rc.rec_calificacion_total desc;";
		

		return jdbcTemplate.query(sql, new CalificacionSetExtractor());

	}

	@Override
	public List<Calificacion> obtenerCalificacionesTrivia(Integer codigo) {

		String sql = "select * from principal.respuesta_cuestionario rc "
				+ "inner join principal.cuestionario cu on rc.cue_codigo = cu.cue_codigo "
				+ "inner join principal.curso c on cu.cur_codigo = c.cur_codigo " + "where rc.cue_codigo = ? "
				+ "group by rc.rec_codigo, c.cur_codigo, cu.cue_codigo, rc.rec_calificacion_total "
				+ "order by rc.rec_calificacion_total desc;";

		return jdbcTemplate.query(sql, new CalificacionSetExtractor(), codigo);

	}

	@Override
	public List<Calificacion> obtenerCalificacionesToken(String token) {

		String sql = "select * from principal.respuesta_cuestionario rc "
				+ "inner join principal.cuestionario cu on rc.cue_codigo = cu.cue_codigo "
				+ "inner join principal.curso c on cu.cur_codigo = c.cur_codigo "
				+ "WHERE cu.cue_token = ? AND cu.cue_estado = 1 AND cu.cue_fecha_fin <= NOW() "
				+ "group by rc.rec_codigo, c.cur_codigo, cu.cue_codigo, rc.rec_calificacion_total "
				+ "ORDER BY rc.rec_calificacion_total DESC, rc.rec_fecha_registro ASC;";

		return jdbcTemplate.query(sql, new CalificacionSetExtractor(), token);

	}

	@Override
	public List<ReporteAgrupadoDto> generarDatosReporteAgrupado(Integer cuestionario, Integer[] preguntas) {
		// Construir dinámicamente la parte de la consulta SQL para las preguntas
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("WITH resultado AS (").append("    SELECT ").append("        rc.rec_codigo, ")
				.append("        rc.rec_estudiante_nombre, ").append("        rc.rec_fecha_registro,")
				.append("        pr.pre_codigo, ").append("        ro.reo_nombre,")
				.append("        rc.rec_calificacion_total").append("    FROM ")
				.append("        principal.respuesta_cuestionario rc ")
				.append("        INNER JOIN principal.respuesta r ON r.rec_codigo = rc.rec_codigo")
				.append("        INNER JOIN principal.pregunta_respuesta pr ON r.prr_codigo = pr.prr_codigo")
				.append("        INNER JOIN principal.pregunta p ON pr.pre_codigo = p.pre_codigo ")
				.append("        INNER JOIN principal.respuesta_opcion ro ON pr.reo_codigo = ro.reo_codigo ")
				.append("    WHERE ").append("        rc.cue_codigo = ?").append(")").append("SELECT ")
				.append("    rec_codigo,").append("    rec_estudiante_nombre,").append("    rec_fecha_registro,");

		for (int pregunta : preguntas) {
			sqlBuilder.append("    MAX(CASE WHEN pre_codigo = ").append(pregunta).append(" THEN reo_nombre END) AS \"")
					.append(pregunta).append("\",");
		}

		sqlBuilder.append("    rec_calificacion_total").append(" FROM ").append("    resultado").append(" GROUP BY ")
				.append("    rec_codigo, rec_estudiante_nombre, rec_fecha_registro, rec_calificacion_total;");

		String sql = sqlBuilder.toString();

		// Ejecutar la consulta y mapear los resultados
		return jdbcTemplate.query(sql, new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, cuestionario);
			}
		}, new RowMapper<ReporteAgrupadoDto>() {
			public ReporteAgrupadoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				ReporteAgrupadoDto dto = new ReporteAgrupadoDto();
				dto.setEstudianteNombre(rs.getString("rec_estudiante_nombre"));
				dto.setFechaRegistro(rs.getTimestamp("rec_fecha_registro"));
				dto.setCalificacion(rs.getFloat("rec_calificacion_total"));

				Map<String, String> columnas = new HashMap<>();
				for (int pregunta : preguntas) {
					columnas.put(String.valueOf(pregunta), rs.getString(String.valueOf(pregunta)));
				}
				dto.setColumnas(columnas);

				return dto;
			}
		});
	}

	@Override
	public void EnviarCorreoEntidad(EmailNotificacionDto email) {

		EmailNotificacionDto informacionCorreo = new EmailNotificacionDto();
		
		//PRUEBA
//		informacionCorreo.setAspiranteNombre("Daniela Alarcón Sepúlveda");
//		informacionCorreo.setDestinatarioEntidad("jd.cordoba97@gmail.com");
//		informacionCorreo.setCuestionarioNombre("Puesto Desarrollador de Software");
//		informacionCorreo.setEntidadNombre("Entidad de Prueba");
//		informacionCorreo.setFechaRegistro("26/12/2024");
//		informacionCorreo.setPuntaje("5 puntos");

		//PRODUCCION
		informacionCorreo.setAspiranteNombre(email.getAspiranteNombre());
		informacionCorreo.setDestinatarioEntidad(email.getDestinatarioEntidad());
		informacionCorreo.setCuestionarioNombre(email.getCuestionarioNombre());
		informacionCorreo.setEntidadNombre(email.getEntidadNombre());
		informacionCorreo.setFechaRegistro(email.getFechaRegistro());
		informacionCorreo.setPuntaje(email.getPuntaje());
		informacionCorreo.setAsunto("Resultados Prueba Diagnóstica " + email.getCuestionarioNombre());

		EmailComponent.enviarNotificacionEntidad(informacionCorreo);
		;

	}

}
