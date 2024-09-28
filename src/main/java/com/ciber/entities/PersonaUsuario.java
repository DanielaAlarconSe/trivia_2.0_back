package com.ciber.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaUsuario  implements Serializable {

	private int codigo;
	
	private String identificacion;
	
	private String libretaMilitar;

	private String nombre;

	private String apellido;
	
	private int lugarExpedición;
	
	private String expedicion;
	
	private String edad;
	
	private static final long serialVersionUID = 1L;
	

}
