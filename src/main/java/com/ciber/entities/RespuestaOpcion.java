package com.ciber.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RespuestaOpcion {
	
	private int codigo;
	private String nombre;
	private int cuestionarioCodigo;
	private String cuestionarioNombre;
	private Float puntuacion;
	private int estado;

}
