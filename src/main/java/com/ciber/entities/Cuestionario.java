package com.ciber.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cuestionario {
	
	private Integer codigo;
	private String nombre;
	private String instrucciones;
	private Integer cursoCodigo;
	private String cursoNombre;
	private Timestamp  fechaInicio;
	private Timestamp  fechaFin;
	private Integer estado;

}
