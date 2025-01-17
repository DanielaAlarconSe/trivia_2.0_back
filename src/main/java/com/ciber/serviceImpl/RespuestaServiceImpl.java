package com.ciber.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.ICuestionarioDao;
import com.ciber.dao.IRespuestaDao;
import com.ciber.entities.Cuestionario;
import com.ciber.entities.Respuesta;
import com.ciber.entities.RespuestaCuestionario;
import com.ciber.entities.RespuestaOpcion;
import com.ciber.entities.RespuestaTipo;
import com.ciber.service.IRespuestaService;

@Service
public class RespuestaServiceImpl implements IRespuestaService {

	@Autowired
	IRespuestaDao respuestaDao;

	@Autowired
	ICuestionarioDao cuestionarioDao;

	@Override
	public List<RespuestaOpcion> obtenerRespuestasCuestionario(int codigo) {

		return respuestaDao.obtenerRespuestasCuestionario(codigo);

	}

	@Override
	public List<RespuestaTipo> obtenerRespuestaTipo() {

		return respuestaDao.obtenerRespuestaTipo();

	}

	@Override
	public int obtenerUltimoRegistro() {

		return respuestaDao.obtenerUltimoRegistro();

	}

	@Override
	public int registrarRespuesta(RespuestaOpcion respuestaOpcion) {

		return respuestaDao.registrarRespuesta(respuestaOpcion);

	}

	@Override
	public int actualizarRespuesta(RespuestaOpcion respuestaOpcion) {

		return respuestaDao.actualizarRespuesta(respuestaOpcion);

	}

	@Override
	public int registrarRespuestaCuestionario(RespuestaCuestionario respuestaCuestionario) {

		return respuestaDao.registrarRespuestaCuestionario(respuestaCuestionario);

	}

	@Override
	public int registrarRespuestaTrivia(Respuesta respuesta) {

		return respuestaDao.registrarRespuestaTrivia(respuesta);

	}

	@Override
	public int actualizarCalificacion(RespuestaCuestionario respuestaCuestionario) {

		return respuestaDao.actualizarCalificacion(respuestaCuestionario);

	}

	@Override
	public List<RespuestaCuestionario> obtenerResultadosEscalafonPorToken(String token) {

		Cuestionario cuestionario = cuestionarioDao.obtenerCuestionarioPorToken(token);

		// Validar si el cuestionario existe
		if (cuestionario == null) {
			throw new RuntimeException("Token inválido o cuestionario no encontrado");
		}

		LocalDate fechaFin = cuestionario.getFechaFin().toLocalDateTime().toLocalDate();
		if (LocalDate.now().isBefore(fechaFin)) {
			throw new RuntimeException(
					"Los resultados estarán disponibles después de la fecha de finalización del cuestionario.");
		}

		return respuestaDao.obtenerResultadosEscalafonPorToken(token);
	}

	@Override
	public boolean validarIp() {
		return respuestaDao.validarIp();
	}

}
