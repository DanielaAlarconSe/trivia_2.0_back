package com.ciber.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailNotificacionDto {

	private String destinatarioAspirante;
	private String destinatarioEntidad;
	private String asunto;
	private String aspiranteNombre;
	private String entidadNombre;
	private String usuario;
	private String clave;
	private String fechaFinalizacion;
	private String fechaRegistro;
	private String puntaje;
	private String cuestionarioNombre;
	private String enlaceLogin;
}
