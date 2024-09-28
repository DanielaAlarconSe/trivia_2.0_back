package com.ciber.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RespuestaCuestionario {
	
	private int codigo;
	private String estudianteNombre;
	private int cuestionarioCodigo;
	private Date fechaRegistro; 
	private float calificacionTotal;

}
