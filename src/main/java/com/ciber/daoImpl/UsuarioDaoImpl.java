package com.ciber.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IUsuarioDao;
import com.ciber.dto.UsuarioDto;
import com.ciber.entities.Usuario;
import com.ciber.rowMapper.UsuarioRowMapper;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@SuppressWarnings("deprecation")
	@Override
	public Usuario buscarUsuario(String username) {
		String sql = " SELECT * FROM principal.vista_usuario vu " + " WHERE vu.usu_nombre = ? AND vu.usu_estado = 1 "
				+ " LIMIT 1;";
		return jdbcTemplate.queryForObject(sql, new Object[] { username }, new UsuarioRowMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean validarUsuario(String username) {
		int result = 0;
		String sql = "select COUNT(usu_nombre) from principal.vista_usuario " + "where usu_nombre = ? ";
		result = jdbcTemplate.queryForObject(sql, new Object[] { username }, Integer.class);
		return result > 0 ? true : false;
	}

	@Override
	public int registrarUsuario(UsuarioDto usuario) {

		String sql = "INSERT INTO principal.usuario (per_codigo  , usu_nombre  , uwd2 , ust_codigo) "
				+ "VALUES( ?, ?, ?, ? ) ";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { usuario.getCodigo(), usuario.getUsuario(), usuario.getContrasena(), usuario.getTipo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("codigo", usuario.getCodigo());
			parameter.addValue("usuario", usuario.getUsuario());
			parameter.addValue("clave", usuario.getContrasena());
			parameter.addValue("tipo", usuario.getTipo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
	}

	@Override
	public int actualizarUsuario(UsuarioDto usuario) {

		String sql = " UPDATE principal.usuario " + " SET uwd2 = ?, ust_codigo = ?, usu_estado = 1  " + " WHERE per_codigo = ?; ";

		int result = jdbcTemplateEjecucion.update(sql,
				new Object[] { usuario.getContrasena(), usuario.getTipo(), usuario.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("clave", usuario.getContrasena());
			parameter.addValue("tipo", usuario.getTipo());
			parameter.addValue("codigo", usuario.getCodigo());
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int eliminarUsuario(UsuarioDto usuario) {

		String sql = " UPDATE principal.usuario " + " SET usu_estado = 0  " + " WHERE per_codigo = ? ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { usuario.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("codigo", usuario.getCodigo());
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

}