package com.ciber.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario {

	private int codigo;
	private String username;
	private String password;
	private boolean state;
	private PersonaUsuario persona;
	private int role;

}