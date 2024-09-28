package com.ciber.dao;

import java.util.List;

import com.ciber.entities.Pais;

public interface IUbicacionDao {
	
	public List<Pais> obtenerPaisLocal();
	
	public List<Pais> obtenerPaises();
	
}
