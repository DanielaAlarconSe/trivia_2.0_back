package com.ciber.dao;

import java.util.List;

import com.ciber.entities.CuestionarioCategoria;

public interface ICuestionarioCategoriaDao {

	public List<CuestionarioCategoria> obtenerCategorias(Integer usuarioTipo);
}
