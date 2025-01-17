package com.ciber.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AsignacionTrivia {

	private Integer codigo;
	private Integer usuario;
	private Integer cuestionario;
	private Timestamp fechaAsignacion;
	private Timestamp fechaFinalizacion;
	private Integer seguimiento;
	private Integer estado;
	
}
