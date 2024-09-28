package com.ciber.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona implements Serializable {

	private int codigo;
	
	private String nombre;

	private String apellido;
	
	private int paisResidencia;
		
	private String correo;
	
	private int estado;
	
	private Date fechaRegistro;
	
	private String nombrePaisResidencia;
	
	private static final long serialVersionUID = 1L;
}