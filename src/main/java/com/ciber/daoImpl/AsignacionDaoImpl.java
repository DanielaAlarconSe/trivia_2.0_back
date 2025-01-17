package com.ciber.daoImpl;

import java.sql.Types;
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

		String sql = "select * from public.usuario u "
				+ "inner join public.persona p on u.per_codigo = p.per_codigo "
				+ "inner join public.entidad e on u.ent_codigo = e.ent_codigo "
				+ "left join public.asignacion_trivia at on u.usu_codigo = at.usu_codigo "
				+ "left join public.cuestionario cu on at.cue_codigo = cu.cue_codigo "
				+ "left join public.seguimiento s on at.seg_codigo = s.seg_codigo "
				+ "where u.ent_codigo = ? and u.usu_estado = 1 and at.ast_codigo is not null and at.ast_estado = 1";

		return jdbcTemplate.query(sql, new AsignacionSetExtractor(), entidad);
	}
	
	@Override
	public List<AsignacionDto> obtenerAspirante(Integer codigo) {
		
		String sql = "select * from public.usuario u "
				+ "inner join public.persona p on u.per_codigo = p.per_codigo "
				+ "inner join public.entidad e on u.ent_codigo = e.ent_codigo "
				+ "left join public.asignacion_trivia at on u.usu_codigo = at.usu_codigo "
				+ "left join public.cuestionario cu on at.cue_codigo = cu.cue_codigo "
				+ "left join public.seguimiento s on at.seg_codigo = s.seg_codigo "
				+ "where u.usu_codigo = ? and u.usu_estado = 1 and at.ast_codigo is not null "
				+ "order by at.ast_codigo desc limit 1";

		return jdbcTemplate.query(sql, new AsignacionSetExtractor(), codigo);
		
	}

	@Override
	public int registrarAsignacionTrivia(AsignacionTrivia asignacion) {

		String sql = " INSERT INTO public.asignacion_trivia ( usu_codigo, cue_codigo, "
				+ "  seg_codigo, ast_fecha_asignacion, ast_fecha_finalizacion) " + " VALUES (?, ?, 1, ?, ?) ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { asignacion.getUsuario(),
				asignacion.getCuestionario(), asignacion.getFechaAsignacion(), asignacion.getFechaFinalizacion() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("usuario", asignacion.getUsuario());
			parameter.addValue("cuestionario", asignacion.getCuestionario());
			parameter.addValue("fecha_asignacion", asignacion.getFechaAsignacion(), Types.TIMESTAMP);
			parameter.addValue("fecha_finalizacion", asignacion.getFechaFinalizacion(), Types.TIMESTAMP);

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
	}

	@Override
	public int actualizarAsignacionTrivia(AsignacionTrivia asignacion) {

		String sql = " UPDATE public.asignacion_trivia " + " SET ast_fecha_asignacion = ?, ast_fecha_finalizacion = ? "
				+ " WHERE ast_codigo = ? ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				asignacion.getFechaAsignacion(), asignacion.getFechaFinalizacion(), asignacion.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("fecha_finalizacion", asignacion.getFechaAsignacion(), Types.TIMESTAMP);
			parameter.addValue("fecha_finalizacion", asignacion.getFechaFinalizacion(), Types.TIMESTAMP);
			parameter.addValue("codigo", asignacion.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int eliminarAsignacionTrivia(AsignacionTrivia asignacion) {

		String sql = " UPDATE public.asignacion_trivia SET ast_estado  = 0 " + " WHERE ast_codigo  = ? ";

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
