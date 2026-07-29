package com.generation.lojagames.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.lojagames.model.Usuario;


public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	//ATRIBUTOS PADRÕES
	private String username;
	private String password;

	//MÉTODO CONSTRUTOR
	public UserDetailsImpl(Usuario user) {
		this.username = user.getUsuario();
		this.password = user.getSenha();
	}
	
	//MÉTODOS SOBRECARREGADOS
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Collections.emptyList();  
	}

	//RECUPERA USUÁRIO E SENHA
	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}
	
	//MÉTODOS QUE INDICAM RESTRIÇÕES DA CONTA
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}