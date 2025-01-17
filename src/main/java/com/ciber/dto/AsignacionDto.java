package com.ciber.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AsignacionDto {

	private Integer usuarioCodigo;
	private Integer personaCodigo;
	private String personaNombre;
	private String personaApellido;
	private String personaEmail;
	private String personaToken;
	private Integer entidadCodigo;
	private String entidadNombre;
	private String entidadEmail;
	private Integer asignacionCodigo;
	private Integer cuestionarioCodigo;
	private String cuestionarioNombre;
	private Timestamp cuestionarioFechaInicio;
	private Timestamp cuestionarioFechaFin;
	private Timestamp fechaAsignacion;
	private Timestamp fechaFinalizacion;
	private Integer seguimientoCodigo;
	private String seguimientoNombre;
	private Integer estado;
	
}
