package com.ciber.entities;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario {

	private Integer codigo;
	private Timestamp hora;
	private String username;
	private String password;
	private PersonaUsuario persona;
	private Integer tipoUsurioCodigo;
	private String tipoUsurioNombre;
	private Integer entidadCodigo;
	private String entidadNombre;
	private Integer role;
	private String token;
	private boolean state;

}