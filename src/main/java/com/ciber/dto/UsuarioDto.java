package com.ciber.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDto {
	private Integer codigo;
	private String usuario;
	private String contrasena;
	private Integer tipo;
	private Integer entidad;
	private String token;
	private Integer estado;
}