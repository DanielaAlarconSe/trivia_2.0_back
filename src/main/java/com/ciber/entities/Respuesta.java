package com.ciber.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Respuesta {
	
	private int codigo;
	private int respuestaCuestionarioCodigo;
	private int preguntaRespuestaCodigo;
	private int preguntaCodigo;
	private Date fechaRegistro;

}
