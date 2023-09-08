package com.hotel.modelo;

public class Usuario {
	
	private String nombre;
	private String contrasenha;
	
	public Usuario(String usuarioInput, String contrasenhaInput) {
		this.nombre = usuarioInput;
		this.contrasenha = contrasenhaInput;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getContrasenha() {
		return contrasenha;
	}

}
