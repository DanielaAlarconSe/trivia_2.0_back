package com.ciber.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.ciber.entities.Usuario;
import com.ciber.serviceImpl.UsuarioServiceImpl;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.buscarUsuario(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "*".concat(authentication.getName()));
		info.put("per_codigo", usuario.getPersona().getCodigo());
		info.put("nombre", usuario.getPersona().getNombre());
		info.put("apellido",usuario.getPersona().getApellido());
		info.put("role",usuario.getRole());
		
		
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		System.out.println("::::" + accessToken);
		
		return accessToken;
	}

}