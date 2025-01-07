package com.ciber.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.dto.EmailNotificacionDto;
import com.ciber.entities.AsignacionTrivia;
import com.ciber.entities.Seguimiento;
import com.ciber.service.ISeguimientoService;

@RestController
@RequestMapping(path = "seguimiento")
public class SeguimientoRestController {

	@Autowired
	ISeguimientoService seguimientoservice;
	
	@GetMapping(path = "obtener-seguimiento")
	public List<Seguimiento> obtenerSeguimiento() {
		return seguimientoservice.obtenerSeguimiento();
	}
	
	@PutMapping("email/aspirante")
	public void enviarCorreoAspirante(@Validated @RequestBody EmailNotificacionDto email, BindingResult result) {
		System.out.println(email + "TRAE DE EMAIL");
		seguimientoservice.EnviarCorreoAspirante(email);
	}
	
	@PutMapping("email/entidad")
	public void enviarCorreoEntidad(@Validated @RequestBody EmailNotificacionDto email, BindingResult result) {
		System.out.println(email + "TRAE DE EMAIL");
		seguimientoservice.EnviarCorreoEntidad(email);
	}
	
	@PutMapping(path = "actualizar-seguimiento")
	public int actualizarAsignacionTrivia(@RequestBody AsignacionTrivia asignacion) {
		return seguimientoservice.actualizarSeguimiento(asignacion);
	}
}	
