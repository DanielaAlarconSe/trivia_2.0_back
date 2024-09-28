package com.ciber.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciber.auth.CustomPasswordEncode;
import com.ciber.dao.IUsuarioDao;
import com.ciber.dto.UsuarioDto;
import com.ciber.entities.Rol;
import com.ciber.entities.Usuario;
import com.ciber.service.IUsuarioService;
import com.ciber.util.DisabledException;

@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService {

	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private IUsuarioDao usuariodao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (!usuariodao.validarUsuario(username)) {
			logger.error("Error, no exite el usuario '" + username + "' en el sistema!!!");
			throw new DisabledException("No exite el usuario en el sistema.");
		}
		Usuario usuario = usuariodao.buscarUsuario(username);

		// System.out.print("USUARIO:::" + usuario);
		// con este List sacamos todos los roles del usuario que se esta autenticando
		ArrayList<Rol> roles = new ArrayList<>();
		List<GrantedAuthority> authorities = roles.stream()
				.map(role -> new SimpleGrantedAuthority(((Rol) role).getNombre()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isState(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarUsuario(String username) {
		return usuariodao.buscarUsuario(username);
	}

	@Override
	public int registrarUsuario(UsuarioDto usuario) {

		CustomPasswordEncode passwordEncoder = new CustomPasswordEncode();

		String clave = passwordEncoder.encode(usuario.getContrasena());

		System.out.println("clave encriptada " + clave);

		UsuarioDto usuario2 = new UsuarioDto();
		usuario2.setCodigo(usuario.getCodigo());
		usuario2.setTipo(usuario.getTipo());
		usuario2.setUsuario(usuario.getUsuario());
		usuario2.setContrasena(clave);

		System.out.println("usuario 2 " + usuario2);
		return usuariodao.registrarUsuario(usuario2);
	}

	@Override
	public int actualizarUsuario(UsuarioDto usuario) {
		CustomPasswordEncode passwordEncoder = new CustomPasswordEncode();

		String clave = passwordEncoder.encode(usuario.getContrasena());

		System.out.println("clave encriptada " + clave);

		UsuarioDto usuario2 = new UsuarioDto();
		usuario2.setCodigo(usuario.getCodigo());
		usuario2.setTipo(usuario.getTipo());
		usuario2.setContrasena(clave);

		System.out.println("usuario 2 " + usuario2);

		return usuariodao.actualizarUsuario(usuario2);
	}

	@Override
	public int eliminarUsuario(UsuarioDto usuario) {
		return usuariodao.eliminarUsuario(usuario);
	}

}
