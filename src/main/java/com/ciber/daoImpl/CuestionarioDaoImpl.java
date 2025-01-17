package com.ciber.daoImpl;

import java.sql.Types;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ciber.dao.ICuestionarioDao;
import com.ciber.entities.Cuestionario;
import com.ciber.resultSetExtractor.CuestionarioSetExtractor;

@Repository
public class CuestionarioDaoImpl implements ICuestionarioDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<Cuestionario> obtenerCuestionarios(Integer usuario, Integer persona) {

		String sql = "";

		if (usuario == 2) {

			sql = "select * from public.cuestionario c "
					+ "left join public.curso cu on c.cur_codigo = cu.cur_codigo "
					+ "inner join public.cuestionario_categoria cc on c.cuc_codigo = cc.cuc_codigo "
					+ "where c.cue_estado = 1 and cu.per_codigo = ?";
			return jdbcTemplate.query(sql, new CuestionarioSetExtractor(), persona);

		} else {

			sql = "select * from public.cuestionario c "
					+ "left join public.curso cu on c.cur_codigo = cu.cur_codigo "
					+ "inner join public.cuestionario_categoria cc on c.cuc_codigo = cc.cuc_codigo "
					+ "where c.cue_estado = 1";
			return jdbcTemplate.query(sql, new CuestionarioSetExtractor());
		}

		
	}

	@Override
	public List<Cuestionario> obtenerCuestionarioCodigo(int codigo) {

		String sql = "select * from public.cuestionario c "
				+ "left join public.curso cu on c.cur_codigo = cu.cur_codigo "
				+ "inner join public.cuestionario_categoria cc on c.cuc_codigo = cc.cuc_codigo "
				+ "where c.cue_codigo = ? and c.cue_estado = 1";

		return jdbcTemplate.query(sql, new CuestionarioSetExtractor(), codigo);

	}

	@Override
	public List<Cuestionario> obtenerCuestionariosCurso(int codigo) {

		String sql = " SELECT * FROM public.cuestionario c "
				+ " INNER JOIN public.curso cu ON c.cur_codigo = cu.cur_codigo "
				+ " INNER JOIN public.cuestionario_categoria cc ON c.cuc_codigo = cc.cuc_codigo "
				+ " WHERE c.cur_codigo = ? AND c.cue_estado = 1 "
				+ " AND CURRENT_TIMESTAMP BETWEEN c.cue_fecha_inicio AND c.cue_fecha_fin;";

		return jdbcTemplate.query(sql, new CuestionarioSetExtractor(), codigo);

	}

	@Override
	public List<Cuestionario> obtenerCuestionariosCursoGeneral(int codigo) {

		String sql = "";
		
		if(codigo == 0) {
			
			sql = "select * from public.cuestionario c "
					+ "left join public.curso cu on c.cur_codigo = cu.cur_codigo "
					+ "inner join public.cuestionario_categoria cc on c.cuc_codigo = cc.cuc_codigo "
					+ "where c.cue_estado = 1";
			return jdbcTemplate.query(sql, new CuestionarioSetExtractor());
			
		}else {
			
			sql = "select * from public.cuestionario c "
					+ "left join public.curso cu on c.cur_codigo = cu.cur_codigo "
					+ "inner join public.cuestionario_categoria cc on c.cuc_codigo = cc.cuc_codigo "
					+ "where c.cur_codigo = ? and c.cue_estado = 1";
			return jdbcTemplate.query(sql, new CuestionarioSetExtractor(), codigo);
			
		}


	}

	@Override
	public int registrarCuestionario(Cuestionario cuestionario) {

		String token = null;
		if (cuestionario.getCategoriaCodigo() == 3 || cuestionario.getCategoriaCodigo() == 2) {
			token = UUID.randomUUID().toString().replace("-", "");
			cuestionario.setToken(token);
		}

		String sql = "INSERT INTO public.cuestionario (cue_nombre, cue_instrucciones, cur_codigo, "
				+ "cue_fecha_inicio, cue_fecha_fin, cuc_codigo, cue_token) VALUES(?, ?, ?, ?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { cuestionario.getNombre(), cuestionario.getInstrucciones(), cuestionario.getCursoCodigo(),
						cuestionario.getFechaInicio(), cuestionario.getFechaFin(), cuestionario.getCategoriaCodigo(),
						token });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", cuestionario.getNombre());
			parameter.addValue("instrucciones", cuestionario.getInstrucciones());
			parameter.addValue("curso", cuestionario.getCursoCodigo());
			parameter.addValue("fechaInicio", cuestionario.getFechaInicio(), Types.TIMESTAMP);
			parameter.addValue("fechaFin", cuestionario.getFechaFin(), Types.TIMESTAMP);
			parameter.addValue("categoria", cuestionario.getCategoriaCodigo());
			parameter.addValue("token", token);

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}

	}

	@Override
	public int actualizarCuestionario(Cuestionario cuestionario) {

		if (cuestionario.getCategoriaCodigo() == 3 || cuestionario.getCategoriaCodigo() == 2) {
			if (cuestionario.getToken() == null) {
				String token = UUID.randomUUID().toString().replace("-", "");
				cuestionario.setToken(token);
			}
		} else {
			cuestionario.setToken(null);
		}

		String sql = "UPDATE public.cuestionario SET cue_nombre = ?, cue_instrucciones = ?, cur_codigo = ?, cue_fecha_inicio = ?, cue_fecha_fin = ?, cue_estado = ?, cuc_codigo = ?, cue_token = ?  WHERE cue_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { cuestionario.getNombre(), cuestionario.getInstrucciones(), cuestionario.getCursoCodigo(),
						cuestionario.getFechaInicio(), cuestionario.getFechaFin(), cuestionario.getEstado(),
						cuestionario.getCategoriaCodigo(), cuestionario.getToken(), cuestionario.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", cuestionario.getNombre());
			parameter.addValue("instrucciones", cuestionario.getInstrucciones());
			parameter.addValue("curso", cuestionario.getCursoCodigo());
			parameter.addValue("fechaInicio", cuestionario.getFechaInicio(), Types.TIMESTAMP);
			parameter.addValue("fechaFin", cuestionario.getFechaFin(), Types.TIMESTAMP);
			parameter.addValue("estado", cuestionario.getEstado());
			parameter.addValue("categoria", cuestionario.getCategoriaCodigo());
			parameter.addValue("token", cuestionario.getToken());
			parameter.addValue("codigo", cuestionario.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Cuestionario obtenerCuestionarioPorToken(String token) {

		String sql = " SELECT * FROM public.cuestionario c "
				+ " left JOIN public.curso cu on c.cur_codigo = cu.cur_codigo "
				+ " INNER JOIN public.cuestionario_categoria cc on c.cuc_codigo = cc.cuc_codigo "
				+ " WHERE c.cue_token = ? AND c.cue_estado = 1 "
				+ " AND CURRENT_TIMESTAMP BETWEEN c.cue_fecha_inicio AND c.cue_fecha_fin ";

		List<Cuestionario> cuestionarios = jdbcTemplate.query(sql, new CuestionarioSetExtractor(), token);

		if (cuestionarios.isEmpty()) {
			return null;
		} else {
			return cuestionarios.get(0);
		}

	}

	@Override
	public List<Cuestionario> obtenerCuestionariosAspirantes() {

		String sql = "select * from public.cuestionario c "
				+ "inner join public.cuestionario_categoria cc on c.cuc_codigo = cc.cuc_codigo "
				+ "left join public.curso cr on c.cur_codigo = cr.cur_codigo "
				+ "where c.cuc_codigo = 2 and c.cue_estado = 1";

		return jdbcTemplate.query(sql, new CuestionarioSetExtractor());
	}

	@Override
	public Cuestionario obtenerCuestionarioPorTokenAspirante(String token) {
		
		String sql = "select * from public.cuestionario c "
				+ "left join public.curso cu on c.cur_codigo = cu.cur_codigo "
				+ "inner join public.cuestionario_categoria cc on c.cuc_codigo = cc.cuc_codigo "
				+ "left join public.asignacion_trivia at on c.cue_codigo = at.cue_codigo "
				+ "where c.cue_token = ? and c.cue_estado = 1 and current_timestamp between at.ast_fecha_asignacion and at.ast_fecha_finalizacion";

		List<Cuestionario> cuestionarios = jdbcTemplate.query(sql, new CuestionarioSetExtractor(), token);

		if (cuestionarios.isEmpty()) {
			return null;
		} else {
			return cuestionarios.get(0);
		}
		
	}

}
