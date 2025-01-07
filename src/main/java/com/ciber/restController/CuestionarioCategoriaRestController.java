package com.ciber.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.entities.CuestionarioCategoria;
import com.ciber.service.ICuestionarioCategoriaService;

@RestController
@RequestMapping(path = "categoria")
public class CuestionarioCategoriaRestController {

	@Autowired
	ICuestionarioCategoriaService service;

	@GetMapping(path = "obtener-categoria/{usuarioTipo}")
	public List<CuestionarioCategoria> obtenerCategorias(@PathVariable Integer usuarioTipo) {
		return service.obtenerCategorias(usuarioTipo);
	}
}