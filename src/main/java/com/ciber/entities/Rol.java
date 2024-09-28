package com.ciber.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rol implements Serializable {

	private int codigo;

	private String nombre;

	@Override
	public String toString() {
		return "Role [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

	private static final long serialVersionUID = 1L;
}
