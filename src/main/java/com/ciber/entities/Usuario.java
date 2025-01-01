package com.ciber.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario {

	private Integer codigo;
	private String username;
	private String password;
	private PersonaUsuario persona;
	private Integer tipoUsurioCodigo;
	private String tipoUsurioNombre;
	private Integer entidadCodigo;
	private String entidadNombre;
	private Integer role;
	private boolean state;

}