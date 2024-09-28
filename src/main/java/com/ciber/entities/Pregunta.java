package com.ciber.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pregunta {
	
	private int codigo;
	private String nombre;
	private int cuestionarioCodigo;
	private String cuestionarioNombre;
	private int tipoRespuestaCodigo;
	private String tipoRespuestaNombre;
	private String textoAdicional;
	private int estado;
	
}
