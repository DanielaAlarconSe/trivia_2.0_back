package com.ciber.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Entidad {

	private Integer codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private Timestamp fechaRegistro;
	private Integer estado;
	
}
