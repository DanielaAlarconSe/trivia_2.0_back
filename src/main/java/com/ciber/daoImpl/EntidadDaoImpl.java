package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IEntidadDao;
import com.ciber.entities.Entidad;
import com.ciber.resultSetExtractor.EntidadSetExtractor;

@Repository
public class EntidadDaoImpl implements IEntidadDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public int registrarEntidad(Entidad entidad) {

		String sql = " INSERT INTO public.entidad (ent_nombre, ent_direccion, "
				+ " ent_telefono, ent_email) VALUES (?, ?, ?, ?) ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { entidad.getNombre(), entidad.getDireccion(),
				entidad.getTelefono(), entidad.getEmail() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", entidad.getNombre());
			parameter.addValue("direccion", entidad.getDireccion());
			parameter.addValue("telefono", entidad.getTelefono());
			parameter.addValue("email", entidad.getEmail());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
	}

	@Override
	public int actualizarEntidad(Entidad entidad) {

		String sql = " UPDATE public.entidad " + " SET ent_nombre = ?, ent_direccion = ?, ent_telefono = ?, "
				+ " ent_email = ? " + " WHERE ent_codigo = ? ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { entidad.getNombre(), entidad.getDireccion(),
				entidad.getTelefono(), entidad.getEmail(), entidad.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", entidad.getNombre());
			parameter.addValue("direccion", entidad.getDireccion());
			parameter.addValue("telefono", entidad.getTelefono());
			parameter.addValue("email", entidad.getEmail());
			parameter.addValue("codigo", entidad.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int eliminarEntidad(Entidad entidad) {

		String sql = " UPDATE public.entidad SET ent_estado  = 0 " + " WHERE ent_codigo  = ? ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { entidad.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("codigo", entidad.getCodigo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Entidad> obtenerEntidad() {
		
		String sql = " select * from public.entidad e where e.ent_estado = 1 order by e.ent_codigo asc";
		
		return jdbcTemplate.query(sql, new EntidadSetExtractor());
	}

}
