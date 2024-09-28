package com.ciber.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciber.dao.IUsuarioTipoDao;
import com.ciber.entities.UsuarioTipo;
import com.ciber.service.IUsuarioTipoService;

@Service
public class UsuarioTipoServiceImpl implements IUsuarioTipoService{

	@Autowired
	IUsuarioTipoDao dao;
	
	@Override
	public List<UsuarioTipo> obtenerTipoUsuario() {
		return dao.obtenerTipoUsuario();
	}

}
