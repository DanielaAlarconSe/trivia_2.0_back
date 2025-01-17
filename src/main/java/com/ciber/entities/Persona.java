package com.ciber.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona {

	private int codigo;
	private String nombre;
	private String apellido;
	private int paisResidencia;
	private String correo;
	private Date fechaRegistro;
	private String nombrePaisResidencia;
	private int estado;
}