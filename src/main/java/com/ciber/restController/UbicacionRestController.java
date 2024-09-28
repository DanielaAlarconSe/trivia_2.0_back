package com.ciber.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.entities.Pais;
import com.ciber.service.IUbicacionService;

@RestController
@RequestMapping(path = "ubicacion")
public class UbicacionRestController {

	@Autowired
	IUbicacionService ubicacionService;

	@GetMapping(path = "obtener-pais-local")
	public List<Pais> obtenerPaisLocal() {

		return ubicacionService.obtenerPaisLocal();

	}

	@GetMapping(path = "obtener-paises")
	public List<Pais> obtenerPaises() {

		return ubicacionService.obtenerPaises();

	}
}
