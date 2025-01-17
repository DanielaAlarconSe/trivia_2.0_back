package com.ciber.service;

import java.util.List;

import com.ciber.entities.CuestionarioCategoria;

public interface ICuestionarioCategoriaService {

	public List<CuestionarioCategoria> obtenerCategorias(Integer usuarioTipo);
}
