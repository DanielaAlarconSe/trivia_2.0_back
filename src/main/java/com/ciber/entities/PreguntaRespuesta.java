package com.ciber.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PreguntaRespuesta {
	
	private int codigo;
	private int cuestionarioCodigo;
	private String cuestionarioNombre;
	private int preguntaCodigo;
	private String preguntaNombre;
	private int respuestaOpcionCodigo;
	private String respuestaOpcionNombre;
	private float puntuacion;
	private int estado;

}
