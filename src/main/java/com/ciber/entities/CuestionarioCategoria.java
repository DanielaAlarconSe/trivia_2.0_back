package com.ciber.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CuestionarioCategoria {
	private Integer codigo;
	private String nombre;
	private String descripcion;
}
