package com.ciber.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RespuestaTipo {
	private int codigo;
	private String nombre;
	private int estado;
}
