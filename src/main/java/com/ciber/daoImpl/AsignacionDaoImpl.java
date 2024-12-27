package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IAsignacionDao;
import com.ciber.dto.AsignacionDto;
import com.ciber.entities.AsignacionTrivia;
import com.ciber.resultSetExtractor.AsignacionSetExtractor;

@Repository
public class AsignacionDaoImpl implements IAsignacionDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<AsignacionDto> obtenerAspirantesPorEntidad(Integer entidad) {

		String sql = " SELECT a.usu_codigo, a.usu_nombre, at.ast_codigo, at.cue_codigo, "
				+ " at.ast_fecha_asignacion, at.ast_fecha_finalizacion, at.ast_estado, "
				+ " s.seg_nombre FROM usuario a " + " LEFT JOIN "
				+ " asignacion_trivia at ON a.usu_codigo = at.usu_codigo " + " LEFT JOIN "
				+ " seguimiento s ON at.seg_codigo = s.seg_codigo " + " WHERE a.ent_codigo = ? ";

		return jdbcTemplate.query(sql, new AsignacionSetExtractor(), entidad);
	}

	@Override
	public int registrarAsignacionTrivia(AsignacionTrivia asignacion) {

		String sql = " INSERT INTO principal.asignacion_trivia ( usu_codigo, cue_codigo, "
				+ "  seg_codigo, ast_fecha_finalizacion) " + " VALUES (?, ?, ?, ?) ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { asignacion.getUsuario(),
				asignacion.getCuestionario(), asignacion.getSeguimiento(), asignacion.getFechaFinalizacion() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("usuario", asignacion.getUsuario());
			parameter.addValue("cuestionario", asignacion.getCuestionario());
			parameter.addValue("seguimiento", asignacion.getSeguimiento());
			parameter.addValue("fecha_finalizacion", asignacion.getFechaFinalizacion());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
	}

	@Override
	public int actualizarAsignacionTrivia(AsignacionTrivia asignacion) {

		String sql = " UPDATE principal.asignacion_trivia " + " SET seg_codigo = ?, ast_fecha_finalizacion = ? "
				+ " WHERE ast_codigo = ? ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { asignacion.getSeguimiento(),
				asignacion.getFechaFinalizacion(), asignacion.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("seguimiento", asignacion.getSeguimiento());
			parameter.addValue("fecha_finalizacion", asignacion.getFechaFinalizacion());
			parameter.addValue("codigo", asignacion.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int eliminarAsignacionTrivia(AsignacionTrivia asignacion) {

		String sql = " UPDATE principal.asignacion_trivia SET ast_estado  = 0 " + " WHERE ast_codigo  = ? ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { asignacion.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("codigo", asignacion.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

}
