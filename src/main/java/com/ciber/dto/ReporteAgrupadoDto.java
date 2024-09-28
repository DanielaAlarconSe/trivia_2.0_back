package com.ciber.dto;

import java.sql.Timestamp;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReporteAgrupadoDto {
	
	private String estudianteNombre;
	private Timestamp fechaRegistro;
	private Map<String, String> columnas;
	private float calificacion;

}
