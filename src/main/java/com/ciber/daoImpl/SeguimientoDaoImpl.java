package com.ciber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ciber.dao.ISeguimientoDao;
import com.ciber.dto.EmailNotificacionDto;
import com.ciber.entities.Seguimiento;
import com.ciber.resultSetExtractor.SeguimientoSetExtractor;
import com.ciber.util.EmailComponent;

@Repository
public class SeguimientoDaoImpl implements ISeguimientoDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Seguimiento> obtenerSeguimiento() {

		String sql = " SELECT seg_codigo,seg_nombre,seg_estado  " + " FROM principal.seguimiento"
				+ " WHERE seg_estado = 1 ";

		return jdbcTemplate.query(sql, new SeguimientoSetExtractor());
	}

	@Override
	public void EnviarCorreoAspirante(EmailNotificacionDto email) {

		EmailNotificacionDto informacionCorreo = new EmailNotificacionDto();

		// PRUEBA
//		informacionCorreo.setAspiranteNombre("Daniela Alarcón Sepúlveda");
//		informacionCorreo.setDestinatarioAspirante("jd.cordoba97@gmail.com");
//		informacionCorreo.setUsuario("ejemplo@gmail.com");
//		informacionCorreo.setClave("12345678");
//		informacionCorreo.setEntidadNombre("Entidad Prueba");
//		informacionCorreo.setFechaFinalizacion("28/12/2024");
//		informacionCorreo.setAsunto("Prueba Diagnóstica - " + "Entidad Prueba");

		// PRODUCCION
		informacionCorreo.setAspiranteNombre(email.getAspiranteNombre());
		informacionCorreo.setDestinatarioAspirante(email.getDestinatarioAspirante());
		informacionCorreo.setUsuario(email.getUsuario());
		informacionCorreo.setClave(email.getClave());
		informacionCorreo.setEntidadNombre(email.getEntidadNombre());
		informacionCorreo.setFechaFinalizacion(email.getFechaFinalizacion());
		informacionCorreo.setAsunto("Prueba Diagnóstica - " + email.getEntidadNombre());

		EmailComponent.enviarNotificacion(informacionCorreo);

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
