package com.ciber.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Curso {

	private Integer codigo;
	private String nombre;
	private Integer instructor;
	private String NombreInstructor;
	private String descripcion;
	private String fecha;
	private Integer estado;
	
	//private static final long serialVersionUID = 1L;
}
