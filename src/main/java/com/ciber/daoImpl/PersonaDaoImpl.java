package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ciber.dao.IPersonaDao;
import com.ciber.dto.PersonaDto;
import com.ciber.entities.Persona;
import com.ciber.resultSetExtractor.InstructorSetExtractor;
import com.ciber.resultSetExtractor.PersonaDtoSetExtractor;
import com.ciber.resultSetExtractor.PersonaSetExtractor;

@Repository
public class PersonaDaoImpl implements IPersonaDao {

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Persona> obtenerPersonaCodigo(Integer id) {

		String sql = " SELECT * FROM principal.persona p " + " WHERE p.per_codigo = '" + id + "' AND p.per_estado = 1 ";
		return jdbcTemplate.query(sql, new PersonaSetExtractor());

	}

	@Override
	public List<Persona> obtenerPersonas() {

		String sql = " SELECT * FROM principal.persona p "
				+ " inner join principal.pais pa on p.per_pais_residencia = pa.pai_codigo " + " WHERE p.per_estado = 1 "
				+ " ORDER BY p.per_codigo desc";
		return jdbcTemplate.query(sql, new PersonaSetExtractor());

	}

	@Override
	public int registrar(Persona persona) {
		String sql = " INSERT INTO principal.persona " + " (per_apellido, per_nombre, per_pais_residencia, per_email) "
				+ " VALUES(?, ?, ?, ?); ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { persona.getApellido(), persona.getNombre(),
				persona.getPaisResidencia(), persona.getCorreo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("apellido", persona.getApellido());
			parameter.addValue("nombre", persona.getNombre());
			parameter.addValue("paisResidencia", persona.getPaisResidencia());
			parameter.addValue("correo", persona.getCorreo());

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}
	}

	@Override
	public int actualizar(Persona persona) {
		System.out.println(persona);

		String sql = " UPDATE principal.persona "
				+ " SET per_apellido = ?, per_nombre = ?, per_pais_residencia = ?, per_email = ?  "
				+ " WHERE per_codigo = ?; ";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] { persona.getApellido(), persona.getNombre(),
				persona.getPaisResidencia(), persona.getCorreo(), persona.getCodigo() });

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("apellido", persona.getApellido());
			parameter.addValue("nombre", persona.getNombre());
			parameter.addValue("paisResidencia", persona.getPaisResidencia());
			parameter.addValue("correo", persona.getCorreo());
			parameter.addValue("codigo", persona.getCodigo());
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<PersonaDto> obtenerPersonasUsuario() {

		String sql = "SELECT p.per_codigo, p.per_nombre, p.per_apellido, p.per_email, p.per_pais_residencia, p.per_fecha_registro, u.uwd2 , ut.ust_codigo , ut.ust_nombre, "
				+ "COUNT(CASE WHEN u.usu_estado = 1 THEN 1 ELSE NULL END) AS usuario FROM principal.persona p "
				+ "LEFT JOIN principal.usuario u ON p.per_codigo = u.per_codigo "
				+ "LEFT JOIN principal.usuario_tipo ut on u.ust_codigo = ut.ust_codigo "
				+ "WHERE p.per_estado = 1 "
				+ "GROUP BY p.per_codigo, p.per_nombre, p.per_apellido, p.per_email, p.per_pais_residencia, p.per_fecha_registro, u.uwd2 , ut.ust_codigo , ut.ust_nombre "
				+ "ORDER BY usuario desc;";

		return jdbcTemplate.query(sql, new PersonaDtoSetExtractor());
	}

	@Override
	public List<Persona> obtenerInstructores() {
		String sql = " SELECT p.per_codigo , p.per_apellido, p.per_nombre FROM principal.persona p "
				+ " INNER JOIN principal.usuario u ON p.per_codigo = u.per_codigo "
				+ " WHERE u.ust_codigo = 2 ORDER BY p.per_apellido , p.per_nombre DESC ";
		return jdbcTemplate.query(sql, new InstructorSetExtractor());
	}

}
