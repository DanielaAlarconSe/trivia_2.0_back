package com.ciber.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AsignacionDto {

	private Integer usuariocodigo;
	private String usuarioNombre;
	private Integer asignacionCodigo;
	private Integer cuestionarioCodigo;
	private Timestamp fechaAsignacion;
	private Timestamp fechaFinalizacion;
	private Integer estado;
	private String seguimientoNombre;
	
}
